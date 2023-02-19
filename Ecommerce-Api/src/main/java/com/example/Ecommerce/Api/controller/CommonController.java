package com.example.Ecommerce.Api.controller;

import com.example.Ecommerce.Api.model.Address;
import com.example.Ecommerce.Api.model.Order;
import com.example.Ecommerce.Api.model.Product;
import com.example.Ecommerce.Api.model.User;
import com.example.Ecommerce.Api.repository.AddressRepository;
import com.example.Ecommerce.Api.repository.OrderReposirtory;
import com.example.Ecommerce.Api.repository.ProductRepository;
import com.example.Ecommerce.Api.repository.UserRepository;
import com.example.Ecommerce.Api.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Steps:
//        1. Create users
//        2. Create products
//        3. Create Address
//        4. Place an order (Create Order) using userId, productId, addressId
//
//        5. Get order by order id
//        6. Get user by userid
//        7. Get all products
//        - Get products based on category (query params)
//        8. delete products based on product id.


@RestController
@RequestMapping("api/v1/ecommerce-app")
public class CommonController {

    @Autowired
    private Service service;
    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody User user){
        service.createUser(user);
        return new ResponseEntity<>("User created",HttpStatus.CREATED);
    }

    @PostMapping("/create-product")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        service.createProduct(product);
        return new ResponseEntity<>("Product created",HttpStatus.CREATED);
    }

    @PostMapping("/create-address")
    public ResponseEntity<String> createAddress(@RequestBody Address address){
        service.createAddress(address);
        return new ResponseEntity<>("Address created",HttpStatus.CREATED);
    }



}
