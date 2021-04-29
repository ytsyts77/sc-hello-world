package settings.setup;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;
import settings.config.TestProfile;

@ActiveProfiles(TestProfile.DEFAULT)
@ExtendWith(MockitoExtension.class)
public class MockTest {
}
