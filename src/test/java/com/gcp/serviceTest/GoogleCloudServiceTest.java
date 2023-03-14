package com.gcp.serviceTest;

import com.gcp.entity.GoogleCloud;
import com.gcp.repo.GoogleCloudRepo;
import com.gcp.service.GoogleCloudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GoogleCloudServiceTest {
    @Autowired
    GoogleCloudService googleCloudService;

    @MockBean
    GoogleCloudRepo googleCloudRepo;

    @BeforeEach
    void setUp() {
        GoogleCloud googleCloud = GoogleCloud.builder()
                .serviceId(1)
                .serviceName("TCS")
                .serviceCost(5666)
                .serviceDescription("hiiiiiiiii")
                .build();

        Mockito.when(googleCloudRepo.findByServiceName("TCS"))
                .thenReturn(googleCloud);
        Mockito.when(googleCloudRepo.findByServiceId("1"))
                .thenReturn(googleCloud);
        Mockito.when(googleCloudRepo.findByServiceCost(5666))
                .thenReturn(googleCloud);
        Mockito.when(googleCloudRepo.findByServiceDescription("hiiiiiiiii"))
                .thenReturn(googleCloud);
    }

    @Test
    void validByServiceName(){
        GoogleCloud googleCloud=googleCloudService.findByServiceName("TCS");
        assertEquals("TCS",googleCloud.getServiceName());
    }

    @Test
    void validByServiceId(){
        GoogleCloud googleCloud=googleCloudService.findByServiceId("1");
        assertEquals(1,googleCloud.getServiceId());
    }
    @Test
    void validByServiceCost(){
        GoogleCloud googleCloud=googleCloudService.findByServiceCost(5666);
        assertEquals(5666,googleCloud.getServiceCost());
    }

    @Test
    void validByServiceDescription(){
        GoogleCloud googleCloud=googleCloudService.findByServiceDescription("hiiiiiiiii");
        assertEquals("hiiiiiiiii",googleCloud.getServiceDescription());
    }

    }
