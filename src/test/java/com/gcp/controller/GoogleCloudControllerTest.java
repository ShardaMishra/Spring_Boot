package com.gcp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcp.entity.GoogleCloud;
import com.gcp.service.GoogleCloudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@WebMvcTest(GoogleCloudController.class)
public class GoogleCloudControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GoogleCloudService googleCloudService;
    public GoogleCloud googleCloud;
    @BeforeEach
    void setUp(){
        googleCloud=GoogleCloud.builder()
                .serviceDescription("Hii")
                .serviceCost(54)
                .serviceName("Samsung")
                .serviceId(1L)
                .build();
    }
    @Test
    void save() throws Exception {
        GoogleCloud googleCloud1=GoogleCloud.builder()
                .serviceName("Samsung")
                .serviceCost(54)
                .serviceDescription("Hii")
                .build();

        Mockito.when(googleCloudService.addData(googleCloud1)).thenReturn(googleCloud);
        mockMvc.perform(MockMvcRequestBuilders.post("/save").contentType(MediaType.APPLICATION_JSON)
                .content("{\n"+
                        "\"serviceName\": \"test\",\n"+
                "\"serviceCost\": 100,\n"+
                "\"serviceDescription\":\"test\"\n"+
       "}")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void find() throws Exception {

        Mockito.when(googleCloudService.find(1L)).thenReturn(googleCloud);
        mockMvc.perform(MockMvcRequestBuilders.get("/find/1").contentType(MediaType.APPLICATION_JSON)
               ).andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    void update() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/update-data/1 ").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(googleCloud))).andExpect(MockMvcResultMatchers.status().isOk());

    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

