package info.fingo.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class C {

    private final D d;

    public C(D d) {
        this.d = d;
    }
}
