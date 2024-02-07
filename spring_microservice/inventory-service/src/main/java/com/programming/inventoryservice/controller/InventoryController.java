package com.programming.inventoryservice.controller;

import com.programming.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private  final InventoryService inventoryService;
    @GetMapping("/{skuCoke}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("skuCode") String skuCode){
        return inventoryService.isInStack(skuCode);

    }
}

