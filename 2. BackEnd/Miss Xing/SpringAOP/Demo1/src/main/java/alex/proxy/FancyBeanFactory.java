package alex.proxy;

public class FancyBeanFactory {
    public Object getBean(String beanName) {
        if ("customerService".equals(beanName)) return new CustomerServiceProxy();
        else
            return null;
    }
}
