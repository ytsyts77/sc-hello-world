package settings.setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsungcard.helloworld.HelloWorldApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import settings.config.TestProfile;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest(classes = HelloWorldApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles(TestProfile.DEFAULT)
@Transactional
public class IntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected ResourceLoader resourceLoader;

    protected final String identifier = "{class-name}/{method-name}";

    protected <T> T readValue(final String path, Class<T> clazz) throws IOException {
        final InputStream json = resourceLoader.getResource(path).getInputStream();
        return objectMapper.readValue(json, clazz);
    }
}
