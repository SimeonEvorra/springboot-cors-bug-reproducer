package cors.corsissue;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class CorsTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void testControllerSuccessCors() throws Exception {
        this.mvc.perform(get("/testcors").header("Access-Control-Request-Method", "GET").header("Origin",
                "https://test.mysite.com")).andExpect(status().isOk());
    }

    @Test
    void testControllerForbiddenCors() throws Exception {
        this.mvc.perform(get("/testcors").header("Access-Control-Request-Method", "GET").header("Origin",
                "https://wrongsite.com")).andExpect(status().isForbidden());
    }

    @Test
    void testRepositorySuccessCors() throws Exception {
        this.mvc.perform(get("/features").header("Access-Control-Request-Method", "GET").header("Origin",
                "https://test.mysite.com")).andExpect(status().isOk());
    }

    // This test pass with version <= 2.5.4 and fails with version >= 2.5.5
    @Test
    void testRepositoryForbiddenCors() throws Exception {
        this.mvc.perform(get("/features").header("Access-Control-Request-Method", "GET").header("Origin",
                "https://wrongsite.com")).andExpect(status().isForbidden());
    }

}
