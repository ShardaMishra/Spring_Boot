package com.gcp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long empId;
    private String empName;

//    @OneToOne
//    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
//    private GoogleCloud googleCloud;

    @ManyToMany//(cascade = CascadeType.ALL,optional = true)
    @JoinTable(name="Emp_SR", joinColumns = @JoinColumn(name="empId"),
    inverseJoinColumns = @JoinColumn(name="serviceId"))
    private List<GoogleCloud> googleCloud;
}
