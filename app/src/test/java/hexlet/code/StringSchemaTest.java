package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSchemaTest {

    @Test
    void contains() {
        var schema = new StringSchema().contains("wh");
        assertEquals(true, schema.isValid("what does the fox say"));
        assertEquals(false, schema.isValid("hexlet"));
        assertEquals(true, schema.isValid(null));
        assertEquals(false, schema.isValid(""));
    }

    @Test
    void minLength() {
        var schema = new StringSchema().minLength(5);
        assertEquals(true, schema.isValid("hexlet"));
        assertEquals(true, schema.isValid("hello"));
        assertEquals(false, schema.isValid("who"));
        assertEquals(true, schema.isValid(null));
        assertEquals(false, schema.isValid(""));
    }

    @Test
    void required() {
        var schema = new StringSchema();
        assertEquals(true, schema.isValid(null));
        schema.required();
        assertEquals(true, schema.isValid("hexlet"));
        assertEquals(false, schema.isValid(null));
        assertEquals(false, schema.isValid(""));
    }
}
