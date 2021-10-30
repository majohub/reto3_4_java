package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Room;
import com.misiontic.ciclo3.ciclo3.repository.HabitacionesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Mariajo
 */

@Service
public class HabitacionesService {


    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private HabitacionesRepository habitacionesRepository;
    

    //va a retornar una lista
    public List<Room> getAll(){
	return habitacionesRepository.getAll();
    }
    


    //get para obtener una habitacion especifica
    //servicio
    public Optional<Room> getHabitaciones(int roomId){
	return habitacionesRepository.getHabitaciones(roomId);
    }
    

    //guardar un registro de habitacion 
    public Room save(Room room){
        if(room.getId() == null){
            return habitacionesRepository.save(room);
        }else{
            Optional<Room> evt=habitacionesRepository.getHabitaciones(room.getId());
            if(evt.isEmpty()){
                return habitacionesRepository.save(room);
            }else{
                return room;
            }
        }
    }
    
    public Room update (Room room){
        if(room.getId()!=null){
            Optional<Room> c=habitacionesRepository.getHabitaciones(room.getId());
            if(!c.isEmpty()){
                if(room.getName()!=null){
                    c.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    c.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    c.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    c.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    c.get().setCategory(room.getCategory());
                }
                
                habitacionesRepository.save(c.get());
                return c.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }
  

    public boolean deleteHabitaciones(int roomId) {
        Boolean aBoolean = getHabitaciones(roomId).map(habitaciones -> {
            habitacionesRepository.delete(habitaciones);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}



	