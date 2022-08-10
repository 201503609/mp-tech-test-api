package gt.com.mp.tech.test.web;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author diego
 */
@ApplicationPath("/")
@ApplicationScoped
public class RestApplication extends Application {
}
