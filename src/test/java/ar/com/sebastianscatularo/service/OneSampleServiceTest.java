package ar.com.sebastianscatularo.service;

import ar.com.sebastianscatularo.configuration.SpringFeatureStrategy;
import ar.com.sebastianscatularo.feature.EnumFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringFeatureStrategy.class)
public class OneSampleServiceTest {
    @Autowired
    private FeatureManager featureManager;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void sampleService() {
        SampleService sampleService;
        sampleService = applicationContext.getBean(SampleService.class);
        assertEquals("By default we get NopSampleService", NopSampleService.SOMETHING, sampleService.doSomething());
        featureManager.setFeatureState(new FeatureState(EnumFeature.ONE, true));
    }
}