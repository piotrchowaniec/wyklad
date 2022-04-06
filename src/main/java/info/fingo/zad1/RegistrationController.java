package info.fingo.zad1;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("registration")
public class RegistrationController {

    private final UserRepository userRepository;

    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public RegistrationResult register(@RequestParam(name = "name") String userName) {
        return new RegistrationResult("OK", userRepository.register(userName));
    }

    @DeleteMapping
    public void delete(@RequestParam String name) {
        userRepository.delete(name);
    }

    @GetMapping
    public Map<String, Integer> getStats(@RequestParam(required = false, defaultValue = "SHORT") StatisticsMode mode) {
        return userRepository.getStats(mode);
    }
}
