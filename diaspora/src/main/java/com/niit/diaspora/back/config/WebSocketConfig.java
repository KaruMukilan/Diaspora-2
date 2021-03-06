package com.niit.diaspora.back.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
//@ComponentScan("com.niit.diaspora")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer{
 
	@Override
	public void configureMessageBroker(MessageBrokerRegistry messageBrokerRegistry){
		messageBrokerRegistry.enableSimpleBroker("/topic");
		messageBrokerRegistry.setApplicationDestinationPrefixes("/app");
	}
	
	

	@Override
	public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
		stompEndpointRegistry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
		
	}
	
}
