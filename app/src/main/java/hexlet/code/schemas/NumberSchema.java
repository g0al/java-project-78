package hexlet.code.schemas;

import java.util.Objects;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        addValidation("required", obj -> {
            return Objects.nonNull(obj);
        });
        return this;
    }

    public NumberSchema range(int min, int max) {
        addValidation("rangeValue", obj -> {
            return min <= obj && obj <= max;
        });
        return this;
    }

    public NumberSchema positive() {
        addValidation("positive", obj -> {
            return obj == null || obj > 0;
        });
        return this;
    }
}
