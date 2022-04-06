package info.fingo.servlet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LongRequestController {

    @GetMapping("long")
    public long longTask() {
        System.out.println("starting long request using thread " + Thread.currentThread());
        try {
            Thread.sleep(30_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Long request ended " + Thread.currentThread());
        return Thread.currentThread().getId();
    }
}
