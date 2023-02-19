package com.example.Ecommerce.Api.controller;

import com.example.Ecommerce.Api.model.Address;
import com.example.Ecommerce.Api.model.Order;
import com.example.Ecommerce.Api.model.Product;
import com.example.Ecommerce.Api.model.User;
import com.example.Ecommerce.Api.repository.AddressRepository;
import com.example.Ecommerce.Api.repository.ProductRepository;
import com.example.Ecommerce.Api.repository.UserRepository;
import com.example.Ecommerce.Api.service.Service;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/ecommerce-app")
public class OrderController {
    @Autowired
    private Service service;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    @PostMapping("/createOrder")
    public ResponseEntity addOrder(@RequestBody String orderData)
    {
        JSONObject json=new JSONObject(orderData);
        Order order=setOrder(json);
        int orderId=service.placeOrder(order);
        return new ResponseEntity<>("Order has been Placed with order id- "+orderId, HttpStatus.CREATED);
    }

    private Order setOrder(JSONObject json){
        Order order=new Order();
        order.setProductQuantity(json.getInt("productQuantity"));

        Integer userId=json.getInt("user");
        User user=userRepository.findById(userId).get();
        order.setUser(user);

        Integer productId=json.getInt("product");
        Product product=productRepository.findById(productId).get();
        order.setProduct(product);

        Integer addressId=json.getInt("address");
        Address address=addressRepository.findById(addressId).get();
        order.setAddress(address);

        return order;
    }

    @GetMapping("/getOrderById")
    public ResponseEntity<Order> getOrderById(@RequestParam int orderId){
        Order order = service.getOrderById(orderId);
        return new ResponseEntity<>(order,HttpStatus.FOUND);
    }
}
