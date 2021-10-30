/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Mariajo
 */
@Entity
@Table(name="room")
public class Room implements Serializable{
    
    @Id
    //Para que el id sea autogenerado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * 
     */
    private Integer id;
    private String name;
    private String hotel;
    private Integer stars;
    private String description;
    
    
    //le estamos dando un objeto para crear una relacion con Categoria
    @ManyToOne
    //como se va a llamar la llave foranea
    @JoinColumn(name = "categoryId")
    //Aqui mirar muy bien si en el parentesis va habitaciones
    @JsonIgnoreProperties("room")
    private Category category;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Messages> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    private List<Reservations> reservations;
    
    /**
     * 
     * @return 
     */
    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
