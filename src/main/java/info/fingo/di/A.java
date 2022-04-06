package info.fingo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class A {

    private B b;

    @Autowired
    public void setSecond(B b) {
        this.b = b;
    }
}
