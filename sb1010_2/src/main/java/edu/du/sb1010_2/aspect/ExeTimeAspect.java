package edu.du.sb1010_2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Aspect
@Order(1)
public class ExeTimeAspect {

//    @Pointcut("execution(public * *..chap07..*(..))")
//    public void publicTarget() {}

    @Around("execution(* *..chap07..*(..))")
    public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.nanoTime();
        try{
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long endTime = System.nanoTime();
            Signature sig = joinPoint.getSignature();
            System.out.printf("%s.%s(%s) execution time : %d ns\n",
                    joinPoint.getTarget().getClass().getSimpleName(),
                    sig.getName(), Arrays.toString(joinPoint.getArgs()),
                    (endTime - startTime));
        }
    }
}
