package com.gcp.service;

import com.gcp.entity.Employee;
import com.gcp.entity.GoogleCloud;
import com.gcp.repo.EmployeeRepo;
import com.gcp.repo.GoogleCloudRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.management.ServiceNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GoogleCloudServiceImplementation implements GoogleCloudService {

    @Autowired
    GoogleCloudRepo googleCloudRepo;
    @Autowired
    EmployeeRepo employeeRepo;

    public GoogleCloud addData(GoogleCloud googleCloud) {
        return googleCloudRepo.save(googleCloud);
    }


    @Override
    public GoogleCloud find(long id) throws ServiceNotFoundException {
        Optional<GoogleCloud> googleCloud = googleCloudRepo.findById(id);
        if (Objects.isNull(googleCloud)) {
            throw new ServiceNotFoundException("Not found");

        }
        return googleCloud.get();
    }

    @Override
    public GoogleCloud updateData(Long id, GoogleCloud googleCloud) {
        GoogleCloud googleCloudDatabase = googleCloudRepo.findById(id).get();
        System.out.println(googleCloud.getServiceCost());
        if (Objects.nonNull((googleCloud.getServiceName()))) {
            googleCloudDatabase.setServiceName((googleCloud.getServiceName()));

        }
        if (Objects.nonNull((googleCloud.getServiceCost()))) {
            googleCloudDatabase.setServiceCost((googleCloud.getServiceCost()));

        }
        if (Objects.nonNull((googleCloud.getServiceDescription()))) {
            googleCloudDatabase.setServiceDescription((googleCloud.getServiceDescription()));

        }
        return googleCloudRepo.save(googleCloud);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return null;
    }

    @Override
    public Employee update(Long empId, Long serviceId) {
        return null;
    }

    @Override
    public GoogleCloud findByServiceName(String serviceName) {
        return null;
    }

    @Override
    public GoogleCloud findByServiceId(String serviceId) {
        return null;
    }

    @Override
    public GoogleCloud findByServiceCost(int seviceCost) {
        return null;
    }

    @Override
    public GoogleCloud findByServiceDescription(String serviceDescription) {
        return null;
    }

    @Override
    public GoogleCloud findService(GoogleCloudService googleCloudService) {
        return null;
    }

    @Override
    public GoogleCloud findByService(GoogleCloudService googleCloudService) {
        return null;
    }
}



//
//   public Employee addData_oneToOne(Employee employee){
//     return employeeRepo.save(employee);
//   }


//    @Override
//    public Employee find_oneToOne(Long id)  throws ServiceNotFoundException{
//       Optional<Employee> employee=employeeRepo.findById(id);
//       if(Objects.isNull(employee)){
//           throw  new ServiceNotFoundException("Not found");
//       }
//       return  employee.get();
//   }


//    @Override

//   public Employee updateData_oneToOne(Long id, Employee employee) throws ServiceNotFoundException {
//
//     Employee empDatabase=employeeRepo.findById(id).get();
//       if(Objects.isNull(empDatabase)){
//           throw new ServiceNotFoundException("Not found");
//       }
//       if(Objects.nonNull(employee.getEmpName())){
//           empDatabase.setEmpName(employee.getEmpName());
//       }
//        if(!(Objects.nonNull(employee.getGoogleCloud()))){
//            empDatabase.setEmpName(employee.getEmpName());
//        }
//       GoogleCloud googleCloud=employee.getGoogleCloud();
//       GoogleCloud googleCloudDatabase=googleCloudRepo.findById(id).get();
//
//       if(Objects.nonNull(googleCloud.getServiceName())){
//           googleCloudDatabase.setServiceName((googleCloud.getServiceName()));
//       }
//       if(Objects.nonNull((googleCloud.getServiceCost()))){
//           googleCloudDatabase.setServiceCost((googleCloud.getServiceCost()));
//       }
//       if (Objects.nonNull((googleCloud.getServiceDescription()))){
//           googleCloudDatabase.setServiceDescription((googleCloud.getServiceDescription()));
//       }
//       empDatabase.setGoogleCloud(googleCloudDatabase);
//       return employeeRepo.save(empDatabase);
//
//   }


//   public Employee saveEmployee(Employee employee){
//      return employeeRepo.save(employee);
//   }
//
//    public Employee update(Long empId,Long serviceId){
//        List<GoogleCloud> googleCloudList=null;
//        GoogleCloud googleCloud = googleCloudRepo.findById(serviceId).get();
//        Employee employee= employeeRepo.findById(empId).get();
//        googleCloudList= employee.getGoogleCloud();
//       googleCloudList.add(googleCloud);
//        employee.setGoogleCloud(googleCloudList);
//        return employeeRepo.save(employee);
//    }

//    @Override
//    public GoogleCloud findService(GoogleCloudService googleCloudService) {
//        return null;
//    }

//   public  Employee find_manyToOne(Long id) throws  ServiceNotFoundException{
//
//       Optional<Employee> employee=employeeRepo.findById(id);
//       if(Objects.isNull(employee)){
//           throw  new ServiceNotFoundException("Not found");
//       }
//       return  employee.get();
//   }


//   public  Employee updateData_manyToOne(Long id, Employee employee) throws ServiceNotFoundException{
//
//       Employee empDatabase=employeeRepo.findById(id).get();
//       if(Objects.isNull(empDatabase)){
//           throw new ServiceNotFoundException("Not found");
//       }
//       if(Objects.nonNull(employee.getEmpName())){
//           empDatabase.setEmpName(employee.getEmpName());
//       }
//       if(!(Objects.nonNull(employee.getGoogleCloud()))){
//           empDatabase.setEmpName(employee.getEmpName());
//       }
//       GoogleCloud googleCloud=employee.getGoogleCloud();
//       GoogleCloud googleCloudDatabase=googleCloudRepo.findById(id).get();
//
//       if(Objects.nonNull(googleCloud.getServiceName())){
//           googleCloudDatabase.setServiceName((googleCloud.getServiceName()));
//       }
//       if(Objects.nonNull((googleCloud.getServiceCost()))){
//           googleCloudDatabase.setServiceCost((googleCloud.getServiceCost()));
//       }
//       if (Objects.nonNull((googleCloud.getServiceDescription()))){
//           googleCloudDatabase.setServiceDescription((googleCloud.getServiceDescription()));
//       }
//       empDatabase.setGoogleCloud(googleCloudDatabase);
//       return employeeRepo.save(empDatabase);
//   }
//
//    @Override
//    public GoogleCloud findByServiceName(String serviceName){
//       return googleCloudRepo.findByServiceName(serviceName);
//
//    }
//
//    @Override
//    public GoogleCloud findByService(GoogleCloudService googleCloudService) {
//        return null;
//    }
//
//    @Override
//    public GoogleCloud findByServiceId(long l) {
//        return null;
//    }
//
//    @Override
//    public GoogleCloud findByServiceId(String serviceId){
//       return googleCloudRepo.findByServiceId(serviceId);
//    }
//
//    @Override
//    public GoogleCloud findByServiceCost(int seviceCost){
//       return googleCloudRepo.findByServiceCost(seviceCost);
//    }
//
//    @Override
//    public GoogleCloud findByServiceDescription(String serviceDescription){
//       return googleCloudRepo.findByServiceDescription(serviceDescription);
//    }
//
//
//
//
//
//}

