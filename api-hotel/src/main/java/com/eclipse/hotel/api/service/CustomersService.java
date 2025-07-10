package com.eclipse.hotel.api.service;

import com.eclipse.hotel.api.model.Customers;
import com.eclipse.hotel.api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customers create(Customers customer){
        return  customerRepository.save(customer);
    }

    public List<Customers> listAll(){
        return  customerRepository.findAll();

    }

    public Customers findById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    public void  deleteById(Long id){
        customerRepository.deleteById(id);

    }
     public Customers updateCustomers(Long id,Customers customers){
         Optional<Customers>customersToUpdate =customerRepository.findById(id);
         if(customersToUpdate.isPresent()){
             customersToUpdate.get().setName(customers.getName());
             customersToUpdate.get().setEmail(customers.getEmail());
             customersToUpdate.get().setPhone(customers.getPhone());

             return  customerRepository.save(customersToUpdate.get());
         }
        return null;
     }
}