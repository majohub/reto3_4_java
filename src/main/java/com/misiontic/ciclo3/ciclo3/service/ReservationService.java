package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Reservations;
import com.misiontic.ciclo3.ciclo3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariajo
 */
@Service
public class ReservationService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private ReservationRepository reservationRepository;
    

    //va a retornar una lista
    public List<Reservations> getAll(){
	return reservationRepository.getAll();
    }

/**
    get para obtener una habitacion especifica
    servicio 
 */

    public Optional<Reservations> getReservation(int reservationId) {
	return reservationRepository.getReservation(reservationId);
    }
    

    //guardar un registro de habitacion 
    public Reservations save(Reservations reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservations> evt=reservationRepository.getReservation(reservation.getIdReservation());
            if(evt.isEmpty()){
                return reservationRepository.save(reservation);
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }
    
    public Reservations update (Reservations reservations){
        if(reservations.getIdReservation()!=null){
            Optional<Reservations> c=reservationRepository.getReservation(reservations.getIdReservation());
            if(!c.isPresent()){
                
                if(reservations.getStartDate()!=null){
                    c.get().setStartDate(reservations.getStartDate());
                }
                if(reservations.getDevolutionDate()!=null){
                    c.get().setDevolutionDate(reservations.getDevolutionDate());
                }
                if(reservations.getStatus()!=null){
                    c.get().setStatus(reservations.getStatus());
                }
                reservationRepository.save(c.get());
                return c.get();
            }else{
                return reservations;
            }
        }else{
            return reservations;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean =  getReservation(reservationId).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
