package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private final Map<String, Predicate<T>> validations = new HashMap<>();

    protected void addValidation(String key, Predicate<T> validation) {
        this.validations.put(key, validation);
    }

    public boolean isValid(T value) {
        if (validations.containsKey("required") && (value == null)) {
            return false;
        }
        if (value == null) {
            return true;
        }
        for (Predicate<T> predicate : validations.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }
        return true;
    };
}
