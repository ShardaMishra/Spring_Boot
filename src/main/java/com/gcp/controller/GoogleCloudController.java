package com.gcp.controller;

import com.gcp.entity.Employee;
import com.gcp.entity.GoogleCloud;
import com.gcp.service.GoogleCloudService;
import com.gcp.service.GoogleCloudServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.ServiceNotFoundException;
import javax.validation.Valid;

@RestController
public class GoogleCloudController {

    @Autowired
    GoogleCloudService googleCloudService;

    @Valid

    @PostMapping("/save")
    public GoogleCloud save(@RequestBody GoogleCloud googleCloud){
        return  googleCloudService.addData(googleCloud);
    }
    @GetMapping("/find/{id}")
    private GoogleCloud find(@PathVariable long id) throws ServiceNotFoundException {
        return googleCloudService.find(id);
    }

    @PutMapping("/update-data/{id}")
    private GoogleCloud updateData(@PathVariable Long id,@RequestBody GoogleCloud googleCloud){
        return googleCloudService.updateData(id,googleCloud);
    }
//
//    @PostMapping("/save-oneToOne")
//    private Employee addData_oneTOne(@RequestBody Employee employee){
//        return googleCloudService.addData_oneToOne(employee);
//    }
//
//    @GetMapping("/find-oneToOne/{id}")
//        private Employee find_oneToOne(@PathVariable Long id) throws ServiceNotFoundException {
//        return googleCloudService.find_oneToOne(id);
 //   }

//    @PutMapping("/update-data-oneToOne/{id}")
//    private Employee updateData_oneToOne(@PathVariable Long id,@RequestBody Employee employee) throws ServiceNotFoundException{
//        return  googleCloudService.updateData_oneToOne(id,employee);
//    }


    @PostMapping("/save-employee")
    private Employee addData_manyToMany(@RequestBody Employee employee){
        return googleCloudService.saveEmployee(employee);
    }

//    @GetMapping("/find-manyToOne/{id}")
//    private Employee find_manyToOne(@PathVariable Long id) throws ServiceNotFoundException {
//        return googleCloudService.find_manyToOne(id);
 //   }

    @PutMapping("/update/{empId}/{serviceId}")
    private Employee updateData_manyToOne(@PathVariable Long empId, @PathVariable Long serviceId) throws ServiceNotFoundException{
        return  googleCloudService.update(empId,serviceId);
    }

    @GetMapping("/findByServiceName/{findByServiceName}")
    public GoogleCloud findByServiceName(@PathVariable String serviceName){
        return googleCloudService.findService(googleCloudService);

    }
   @GetMapping("/findByServiceId/{findByServiceId}")
    public GoogleCloud findByServiceId(@PathVariable Long serviceId){
        return googleCloudService.findByService(googleCloudService);
   }

   @GetMapping("/findByServiceCost/{findByServiceCost}")
    public GoogleCloud findByServiceCost(@PathVariable int serviceCost){
        return googleCloudService.findByService(googleCloudService);
   }

   @GetMapping("/findByServiceDescription/{findByServiceDescription}")
    public GoogleCloud findByServiceDescription(@PathVariable String serviceDescription){
        return  googleCloudService.findByService(googleCloudService);
   }

}

