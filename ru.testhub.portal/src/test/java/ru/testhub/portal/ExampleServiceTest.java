package ru.testhub.portal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ExampleService.class)
@WebAppConfiguration
public class ExampleServiceTest
{
    private MockMvc mockMvc;

    @BeforeEach
    void beforeEach(WebApplicationContext context)
    {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void q()
    {

    }

    @Test
    public void helloTest() throws Exception
    {
        this.mockMvc.perform(get("/hello"))
                .andExpect(status().isOk());
    }
}
