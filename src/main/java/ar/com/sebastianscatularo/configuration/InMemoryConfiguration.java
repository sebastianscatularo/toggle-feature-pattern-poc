package ar.com.sebastianscatularo.configuration;

import ar.com.sebastianscatularo.feature.EnumFeature;
import ar.com.sebastianscatularo.provider.SpringFeatureManagerProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.repository.mem.InMemoryStateRepository;
import org.togglz.core.user.NoOpUserProvider;

import javax.annotation.PostConstruct;

/**
 * @author sebastianscatularo@gmail.com
 */
@Configuration
public class InMemoryConfiguration {
    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        SpringFeatureManagerProvider.bind(applicationContext);
    }

    @Bean
    public FeatureManager featureManager() {
        return new FeatureManagerBuilder()
                .featureEnums(EnumFeature.class)
                .stateRepository(new InMemoryStateRepository())
                .userProvider(new NoOpUserProvider())
                .build();
    }
}