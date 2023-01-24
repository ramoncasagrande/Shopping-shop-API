package com.shopping.shopapi.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.shopapi.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    public List<Shop> findAllByUserIdentifier(String userIdentifier);
    
    public List<Shop> findAllByTotalGreaterThan(Float total);

    public List<Shop> findAllByDateGreaterThanEqual(Date date);
}
