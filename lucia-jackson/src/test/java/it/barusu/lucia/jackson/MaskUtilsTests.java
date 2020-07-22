package it.barusu.lucia.jackson;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@Slf4j
public class MaskUtilsTests {

    @Test
    public void testMobile() {
        String text = "13501608175";
        String maskText = MaskUtils.maskMobile(text);
        assertEquals(maskText, "135****8175");

        String shortText = "1350334333";
        String maskShortText = MaskUtils.maskMobile(shortText);
        assertEquals(maskShortText, shortText);

        String longText = "135033433355";
        String maskLongText = MaskUtils.maskMobile(longText);
        assertEquals(maskLongText, "135****33355");

        String nullText = null;
        //noinspection ConstantConditions
        String maskNullText = MaskUtils.maskMobile(nullText);
        //noinspection ConstantConditions
        assertNull(maskNullText);

        String blankText = "    ";
        String maskBlankText = MaskUtils.maskMobile(blankText);
        assertEquals(maskBlankText, blankText);
    }


    @Test
    public void testTelephone() {
        String text = "62512361";
        String maskText = MaskUtils.maskTelephone(text);
        assertEquals(maskText, "****2361");

        String shortText = "2512361";
        String maskShortText = MaskUtils.maskTelephone(shortText);
        assertEquals(maskShortText, "****2361");

        String longText = "762512361";
        String maskLongText = MaskUtils.maskTelephone(longText);
        assertEquals(maskLongText, "****2361");

        String nullText = null;
        //noinspection ConstantConditions
        String maskNullText = MaskUtils.maskTelephone(nullText);
        //noinspection ConstantConditions
        assertNull(maskNullText);

        String blankText = "    ";
        String maskBlankText = MaskUtils.maskTelephone(blankText);
        assertEquals(maskBlankText, blankText);
    }

    @Test
    public void testBankCard() {
        String text = "62238800100120045";
        String maskText = MaskUtils.maskBankCard(text);
        assertEquals(maskText, "622388******0045");

        String shortText = "6223880010120045";
        String maskShortText = MaskUtils.maskBankCard(shortText);
        assertEquals(maskShortText, "622388******0045");

        String longText = "622388001500120045";
        String maskLongText = MaskUtils.maskBankCard(longText);
        assertEquals(maskLongText, "622388******0045");

        String nullText = null;
        //noinspection ConstantConditions
        String maskNullText = MaskUtils.maskBankCard(nullText);
        //noinspection ConstantConditions
        assertNull(maskNullText);

        String blankText = "    ";
        String maskBlankText = MaskUtils.maskBankCard(blankText);
        assertEquals(maskBlankText, blankText);
    }


    @Test
    public void testEmail() {
        String text = "norxiva@qq.com";
        String maskText = MaskUtils.maskEmail(text);
        assertEquals(maskText, "n***@qq.com");

        String shortText = "n@qq.com";
        String maskShortText = MaskUtils.maskEmail(shortText);
        assertEquals(maskShortText, "n***@qq.com");

        String longText = "  norxiva@qq.com";
        String maskLongText = MaskUtils.maskEmail(longText);
        assertEquals(maskLongText, "  n***@qq.com");

        String nullText = null;
        //noinspection ConstantConditions
        String maskNullText = MaskUtils.maskEmail(nullText);
        //noinspection ConstantConditions
        assertNull(maskNullText);

        String blankText = "    ";
        String maskBlankText = MaskUtils.maskEmail(blankText);
        assertEquals(maskBlankText, blankText);
    }


    @Test
    public void testIdCard() {
        String text = "31010519840330005X";
        String maskText = MaskUtils.maskIdCard(text);
        assertEquals(maskText, "**************005X");

        String shortText = "31010519833200056";
        String maskShortText = MaskUtils.maskIdCard(shortText);
        assertEquals(maskShortText, "**************0056");

        String longText = "3101051984303300056";
        String maskLongText = MaskUtils.maskIdCard(longText);
        assertEquals(maskLongText, "**************0056");

        String nullText = null;
        //noinspection ConstantConditions
        String maskNullText = MaskUtils.maskIdCard(nullText);
        //noinspection ConstantConditions
        assertNull(maskNullText);

        String blankText = "    ";
        String maskBlankText = MaskUtils.maskIdCard(blankText);
        assertEquals(maskBlankText, blankText);
    }

    @Test
    public void testName() {
        String text = "王大伟";
        String maskText = MaskUtils.maskName(text);
        assertEquals(maskText, "王*伟");

        String shortText = "김희";
        String maskShortText = MaskUtils.maskName(shortText);
        assertEquals(maskShortText, "*희");

        String longText = "欧阳正华";
        String maskLongText = MaskUtils.maskName(longText);
        assertEquals(maskLongText, "欧*华");

        String nullText = null;
        //noinspection ConstantConditions
        String maskNullText = MaskUtils.maskName(nullText);
        //noinspection ConstantConditions
        assertNull(maskNullText);

        String blankText = "    ";
        String maskBlankText = MaskUtils.maskName(blankText);
        assertEquals(maskBlankText, blankText);
    }


}
