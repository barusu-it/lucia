package it.barusu.lucia.jackson;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static it.barusu.lucia.jackson.MaskUtils.DEFAULT_REGEX;
import static it.barusu.lucia.jackson.MaskUtils.DEFAULT_REPLACEMENT;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@JsonSerialize(using = MaskSerializer.class)
@JacksonAnnotationsInside
public @interface Mask {
    MaskType value() default MaskType.REGEX;

    String regex() default DEFAULT_REGEX;

    String replacement() default DEFAULT_REPLACEMENT;
}
