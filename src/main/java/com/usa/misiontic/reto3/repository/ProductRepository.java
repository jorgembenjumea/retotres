package com.usa.misiontic.reto3.repository;

import com.usa.misiontic.reto3.entities.Product;
import com.usa.misiontic.reto3.repository.crudRepository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

// El Repository hace uso del CrudRepository para gestionar toda la informacion de las operaciones
// basicas, tipicas y comunes  de la base de datos
@Repository // le decimos a Spring que esta clase no es un objeto es un Repositorio
public class ProductRepository {
    //Cuando le diga que leea informacion haga algo

    @Autowired // Permitirle a SPring que me gestione las instancias, que me inicializa el framework

    /*     Tipo de Variable        Nombre de la Variable*/
    private ProductCrudRepository productCrudRepository;

    // Vamos a decirle al product repositori que nos escriba la lista de todos los productos
    public List<Product> getAll(){
        return (List<Product>) productCrudRepository.findAll();
    }

    // Obtener un elemento po r Id
    public Optional<Product> getProduct(int id){
        return productCrudRepository.findById(id);
    }

    // Guardar algun producto
    public Product save(Product p){
        return productCrudRepository.save(p);
    }
    public void delete(Product p){
        productCrudRepository.delete(p);
    }

}
