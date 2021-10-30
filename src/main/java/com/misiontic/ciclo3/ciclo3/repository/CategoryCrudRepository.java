package com.misiontic.ciclo3.ciclo3.repository;

import com.misiontic.ciclo3.ciclo3.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mariajo
 */
//Se llama la clase category y se nombre integer ya que es el tipo de dato de la llave primaria
//la papeleriacrudrepository hereda a crudrepository
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
