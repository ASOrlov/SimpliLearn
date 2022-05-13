package alex.terms;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* *(..))")

    public void logBefore(){
        System.out.println("logging before method being executed ....");
    }
}
