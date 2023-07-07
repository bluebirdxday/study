package edu.kh.project.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import edu.kh.project.chatting.model.websocket.ChattingWebsocketHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	@Autowired
	private ChattingWebsocketHandler chattingWebsocketHandler;
	
	@Autowired
	private HandshakeInterceptor handshakeInterceptor;
	
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		
		// chattingSock이라는 요청이 왔을 때 chattingWebsocketHandler가 해결해줌
		registry.addHandler(chattingWebsocketHandler, "/chattingSock")
						.addInterceptors(handshakeInterceptor)
						.setAllowedOriginPatterns("http://localhost/", "http://127.0.0.1")
						.withSockJS();
		
		// setAllowedOriginPatterns -> 어떤 주소로 요청이 왔을 때 동작을 하게 할 것인가
		// withSockJS() -> 혹시라도 websocket을 지원하지 않는 브라우저가 있으면 sockJS를 사용하겠다
	}

}
