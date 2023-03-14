package com.gcp.repo;

import com.gcp.entity.GoogleCloud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface GoogleCloudRepo extends JpaRepository<GoogleCloud, Long> {

@Query("select r from GoogleCloud r where r.serviceName=?1")

    public GoogleCloud findByServiceName(String serviceName);

    GoogleCloud findByServiceId(String serviceId);

    GoogleCloud findByServiceCost(int seviceCost);

    GoogleCloud findByServiceDescription(String serviceDescription);

    @Modifying
    @Query(value = "update  GoogleCloud r SET r.serviceName=?DELL where r.serviceId=?1" ,
    nativeQuery = true)
    public GoogleCloud updateServiceName(Long id,String serviceName);


}
