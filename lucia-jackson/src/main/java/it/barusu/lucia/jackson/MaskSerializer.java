package it.barusu.lucia.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class MaskSerializer extends StdSerializer<String> implements ContextualSerializer {
    public static final String DEFAULT_REGEX = "(.)(.*)(.)";

    private String regex = DEFAULT_REGEX;

    public MaskSerializer() {
        super(String.class);
    }

    public MaskSerializer(String regex) {
        super(String.class);
        this.regex = regex;
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) {
        if (property == null) {
            return null;
        }

        Mask mask = property.getAnnotation(Mask.class);
        if (mask != null) {
            return new MaskSerializer(mask.regex());
        }

        return new MaskSerializer();
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.replaceAll(regex, "$1***$3"));
    }
}
