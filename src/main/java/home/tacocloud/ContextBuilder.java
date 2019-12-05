package home.tacocloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ContextBuilder {

    @Autowired
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    public void getBeans() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }
}
