package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Score;
import com.misiontic.ciclo3.ciclo3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mariajo
 */
public class ScoreService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private ScoreRepository scoreRepository;
    
    //va a retornar una lista
    public List<Score> getAll(){
	return scoreRepository.getAll();
    }
    
    //get para obtener una categoria especifica
    //servicio
    public Optional<Score> getScore(int id){
	return scoreRepository.getScore(id);
    }
    
    //guardar un registro de habitacion 
    public Score save(Score c){
        if(c.getIdScore()== null){
            return scoreRepository.save(c);
        }else{
            Optional<Score> evt=scoreRepository.getScore(c.getIdScore());
            if(evt.isPresent()){
                return scoreRepository.save(c);
            }else{
                return scoreRepository.save(c);
            }
        }
    }
    
    public Score update (Score score){
        if(score.getIdScore()!=null){
            Optional<Score> c=scoreRepository.getScore(score.getIdScore());
            if(!c.isPresent()){
                
                if(score.getMessageText()!=null){
                    c.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    c.get().setStars(score.getStars());
                }
                
                scoreRepository.save(c.get());
                return c.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
    
    //para eliminar un registro de habitacion
    public boolean deleteScore(int id) {
        Boolean aBoolean = getScore(id).map(score -> {
            scoreRepository.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
}
