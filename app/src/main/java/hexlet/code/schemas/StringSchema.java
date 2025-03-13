package hexlet.code.schemas;

import java.util.Objects;

/**
 * The {@code StringSchema} class is a concrete implementation of {@code BaseSchema}
 * specifically designed for validating string values. It provides methods to add
 * validations such as required, minimum length, and substring containment.
 */
public final class StringSchema extends BaseSchema<String> {


    public StringSchema() {
        addValidation("required", obj -> {
            return Objects.nonNull(obj);
        });
    }
    /**
     * Adds a validation to ensure that the string is not null and not empty.
     *
     * @return The current StringSchema instance for method chaining.
     */
    public StringSchema required() {
        strictNullChecking = true;
        addValidation("required", obj -> {
            return Objects.nonNull(obj) && !obj.isEmpty();
        });
        return this;
    }

    /**
     * Adds a validation to ensure that the string's length is greater than or equal to the specified minimum length.
     *
     * @param min The minimum required length of the string.
     * @return The current StringSchema instance for method chaining.
     */
    public StringSchema minLength(final int min) {
        addValidation("minLength", obj -> {
            return obj.length() >= min;
        });
        return this;
    }

    /**
     * Adds a validation to ensure that the string contains a specific substring.
     *
     * @param str The substring that must be contained within the string.
     * @return The current StringSchema instance for method chaining.
     */
    public StringSchema contains(final String str) {
        addValidation("contains", obj -> obj.contains(str));
        return this;
    }
}