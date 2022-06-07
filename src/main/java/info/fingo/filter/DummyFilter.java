package info.fingo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class DummyFilter implements Filter {

    private static Logger LOG = LoggerFactory.getLogger(DummyFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        LOG.info(">> Before call");
        chain.doFilter(request, response);
        LOG.info("<< After call");
    }
}
