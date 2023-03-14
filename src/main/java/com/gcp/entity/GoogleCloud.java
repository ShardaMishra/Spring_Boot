package com.gcp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class GoogleCloud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long serviceId;

    @NotBlank(message="Service name can not be blank")
    private String serviceName;
//    @NotBlank(message="Service name can not be blank")
    private Integer serviceCost;
    @NotBlank(message="Service name can not be blank")
    private String serviceDescription;



}
