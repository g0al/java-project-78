package hexlet.code.schemas;

import java.util.Objects;

public final class StringSchema extends BaseSchema<String> {

    public StringSchema required() {
        addValidation("required", obj -> {
            return Objects.nonNull(obj) && !obj.isEmpty();
        });
        return this;
    }

    public StringSchema minLength(int min) {
        addValidation("minLength", obj -> {
            return Objects.nonNull(obj) && obj.length() >= min;
        });
        return this;
    }

    public StringSchema contains(String str) {
        addValidation("contains", obj -> obj == null || obj.contains(str));
        return this;
    }
}
