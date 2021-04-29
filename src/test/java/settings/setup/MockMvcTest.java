package settings.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.samsungcard.helloworld.HelloWorldApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import settings.config.TestProfile;

import java.io.IOException;
import java.io.InputStream;

@ContextConfiguration(classes = HelloWorldApplication.class)
@ActiveProfiles(TestProfile.DEFAULT)
public class MockMvcTest {
    @Autowired
    protected ResourceLoader resourceLoader;

    protected MockMvc mockMvc;
    protected ObjectMapper objectMapper = buildObjectMapper();

    protected <T> T readValue(final String path, Class<T> clazz) throws IOException {
        final InputStream json = resourceLoader.getResource(path).getInputStream();
        return objectMapper.readValue(json, clazz);
    }

    private ObjectMapper buildObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}
