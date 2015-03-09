package ar.com.sebastianscatularo.provider;

import org.springframework.context.ApplicationContext;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.spi.FeatureManagerProvider;

/**
 * @author sebastianscatularo@gmail.com
 */
public class SpringFeatureManagerProvider implements FeatureManagerProvider {

    private static ApplicationContext applicationContext;

    public static void bind(ApplicationContext ap) {
        applicationContext = ap;
    }

    @Override
    public FeatureManager getFeatureManager() {
        return applicationContext.getBean(FeatureManager.class);
    }

    @Override
    public int priority() {
        return 11;
    }
}
