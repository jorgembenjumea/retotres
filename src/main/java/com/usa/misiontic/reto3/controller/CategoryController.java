package com.usa.misiontic.reto3.controller;

import com.usa.misiontic.reto3.entities.Category;
import com.usa.misiontic.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }
    @PostMapping("/save")
    public Category save(@RequestBody Category p) {
        return categoryService.save(p);
    } //@RequestBody viene en el cuerpo de la peticion

}
