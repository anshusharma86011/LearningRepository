package com.springboottest.agency.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboottest.agency.Dto.SaleRequest;
import com.springboottest.agency.Service.InventoryService;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/sale/{id}")
   public String sale(@PathVariable Long id, 
                      @RequestBody SaleRequest saleRequest ) {

            inventoryService.saleProduct(id, saleRequest.getQuantity(), saleRequest.getProductPrice());
            return "✅Sale recorded successfully!";
   
        }

}
