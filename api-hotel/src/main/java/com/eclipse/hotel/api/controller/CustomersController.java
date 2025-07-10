package com.eclipse.hotel.api.controller;

import com.eclipse.hotel.api.model.Customers;
import com.eclipse.hotel.api.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")

public class CustomersController {

    @Autowired
    private CustomersService customersService;
    @PostMapping("cadastroCliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Customers cadastraCliente(@RequestBody Customers customers){
        return customersService.create(customers);
    }

    @GetMapping("/listcustomers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customers> listaCustomers(){
        return customersService.listAll();
    }

    @GetMapping("/findbyid/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customers findbyid(@PathVariable(value = "id") Long id){
        return customersService.findById(id);
    }

    @DeleteMapping("deletebyid/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deletebyid(@PathVariable(value="id")Long id){
        customersService.deleteById(id);


    }
    @PutMapping("/updatecustomer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Customers updateCustomers(@RequestBody Customers customers,@PathVariable(value = "id") Long id){
        return customersService.updateCustomers(id,customers);

    }

}
