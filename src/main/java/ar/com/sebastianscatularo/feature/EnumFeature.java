package ar.com.sebastianscatularo.feature;

import org.springframework.stereotype.Component;
import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

/**
 * @author sebastianscatularo@gmail.com
 */
@Component
public enum EnumFeature implements Feature {
    @Label("Feature one")
    ONE,
    @Label("Feature two")
    TWO;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
