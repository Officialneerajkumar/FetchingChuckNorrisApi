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
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserById(@RequestParam int userId){
        User user = service.getUserById(userId);
        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }

    @GetMapping("/getProduct")
    public ResponseEntity<List<Product>> getProduct(@Nullable @RequestParam String category){
        List<Product> products = service.getProduct(category);
        return new ResponseEntity<>(products,HttpStatus.FOUND);
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<String> deleteProductById(@RequestParam int productId){
        service.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted ",HttpStatus.OK);
    }


}
