package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * The {@code BaseSchema} class serves as an abstract base class for creating
 * various data validation schemas. It provides a mechanism to add and manage
 * validation predicates for different types of data.
 *
 * @param <T> The type of the value to be validated.
 */
public abstract class BaseSchema<T> {

    /**
     * A map storing validation predicates associated with specific keys.
     */
    private final Map<String, Predicate<T>> validations = new HashMap<>();

    /**
     * Adds a validation predicate to the schema.
     *
     * @param key The key associated with the validation.
     * @param validation The predicate representing the validation logic.
     */
    protected void addValidation(final String key,
                                 final Predicate<T> validation) {
        this.validations.put(key, validation);
    }

    /**
     * Checks if the given value is valid according to the added validations.
     *
     * @param value The value to be validated.
     * @return {@code true} if the value is valid, {@code false} otherwise.
     */
    public boolean isValid(final T value) {
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
    }
}
