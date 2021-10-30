package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Category;
import com.misiontic.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariajo
 */
@Service
public class CategoryService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private CategoryRepository categoryRepository;
    
    //va a retornar una lista
    public List<Category> getAll(){
	return categoryRepository.getAll();
    }
    
    //get para obtener una categoria especifica
    //servicio
    public Optional<Category> getCategory(int categoriaId){
	return categoryRepository.getCategory(categoriaId);
    }
    
    //guardar un registro de habitacion 
    public Category save(Category categoria){
        if(categoria.getId() == null){
            return categoryRepository.save(categoria);
        }else{
            Optional<Category> evt=categoryRepository.getCategory(categoria.getId());
            if(evt.isPresent()){
                return categoryRepository.save(categoria);
            }else{
                return categoria;
            }
        }
    }
    
    public Category update (Category category){
        if(category.getId()!=null){
            Optional<Category> c=categoryRepository.getCategory(category.getId());
            if(!c.isEmpty()){
                if(category.getName()!=null){
                    c.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    c.get().setDescription(category.getDescription());
                }
                return categoryRepository.save(c.get());
            }        
        }
        return category;
    }
    
    
    //para eliminar un registro de habitacion
    public boolean deleteCategory(int categoriaId) {
        Boolean aBoolean = getCategory(categoriaId).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
