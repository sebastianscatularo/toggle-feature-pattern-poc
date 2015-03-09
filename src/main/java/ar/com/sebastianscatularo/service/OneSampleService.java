package ar.com.sebastianscatularo.service;

/**
 * @author sebastianscatularo@gmail.com
 */
public class OneSampleService implements SampleService {
    static final String SOMETHING = "ONE";

    @Override
    public String doSomething() {
        return SOMETHING;
    }
}
