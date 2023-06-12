package edu.kh.project.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.kh.project.common.interceptor.BoardTypeInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

	@Bean
	public BoardTypeInterceptor boardTypeInterceptor() {
		return new BoardTypeInterceptor();
	}
	
	/* 
	 * @Bean public BoardTypeInterceptor 다른Interceptor() { return new
	 * 다른Interceptor(); }
	 */

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// Bean으로 등록된 BoardTypeInterceptor를 얻어와 인터셉터로 등록
		registry.addInterceptor(boardTypeInterceptor())
		.addPathPatterns("/**")   // 가로챌 경로 지정(여러개 작성 시 콤마로 구분)
		.excludePathPatterns("/css/**", "/image/**", "/js/**");  // 가로채지 않을 경로
		
		
		// 인터셉터를 여러개 만들었을 경우 interceptorConfig 클래스를 여러개
		// 작성할 필요 없이 bean등록 + 인터셉터 등록을 인터셉터 클래스만큼 해주면 됨

	}
	
	
	
	
}
