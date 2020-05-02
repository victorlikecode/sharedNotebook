package victor.notebook.aop;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import victor.notebook.util.SystemConstant;

@Aspect
@Component
@Order(1)
public class SessionAop {

	@Autowired
	private SystemConstant systemConstant;
	@Pointcut("@annotation(victor.notebook.annotation.SessionFilter) && execution(public * victor.notebook.controller.*.*(..))")
	public void pointCut() {
		
	}
	
	@Around("pointCut()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		try {
			if (Objects.isNull(request.getSession().getAttribute(systemConstant.CurrentUser))) {
                return "redirect:/member/login";
            }
		}catch(Exception e) {
			return "redirect:/member/login";
		}
		return proceedingJoinPoint.proceed();
		
	}
}
