package com.usa.misiontic.reto3.repository.crudRepository;

import com.usa.misiontic.reto3.entities.Product;
import org.springframework.data.repository.CrudRepository;

// La interfas heredara de una interfas de SpringBoot, CrudRepository se utiliza para comunicarse con
//la base de datos
public interface ProductCrudRepository extends CrudRepository<Product,Integer> {
}
