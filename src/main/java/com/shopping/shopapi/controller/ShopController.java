package com.shopping.shopapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shopapi.dto.ShopDTO;
import com.shopping.shopapi.service.ShopService;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping("/shopping")
    public List<ShopDTO> listaCompras(){
        List<ShopDTO> produtos = shopService.getAll();
        return produtos;
    }
    
}
