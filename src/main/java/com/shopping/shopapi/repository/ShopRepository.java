package com.shopping.shopapi.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.shopapi.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    public List<Shop> findAllByUserIdentifier(String userIdentifier);
    
    public List<Shop> findAllByTotalGreaterThan(Float total);

    //public List<Shop> findAllByDateGreaterThanEquals(Date date);
}
