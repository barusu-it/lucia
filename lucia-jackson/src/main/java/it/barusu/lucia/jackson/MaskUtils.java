package it.barusu.lucia.jackson;

import java.util.regex.Pattern;

public class MaskUtils {

    public static final String DEFAULT_REGEX = "(.)(.*)(.)";
    public static final String DEFAULT_REPLACEMENT = "$1***$3";

    public static String maskRegex(String value, String regex, String replacement) {
        if (value == null) return null;
        return Pattern.compile(regex).matcher(value).replaceAll(replacement);
    }

    public static String maskMobile(String value) {
        if (value == null) return null;
        return Pattern.compile("(\\d{3})(\\d{4})(\\d{4})").matcher(value).replaceAll("$1****$3");
    }

    public static String maskTelephone(String value) {
        if (value == null) return null;
        return Pattern.compile("(\\d+)(\\d{4})").matcher(value).replaceAll("****$2");
    }

    public static String maskBankCard(String value) {
        if (value == null) return null;
        return Pattern.compile("(\\d{6})(\\d+)(\\d{4})").matcher(value).replaceAll("$1******$3");
    }

    public static String maskEmail(String value) {
        if (value == null) return null;
        return Pattern.compile("(\\S)(\\S*)([@]\\S+)").matcher(value).replaceAll("$1***$3");
    }

    public static String maskIdCard(String value) {
        if (value == null) return null;
        return Pattern.compile("(\\d*)([\\d|X]{4})").matcher(value).replaceAll("**************$2");
    }

    public static String maskName(String value) {
        if (value == null) return null;
        if (value.trim().length() > 2) {
            return Pattern.compile("(?<=\\S)\\S+(?=\\S)").matcher(value).replaceAll("*");
        }

        return Pattern.compile("\\S+(?=\\S)").matcher(value).replaceAll("*");
    }

}