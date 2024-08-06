package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Purchase;
import com.example.demo.service.PurchaseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Purchase getPurchaseById(@PathVariable String id) {
        return purchaseService.getPurchaseById(id).get();
    }

    @PostMapping
    public Purchase createPurchase(@RequestBody Purchase purchase) {
        return purchaseService.createPurchase(purchase);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable String id) {
        purchaseService.deletePurchase(id);
    }

    @PutMapping("/{id}")
    public Purchase updatePurchase(@PathVariable String id, @RequestBody Purchase purchase) {
        return purchaseService.updatePurchase(id, purchase);
    }
}
