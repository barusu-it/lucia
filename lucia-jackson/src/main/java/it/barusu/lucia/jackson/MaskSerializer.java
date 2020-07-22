package it.barusu.lucia.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

import java.io.IOException;
import java.util.Objects;

import static it.barusu.lucia.jackson.MaskUtils.DEFAULT_REGEX;
import static it.barusu.lucia.jackson.MaskUtils.DEFAULT_REPLACEMENT;

public class MaskSerializer extends JsonSerializer<String> implements ContextualSerializer {

    private final MaskType type;
    private final String regex;
    private final String replacement;

    public MaskSerializer() {
        this.type = MaskType.REGEX;
        this.regex = DEFAULT_REGEX;
        this.replacement = DEFAULT_REPLACEMENT;
    }

    public MaskSerializer(MaskType type, String regex, String replacement) {
        this.type = type;
        this.regex = regex;
        this.replacement = replacement;
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty property) throws JsonMappingException {
        if (property == null) {
            return prov.findNullValueSerializer(null);
        }

        if (!Objects.equals(property.getType().getRawClass(), String.class)) {
            return prov.findValueSerializer(property.getType(), property);
        }

        Mask mask = property.getAnnotation(Mask.class);
        if (mask == null) {
            mask = property.getContextAnnotation(Mask.class);
        }

        if (mask != null) {
            return new MaskSerializer(mask.value(), mask.regex(), mask.replacement());
        }

        return prov.findValueSerializer(property.getType(), property);
    }

    @Override
    public void serialize(String value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        switch (this.type) {
            case REGEX:
                gen.writeString(MaskUtils.maskRegex(value, regex, replacement));
                break;
            case EMAIL:
                gen.writeString(MaskUtils.maskEmail(value));
                break;
            case MOBILE:
                gen.writeString(MaskUtils.maskMobile(value));
                break;
            case TELEPHONE:
                gen.writeString(MaskUtils.maskTelephone(value));
                break;
            case ID_CARD:
                gen.writeString(MaskUtils.maskIdCard(value));
                break;
            case BANK_CARD:
                gen.writeString(MaskUtils.maskBankCard(value));
                break;
            case NAME:
                gen.writeString(MaskUtils.maskName(value));
                break;
            default:
                gen.writeString(value);
        }
    }
}
