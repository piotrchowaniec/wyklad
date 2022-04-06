package info.fingo.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean("E")
    public E e() {
        return new E();
    }
}
