package info.fingo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.bind.Name;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class SingletonController {

    private final SingletonService singletonService;

    public SingletonController(SingletonService singletonService) {
        this.singletonService = singletonService;
    }

    @GetMapping("/singleton")
    public int get() {
        return this.singletonService.incrementAndGet();
    }
}
