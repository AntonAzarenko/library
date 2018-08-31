package library.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StopWatch;

@Aspect
public class BenchmarkAspect {

    /** Logger. */
    private final Logger logger = Logger.getLogger(this.getClass());

    @Pointcut("execution(* library.service..*ServiceImpl.*(..))")
    public void profile() {
    }

    @Around("profile()")
    public Object profile(ProceedingJoinPoint jp) throws Throwable {
        StopWatch sw = new StopWatch(jp.toShortString());

        try {
            sw.start(jp.toShortString());
            return jp.proceed();
        } finally {
            sw.stop();

            if (jp.getSignature() instanceof MethodSignature) {
                StringBuffer sb = new StringBuffer()
                    .append('\'')
                    .append(((MethodSignature) jp.getSignature()).getMethod()
                            .toGenericString())
                    .append('\'')
                    .append(" : running time (millis) = ")
                    .append(sw.getTotalTimeMillis());
                logger.debug(sb.toString());
            } else {
                logger.debug(sw.shortSummary());
            }
        }
    }
}
