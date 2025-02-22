
package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

/**
 * Javadoc for MapSchema class.
 */
public final class MapSchema extends BaseSchema<Map<String, ?>> {

    public MapSchema required() {
        addValidation("required", obj -> Objects.nonNull(obj));
        return this;
    }

    public MapSchema sizeof(int size) {
        addValidation("sizeof", obj -> obj.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
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
