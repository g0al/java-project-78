package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapSchemaTest {

    @Test
    void testSizeof() {
        Validator validator = new Validator();
        var schema = validator.map().sizeof(2);

        var map1 = Map.of("key1", "value1");
        var map2 = Map.of("key1", "value1", "key2", "value2");

        assertEquals(true, schema.isValid(map2));
        assertEquals(true, schema.isValid(null));
        assertEquals(false, schema.isValid(map1));
        assertEquals(false, schema.isValid(Map.of()));

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("key1", validator.string().required());
        schemas.put("key2", validator.string().required());
        var nestedSchema = validator.map().shape(schemas);

        Map<String, Object> nestedMap1 = new HashMap<>();
        nestedMap1.put("key1", "value1");
        Map<String, Object> nestedMap2 = new HashMap<>();
        nestedMap2.put("key1", "value1");
        nestedMap2.put("key2", "value2");

        assertEquals(true, nestedSchema.isValid(nestedMap2));
        assertEquals(false, nestedSchema.isValid(nestedMap1));

    }

    @Test
    void testRequired() {
        Validator validator = new Validator();
        var schema = validator.map();

        var map = Map.of("key1", "value1");
        assertEquals(true, schema.isValid(null));
        assertEquals(true, schema.isValid(map));
        schema.required();
        assertEquals(true, schema.isValid(map));
        assertEquals(false, schema.isValid(null));

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("key1", validator.string().required());
        var nestedSchema = validator.map().shape(schemas);

        Map<String, Object> nestedMap = new HashMap<>();
        nestedMap.put("key1", "value1");

        assertEquals(true, nestedSchema.isValid(nestedMap));
        assertEquals(true, schema.isValid(Map.of("nested", nestedMap)));
    }
}
