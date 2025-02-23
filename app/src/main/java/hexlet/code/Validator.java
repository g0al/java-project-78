package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

/**
 * The {@code Validator} class provides factory methods to create instances of
 * different schema classes for validating various types of data. It serves as an
 * entry point for creating validation schemas for strings, numbers, and maps.
 */
public class Validator {

    /**
     * Creates and returns a new instance of {@code StringSchema} for validating string values.
     *
     * @return A new instance of {@code StringSchema}.
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creates and returns a new instance of {@code NumberSchema} for validating integer values.
     *
     * @return A new instance of {@code NumberSchema}.
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creates and returns a new instance of {@code MapSchema} for validating map values.
     *
     * @return A new instance of {@code MapSchema}.
     */
    public MapSchema map() {
        return new MapSchema();
    }

}
