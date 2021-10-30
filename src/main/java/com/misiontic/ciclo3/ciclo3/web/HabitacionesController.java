package com.misiontic.ciclo3.ciclo3.web;

import com.misiontic.ciclo3.ciclo3.model.Room;
import com.misiontic.ciclo3.ciclo3.service.HabitacionesService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Mariajo
 */
@RestController
@RequestMapping("/api/Room")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class HabitacionesController {
    @Autowired
    private HabitacionesService habitacionesService;

    @GetMapping("/all")
    public List<Room> getHabitaciones(){
        return habitacionesService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Room> getHabitaciones(@PathVariable("id") int roomId){
        return habitacionesService.getHabitaciones(roomId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Room save(@RequestBody Room room){
        return habitacionesService.save(room);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Room update(@RequestBody Room room){
        return habitacionesService.update(room);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int roomId) {
        return habitacionesService.deleteHabitaciones(roomId);
    }
}
