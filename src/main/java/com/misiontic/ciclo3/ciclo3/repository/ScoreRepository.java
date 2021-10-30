package com.misiontic.ciclo3.ciclo3.repository;

import com.misiontic.ciclo3.ciclo3.model.Score;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Laurita
 */
public class ScoreRepository {
    
    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private ScoreCrudRepository scoreCrudRepository;
    
    // Consulta los elementos de la base y los entrega en una lista
    public List<Score> getAll(){
	return (List<Score>) scoreCrudRepository.findAll();
    }
    
    //Si el dato esta se entrega y si no existe el dato pues nada
    // y entonces con ese Optional se evitan problemas con los null
    public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }
    
    //Para guardar
    public Score save (Score c) {
         return scoreCrudRepository.save(c);
    }
    
    //Para eliminar
    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }
    
}
