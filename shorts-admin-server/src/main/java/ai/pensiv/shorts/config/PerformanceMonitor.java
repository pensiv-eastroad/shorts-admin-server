package shorts.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceMonitor {
    private Logger log = LoggerFactory.getLogger(PerformanceMonitor.class);

    @Around("execution(* ai.pensiv.shorts.service.VideoService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        StringBuilder argsString = new StringBuilder();

        Object o = joinPoint.proceed();

        try {
            argsString.append("Method " + joinPoint.getTarget().getClass().toString() +
                    "." + joinPoint.getSignature().getName() +
                    " execution lasted:" + (System.currentTimeMillis() - start) + " ms" + "\n");

            argsString.append("Args: ");

            Object[] args = joinPoint.getArgs();
            for(Object arg : args){
                argsString.append(arg.toString()).append(", ");
            }

            log.debug(argsString.toString());

        } catch (Exception ex){
            // do nothing
        }

        return o;
    }
}
