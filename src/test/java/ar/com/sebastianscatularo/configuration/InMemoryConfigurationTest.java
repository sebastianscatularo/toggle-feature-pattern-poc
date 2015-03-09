package ar.com.sebastianscatularo.configuration;

import ar.com.sebastianscatularo.feature.EnumFeature;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.repository.FeatureState;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InMemoryConfiguration.class)
public class InMemoryConfigurationTest {

    @Autowired
    private FeatureManager featureManager;

    @Before
    public void init() {
        featureManager.setFeatureState(new FeatureState(EnumFeature.ONE, true));
    }

    @Test
    public void featureStates() {
        assertTrue(EnumFeature.ONE.isActive());
        assertFalse(EnumFeature.TWO.isActive());
    }
}