package com.example.demo.service;

import com.example.demo.model.Purchase;
import com.example.demo.repository.PurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    // LIstar todos las compras
    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }

    // Crear una compra
    public Purchase createPurchase(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }

    // Obtener una compra por id
    public Optional<Purchase> getPurchaseById(String id) {
        return purchaseRepository.findById(id);
    }

    // Eliminar una compra
    public void deletePurchase(String id) {
        purchaseRepository.deleteById(id);
    }

    // Actualizar una compra
    public Purchase updatePurchase(String id, Purchase purchase) {
        Purchase purchaseToUpdate = purchaseRepository.findById(id).get();
        purchaseToUpdate.setTotal(purchase.getTotal());
        purchaseToUpdate.setEvent(purchase.getEvent());
        purchaseToUpdate.setQuantity(purchase.getQuantity());
        purchaseToUpdate.setPaymentGateway(purchase.getPaymentGateway());
        purchaseToUpdate.setClientName(purchase.getClientName());
        purchaseToUpdate.setClientEmail(purchase.getClientEmail());
        purchaseToUpdate.setClientSmartphone(purchase.getClientSmartphone());
        return purchaseRepository.save(purchaseToUpdate);
    }
}