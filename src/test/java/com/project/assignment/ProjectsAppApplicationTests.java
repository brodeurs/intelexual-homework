package com.project.assignment;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectsAppApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    void contextLoads() {
    }

    @Test
    public void shouldReturnDefaultMessage() throws Exception {

        Assert.isTrue(mockMvc != null, "mockMvc is null");

        mockMvc.perform(MockMvcRequestBuilders
                .get("/projects")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(containsString("[]")))
                .andDo(print());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.projects").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty())
                ;

    }

//    @Test
//    public void testAddEmployeeSuccess() throws URISyntaxException
//    {
//        final String baseUrl = "http://localhost:"+ serverPort +"/projects/";
//        URI uri = new URI(baseUrl);
//
//        Project project = new Project("test project", new Date(Calendar.getInstance().getTimeInMillis()));
//
//        HttpHeaders headers = new HttpHeaders();
////        headers.set("X-COM-PERSIST", "true");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<Project> request = new HttpEntity<>(project, headers);
//
//        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
//
//        //Verify request succeed
//        Assert.isTrue(201 == result.getStatusCodeValue(), "Status code not 201");
//    }
}
