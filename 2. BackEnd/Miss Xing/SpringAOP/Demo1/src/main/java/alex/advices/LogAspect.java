package alex.advices;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Before("execution(* alex.advices.AccountService.*(..))")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("Log before executing ..."+joinPoint.getSignature().getName());
        System.out.println(joinPoint.getTarget().getClass().getName());
        System.out.println(joinPoint.getArgs());
        System.out.println(joinPoint.getThis().getClass().getName());
    }

    @After("execution(* alex.advices.CustomerService.* (..))")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("Log after executing---");
    }

    @AfterReturning(pointcut = "execution(* *(..))",returning = "myname")
    public void afterReturning(String myname){
        System.out.println("Return value: "+myname);

    }

    @AfterThrowing(pointcut = "execution(* getAge(..))",throwing = "mythrow")
    public void afterThrowing(JoinPoint joinPoint, MyException mythrow){
        System.out.println(joinPoint.getSignature().getName()+" throw exception: "+mythrow.getMsg());

    }

    @Around("execution(* alex.advices.CustomerServiceImpl.calculatePayment (double, int))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint){
        Object[] args=joinPoint.getArgs();
        System.out.println("Args in Around Advice: " + args[0]+", "+args[1]);


        args[0]=30;
        args[1]=9;

        Object result=null;
        try {
            result=joinPoint.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("Result in around advice: " + result);

        return 60.0;

       // return 30.00;
    }

}
