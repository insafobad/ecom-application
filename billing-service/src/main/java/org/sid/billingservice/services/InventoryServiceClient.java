package org.sid.billingservice.services;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryServiceClient {

    @GetMapping("/products?projection=fullProduct")
    PagedModel<Product> getAllProducts();

    @GetMapping("/products/{id}?projection=fullProduct")
    Product getProductById(@PathVariable("id") Long id);
}