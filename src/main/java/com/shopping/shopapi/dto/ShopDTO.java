package com.shopping.shopapi.dto;

import java.sql.Date;
import java.util.List;

import com.shopping.shopapi.model.Shop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShopDTO {

    @NotBlank
    private String userIdentifier;
    @NotNull
    private float total;
    @NotNull
    private Date date;
    @NotNull
    private List<ItemDTO> items;
    
    public ShopDTO() {
    }

    public ShopDTO(@NotBlank String userIdentifier, @NotNull float total, @NotNull Date date,
            @NotNull List<ItemDTO> items) {
        this.userIdentifier = userIdentifier;
        this.total = total;
        this.date = date;
        this.items = items;
    }

    public String getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(String userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    public static ShopDTO convert(Shop shop){
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setUserIdentifier(shop.getUserIdentifier());
        shopDTO.setTotal(shop.getTotal());
        return shopDTO;
    }
}
