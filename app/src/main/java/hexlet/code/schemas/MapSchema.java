package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

/**
 * This class represents a schema for validating maps. It extends the BaseSchema class
 * and provides methods to add various validations to the map schema.
 */
public final class MapSchema extends BaseSchema<Map<String, ?>> {

    public MapSchema() {
        addValidation("required", Objects::nonNull);
    }

    /**
     * Adds a validation to ensure that the map is not null.
     *
     * @return The current MapSchema instance for method chaining.
     */
    public MapSchema required() {
        strictNullChecking = true;
        return this;
    }

    /**
     * Adds a validation to ensure that the map has a specific size.
     *
     * @param size The required size of the map.
     * @return The current MapSchema instance for method chaining.
     */
    public MapSchema sizeof(final int size) {
        addValidation("sizeof", obj -> obj.size() == size);
        return this;
    }

    /**
     * Adds a validation to ensure that the map matches a given shape, where each key
     * in the map conforms to a specific schema.
     *
     * @param schemas A map of key-schema pairs that define the required shape.
     * @param <T> The type of the value to be validated.
     * @return The current MapSchema instance for method chaining.
     */
    public <T> MapSchema shape(final Map<String, BaseSchema<T>> schemas) {
        addValidation("shape", map -> {
            for (Map.Entry<String, BaseSchema<T>> stringBaseSchemaEntry : schemas.entrySet()) {
                String key = stringBaseSchemaEntry.getKey();
                BaseSchema<T> schema = stringBaseSchemaEntry.getValue();
                T value = (T) map.get(key);

                if (!schema.isValid(value)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
