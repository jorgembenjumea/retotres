package com.usa.misiontic.reto3.repository.crudRepository;

import com.usa.misiontic.reto3.entities.Category;
import org.springframework.data.repository.CrudRepository;
// que es CrudRepository: Es aquel componente o una interfas que vamos atulizar para que
// SpringBoot pueda entederse con la base de datos, al entederse con la base de datos quien
// va a utilizar ese objeto ? "EL REPOSITORY"
// El Repository hace uso del CrudRepository para gestionar toda la informacion de las operaciones
// basicas, tipicas y comunes  de la base de datos

// Un crud repositori es un componente de Spring que se encarga de gestionar
//la creacion lectura, y borrado en la base de datos
//                                              CrudRepository<Clase , tipo de dato Clave Primaria>
public interface CategoryCrudRepository extends CrudRepository<Category,Integer> {
}
