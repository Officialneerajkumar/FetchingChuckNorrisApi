package com.example.Ecommerce.Api.service;

import com.example.Ecommerce.Api.model.Address;
import com.example.Ecommerce.Api.model.Order;
import com.example.Ecommerce.Api.model.Product;
import com.example.Ecommerce.Api.model.User;
import com.example.Ecommerce.Api.repository.AddressRepository;
import com.example.Ecommerce.Api.repository.OrderReposirtory;
import com.example.Ecommerce.Api.repository.ProductRepository;
import com.example.Ecommerce.Api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private OrderReposirtory orderReposirtory;

    public void createUser(User user){
        userRepository.save(user);
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void createAddress(Address address){
        addressRepository.save(address);
    }

    public int placeOrder(Order order){
        orderReposirtory.save(order);
        return order.getOrderId();
    }
}
