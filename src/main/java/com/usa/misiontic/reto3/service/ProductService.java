package com.usa.misiontic.reto3.service;

import com.usa.misiontic.reto3.entities.Product;
import com.usa.misiontic.reto3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service  //Me permite indicar que esta clase es un objeto  perteneciente a Spring
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    // Pedir toda la lista de productos
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    // Pedir solo un producto por Id, pero puede se un Optional, porqu puede no estar en la BD
    public Optional<Product> getProduct(int id){
        return productRepository.getProduct(id);
    }
    // Voy a guardar un producto, pero tengo que valiar si el producto esta en la BD
    public Product save(Product p){
        // si el id que me trajo es igual a null , ya se que no esta en la bd
        if(p.getId()==null){
            return productRepository.save(p);
        }else{// si no esta en la base de datos
            //Averiguemos si esta el producto en la bd
            Optional<Product> e = productRepository.getProduct(p.getId());
            if(e.isPresent()){
                return p;
            }else{
                return productRepository.save(p);
            }
        }
    }
    //Actualizar la tabla pero esta vez vamos a tener en cuenta
    public Product update(Product p) {
        // Asegurar que el producto p traiga un Id
        if (p.getId() != null) { //si es distinto de nullo si puedo trabajar
            Optional<Product> q = productRepository.getProduct(p.getId());
            if (q.isPresent()) {
                if (p.getName() != null) { // Los campos de p que no sean nullos los actualizo
                    q.get().setName(p.getName());
                }
                if (p.getYear() != null) {
                    q.get().setYear(p.getYear());
                }
                if (p.getCategory() != null) {
                    q.get().setCategory(p.getCategory());
                }
                productRepository.save(q.get());
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
        Optional<Product> p = productRepository.getProduct(id);
        if(p.isPresent()){
            productRepository.delete(p.get());
            flag =true;
        }
        return flag;
    }

}
