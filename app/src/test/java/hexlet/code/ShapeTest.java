package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import hexlet.code.schemas.BaseSchema;

public class ShapeTest {
    public static void main(String[] args) {

        var v = new Validator();
        var schema = v.map();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());
        schemas.put("lastName", v.string().required().minLength(2));
        schema.shape(schemas);

        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        schema.isValid(human1);

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        schema.isValid(human2);

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        schema.isValid(human3);
    }
}
