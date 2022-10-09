package com.usa.misiontic.reto3.service;
import com.usa.misiontic.reto3.entities.Category;
import com.usa.misiontic.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //Me permite indicar que esta clase es un objeto  perteneciente a Spring
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    // Pedir toda la lista de product
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    // Pedir solo un producto por Id, pero puede se un Optional, porqu puede no estar en la BD
    public Optional<Category> getProduct(int id){
        return categoryRepository.getCategory(id);
    }
    // Voy a guardar un producto, pero tengo que valiar si el producto esta en la BD
    public Category save(Category p){
        // si el id que me trajo es igual a null , ya se que no esta en la bd
        if(p.getId()==null){
            return categoryRepository.save(p);
        }else{// si no esta en la base de datos
            //Averiguemos si esta el producto en la bd
            Optional<Category> e = categoryRepository.getCategory(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return categoryRepository.save(p);
            }
        }
    }
    //Actualizar la tabla pero esta vez vamos a tener en cuenta
    public Category update(Category p) {
        // Asegurar que el producto p traiga un Id
        if (p.getId() != null) { //si es distinto de nullo si puedo trabajar
            Optional<Category> q = categoryRepository.getCategory(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) { // Los campos de p que no sean nullos los actualizo
                    q.get().setName(p.getName());
                }
                categoryRepository.save(q.get());
                return q.get();
            } else {
                return p;
            }

        } else {
            return p;
        }

    }

    public boolean delete(int id){
        boolean flag=false;
        Optional<Category> p = categoryRepository.getCategory(id);
        if(p.isPresent()){
            categoryRepository.delete(p.get());
            flag =true;
        }
        return flag;
    }

}
