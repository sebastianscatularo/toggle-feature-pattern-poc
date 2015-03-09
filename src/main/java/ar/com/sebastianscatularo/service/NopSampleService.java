package ar.com.sebastianscatularo.service;

/**
 * @author sebastianscatularo@gmail.com
 */
public class NopSampleService implements SampleService {
    static final String SOMETHING = "NOP";

    @Override
    public String doSomething() {
        return SOMETHING;
    }
}
