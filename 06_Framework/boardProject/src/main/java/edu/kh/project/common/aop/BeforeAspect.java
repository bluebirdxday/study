package edu.kh.project.common.aop;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import edu.kh.project.member.model.dto.Member;


// 보통 AOP와 LOG를 합쳐서 많이 씀

@Order(1)	// 순서, 하나의 타겟에 대한 여러 advice 수행 시 순서 지정
@Component 
@Aspect		// 공통 관심사가 작성된 클래스임을 지정
					//	Pointcut(타겟 지정) + Advice(수행할 코드)
public class BeforeAspect {

	private Logger logger = LoggerFactory.getLogger(BeforeAspect.class);

	// @Before(Pointcut)
	//  execution( [접근제한자(생략가능)] 리턴타입  클래스명   메소드명 ([파라미터]) )
	// 리턴타입 : * (모두)
	// 클래스명 : edu.kh.project..*Impl. (Impl로 끝나는 클래스)
	// 메소드명 : *(..)
//	@Before("execution(* edu.kh.project..*Impl*.*(..))")	// 타겟 수행 전
	
	// 지정된 클래스.메서드에 작성된 @Pointcut() 어노테이션의 내용을 타켓으로 삼는다 
	@Before("CommonPointcut.serviceImplPointcut()")
	public void beforeLog(JoinPoint jp) {		// Advice (수행할 코드)
		
		// 매개변수 JoinPoint jp : AOP의 부가 기능이 적용된 대상의
		// 					객체, 메서드, 파라미터 정보를 얻을 수 있게 해주는 객체
		
		
		// 대상 객체의 간단한 클래스명(패키지 명 제외)
		String className = jp.getTarget().getClass().getSimpleName();
		
		// public void beforeLog(JoinPoint jp)	=> 메서드 시그니처(==메서드 선언부)
		// 에서 메서드명만 얻어옴 => beforeLog
		String methodName = jp.getSignature().getName();

		
		String str = "-------------------------------------------------------------------\n";

		str += "[Start] : " + className + " - " + methodName + "()\n";
		// [Start] : MemberServiceImpl - login()
		
		// jp.getArgs() : 파라미터 묶음(배열)
		str += "[Parameter] : " + Arrays.toString(jp.getArgs());
		
		
	     try {
	         // 접속자 IP 얻어오기
	         HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	         Member loginMember = (Member)req.getSession().getAttribute("loginMember");
	         
	         str += "[ip]" + getRemoteAddr(req);
	         if(loginMember != null) {
	            str += "(email:" + loginMember.getMemberEmail() + ")";
	         }
	      }catch (Exception e) {
	         str += "[스프링 스케쥴러]";
	      }
		
		logger.info(str);
	}
	
	
		// IPv6 형식으로 되어있어서 IPv4형태로 바꿔줘야됨 
		// => Servers 탭에 서버 overview의 open launch configure => arguments 
		//	=> VM arguments 맨 뒤에 -Djava.net.preferIPv4Stack=true 붙여넣기
		// 자바에서 ip 얻어오는 메서드
	   public static String getRemoteAddr(HttpServletRequest request) {

	        String ip = null;

	        ip = request.getHeader("X-Forwarded-For");

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("Proxy-Client-IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("WL-Proxy-Client-IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("HTTP_CLIENT_IP"); 
	        } 

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("X-Real-IP"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("X-RealIP"); 
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getHeader("REMOTE_ADDR");
	        }

	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
	            ip = request.getRemoteAddr(); 
	        }

	      return ip;
	   }
	
	
	
	
	
}
