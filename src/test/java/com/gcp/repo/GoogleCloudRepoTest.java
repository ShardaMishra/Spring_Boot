package com.gcp.repo;

import com.gcp.entity.GoogleCloud;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class GoogleCloudRepoTest {
    @Autowired
    TestEntityManager entityManager;

    @Autowired
    GoogleCloudRepo googleCloudRepo;

    private GoogleCloud googleCloud;

    @BeforeEach
    void setUp(){
        googleCloud=GoogleCloud.builder()
                .serviceName("DELL")
                .serviceCost(500)
                .serviceDescription("Hello")
                .build();
        entityManager.persist(googleCloud);
    }

    @Test
    public void findByServiceId(){
        GoogleCloud googleCloud1=googleCloudRepo.findById(1L).get();
        assertEquals(1,googleCloud1.getServiceId());
    }
    @Test
    public void findByServiceName(){
        GoogleCloud googleCloud1=googleCloudRepo.findByServiceName("DELL");
        assertEquals("DELL",googleCloud1.getServiceName());
    }

    @Test
    public void findByServiceCost(){
        GoogleCloud googleCloud1=googleCloudRepo.findByServiceCost(500);
        assertEquals(500,googleCloud1.getServiceCost());
    }

    @Test
    public void findByServiceDescription(){
        GoogleCloud googleCloud1=googleCloudRepo.findByServiceDescription("Hello");
        assertEquals("Hello",googleCloud1.getServiceDescription());
    }

    @Test
    void update(){
        GoogleCloud googleCloud1=googleCloudRepo.findById(1L).get();
        googleCloud1.setServiceName("Lenovo");
        entityManager.persist(googleCloud1);
        assertEquals("Lenovo",googleCloud1.getServiceName());
    }
//    @Test
//    void update1(){
//        GoogleCloud googleCloud1=googleCloudRepo.findById(1L).get();
//        googleCloud1.setServiceCost();
//
//    }


}
