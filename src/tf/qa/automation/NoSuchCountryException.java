package tf.qa.automation;

import java.io.IOException;

public class NoSuchCountryException extends IOException {
    public NoSuchCountryException(final String name) {
        super(name);
    }
}
