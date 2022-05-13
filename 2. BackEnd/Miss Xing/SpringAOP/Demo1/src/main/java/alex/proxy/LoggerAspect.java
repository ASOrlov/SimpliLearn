package alex.proxy;

public class LoggerAspect {
    public void logBefore(){
        System.out.println("Logging before method is being executed ...");
    }

    public void logAfter(){
        System.out.println("Logging after method is being executed ...");
    }
}
