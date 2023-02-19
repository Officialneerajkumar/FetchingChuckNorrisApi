package com.example.Ecommerce.Api.repository;

import com.example.Ecommerce.Api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderReposirtory extends JpaRepository<Order,Integer> {

}
