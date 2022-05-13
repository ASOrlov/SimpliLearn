package alex.proxy;

public class CustomerServiceProxy extends CustomerService{
    public void doSomething(){

        LoggerAspect loggerAspect=new LoggerAspect();
        loggerAspect.logBefore();

        super.doSomething();

        loggerAspect.logAfter();

    }
}
