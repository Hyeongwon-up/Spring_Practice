package Hyeongwon.Spring_Practice.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    @Around("execution(* Hyeongwon.Spring_Practice..*(..)) ")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toLongString());

        try {


            Object result = joinPoint.proceed();
            return result;

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish-start;
            System.out.println("End: " + joinPoint.toLongString() + " " + timeMs + "ms");
        }
    }
}
