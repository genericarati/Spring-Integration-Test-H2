import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes= hello.Application.class)
public class HelloControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    hello.GetData getData;

    @Test
    public void shouldReturnRecord() throws Exception {
        when(getData.getTableContent()).thenReturn("Data from Test");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andReturn();

        verify(getData).createStoredProc();

    }

}