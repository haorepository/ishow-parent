package com.java.wisdom.group.ishow.igateway.filter;


import com.google.gson.Gson;
import org.reactivestreams.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.Charset;

@Component
@SuppressWarnings("all")
public class WrapperResponseFilter implements GlobalFilter, Ordered {
	private static final Logger logger =
			LoggerFactory.getLogger(WrapperResponseFilter.class);
	
//	private List<String> skipAuthUrls(){
//		return Arrays.asList("/im-user-client/user/login","/get/timestamp");
//	}

	@Override
	public int getOrder() {
		return -2;
	}

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		logger.info("Into WrapperResponseFilter");
		logger.info("Received a request: {}",exchange.getRequest().getURI().toString());
		return chain.filter(exchange);
	}
	private Mono<Void> success(ServerWebExchange exchange, GatewayFilterChain chain){
		ServerHttpResponse originalResponse = exchange.getResponse();
        DataBufferFactory bufferFactory = originalResponse.bufferFactory();
		ServerHttpResponseDecorator decoratedResponse = new ServerHttpResponseDecorator(originalResponse) {
            @Override
            public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
                if (body instanceof Flux) {
                    Flux<? extends DataBuffer> fluxBody = (Flux<? extends DataBuffer>) body;
                    return super.writeWith(fluxBody.map(dataBuffer -> {
                        // probably should reuse buffers
                        byte[] content = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(content);
                        // 释放掉内存
                        DataBufferUtils.release(dataBuffer);
                        String rs = new String(content, Charset.forName("UTF-8"));
                        
                       // ResultDataVO result = new Gson().fromJson(rs, ResultDataVO.class);
                        //System.out.println(result.toString());
                        //logger.info(result.toString());
                        byte[] newRs = new String(content, Charset.forName("UTF-8")).getBytes();
                        //如果不重新设置长度则收不到消息。
                        originalResponse.getHeaders().setContentLength(newRs.length);
                        return bufferFactory.wrap(newRs);
                    }));
                }
                // if body is not a flux. never got there.
                return super.writeWith(body);
            }
        };
        // replace response with decorator
        return chain.filter(exchange.mutate().response(decoratedResponse).build());
	}
	
	
	/**
     * 认证错误输出
     * @param resp 响应对象
     * @param mess 错误信息
     * @return
     */
    private Mono<Void> authErro(ServerHttpResponse resp) {
        resp.setStatusCode(HttpStatus.UNAUTHORIZED);
//		ResponseData data = new ResponseData();
//		data.setCode("500");
//		data.setMsg("Bad Gateway...");
		String s = "Bad Gateway...";
        String responseJson = new Gson().toJson(s);
        DataBuffer buffer = resp.bufferFactory().wrap(responseJson.getBytes());
        return resp.writeWith(Flux.just(buffer));
    }
    
    /**
     * 验证时间是否过期
     * @param timestamp
     * @return
     */
    private boolean verifyTimestamp(String timestamp){
    	long currentTimeMillis = System.currentTimeMillis();
    	long oldTimestamp = Long.valueOf(timestamp).longValue();
    	if(currentTimeMillis-oldTimestamp<60*1000){
    		return true;
    	}
    	return false;
    }

}
