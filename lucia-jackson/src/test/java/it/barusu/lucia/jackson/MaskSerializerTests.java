package it.barusu.lucia.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class MaskSerializerTests {

    @Test
    public void testMask() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        MaskBean bean = new MaskBean();
        bean.setId("123");
        bean.setName("John");
        bean.setEmail("ab");

        log.info("bean: {}", objectMapper.writeValueAsString(bean));
    }

    @Getter
    @Setter
    public static class MaskBean {
        private String id;

        @JsonSerialize(using = MaskSerializer.class)
        @Mask
        private String name;
        @JsonSerialize(using = MaskSerializer.class)
        @Mask
        private String email;
    }
}
