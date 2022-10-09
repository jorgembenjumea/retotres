package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Product;
import com.usa.misiontic.reto3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product p) {
        return productService.save(p);
    } //@RequestBody viene en el cuerpo de la peticion

}
