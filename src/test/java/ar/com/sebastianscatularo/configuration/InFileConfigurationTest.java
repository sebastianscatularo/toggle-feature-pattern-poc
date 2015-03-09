package ar.com.sebastianscatularo.configuration;

import ar.com.sebastianscatularo.feature.EnumFeature;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InFileConfiguration.class)
public class InFileConfigurationTest {

    @Test
    public void features() {
        String name = getClass().getClassLoader().getResource("features.properties").getPath();
        System.out.println(name);
        assertTrue(new File(getClass().getClassLoader().getResource("features.properties").getFile()).exists());
        assertTrue(EnumFeature.ONE.isActive());
        assertFalse(EnumFeature.TWO.isActive());
    }
}