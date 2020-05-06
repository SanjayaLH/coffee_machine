import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class AppTest {
    @Test
    public void testAppHasAGreeting() {
        App app = new App();
        assertNotNull("app should have a greeting", app.getGreeting());
    }
}
