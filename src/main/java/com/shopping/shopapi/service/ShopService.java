package com.shopping.shopapi.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.shopapi.dto.ShopDTO;
import com.shopping.shopapi.model.Shop;
import com.shopping.shopapi.repository.ShopRepository;

@Service
public class ShopService {

    @Autowired
    public ShopRepository shopRepository;

    public List<ShopDTO> getAll() {
        List<Shop> shops = shopRepository.findAll();
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByUser(String userIdentifier) {
        List<Shop> shops = shopRepository.findAllByUserIdentifier(userIdentifier);
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ShopDTO> getByDate(ShopDTO shopDTO) {
        List<Shop> shops = shopRepository.findAllByDateGreaterThanEquals(shopDTO.getDate());
        return shops
                .stream()
                .map(ShopDTO::convert)
                .collect(Collectors.toList());
    }

    public ShopDTO findById(Long productId){
        Optional<Shop> shop = shopRepository.findById(productId);
        if (shop.isPresent()){
            return ShopDTO.convert(shop.get());
        }
        return null;
    }

    public ShopDTO save(ShopDTO shopDTO){
        shopDTO.setTotal(shopDTO.getItems()
                .stream()
                .map(x -> x.getPrice())
                .reduce((float) 0, Float::sum));
        
                Shop shop = Shop.cconvert(shopDTO);
                shop.setDate(new Date());

                shop = shopRepository.save(shop);
                return ShopDTO.convert(shop);
    }
}
