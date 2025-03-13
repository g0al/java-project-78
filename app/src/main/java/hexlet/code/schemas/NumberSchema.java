package hexlet.code.schemas;

import java.util.Objects;

/**
 * The {@code NumberSchema} class is a concrete implementation of {@code BaseSchema}
 * specifically designed for validating integer values. It provides methods to add
 * validations such as required, range, and positive value checks.
 */
public final class NumberSchema extends BaseSchema<Integer> {


    public NumberSchema() {
        addValidation("required", Objects::nonNull);
    }
    /**
     * Adds a validation to ensure that the number is not null.
     *
     * @return The current NumberSchema instance for method chaining.
     */
    public NumberSchema required() {
        strictNullChecking = true;
        return this;
    }

    /**
     * Adds a validation to ensure that the number falls within a specified range (inclusive).
     *
     * @param min The minimum value of the range.
     * @param max The maximum value of the range.
     * @return The current NumberSchema instance for method chaining.
     */
    public NumberSchema range(final int min, final int max) {
        addValidation("rangeValue", obj -> {
            return min <= obj && obj <= max;
        });
        return this;
    }

    /**
     * Adds a validation to ensure that the number is positive.
     *
     * @return The current NumberSchema instance for method chaining.
     */
    public NumberSchema positive() {
        addValidation("positive", obj -> {
            return obj > 0;
        });
        return this;
    }
}
