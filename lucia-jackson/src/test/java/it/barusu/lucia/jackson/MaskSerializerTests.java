package it.barusu.lucia.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

@Slf4j
public class MaskSerializerTests {

    @Test
    public void testMask() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MaskBean bean = new MaskBean();
        bean.setId("123");
        bean.setName("John");
        bean.setEmail("norxiva@qq.com");
        bean.setBankCard("62282039000102293");
        bean.setIdCard("310105198403300054");
        bean.setMobile("13501608883");
        bean.setTelephone("62512362");

        String json = objectMapper.writeValueAsString(bean);

        assertTrue(json.contains("J*n"));
        assertTrue(json.contains("n***@qq.com"));
        assertTrue(json.contains("135****8883"));
    }

    @Getter
    @Setter
    public static class MaskBean {
        private String id;

        @Mask(value = MaskType.NAME)
        private String name;

        @Mask(value = MaskType.EMAIL)
        private String email;

        @Mask(value = MaskType.MOBILE)
        private String mobile;

        @Mask(value = MaskType.TELEPHONE)
        private String telephone;

        @Mask(value = MaskType.ID_CARD)
        private String idCard;

        @Mask(value = MaskType.BANK_CARD)
        private String bankCard;
    }
}
