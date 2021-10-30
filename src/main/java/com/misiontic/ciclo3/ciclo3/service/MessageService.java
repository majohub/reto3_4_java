package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Messages;
import com.misiontic.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mariajo
 */
@Service
public class MessageService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private MessageRepository messageRepository;
    

    //va a retornar una lista
    public List<Messages> getAll(){
	return messageRepository.getAll();
    }
    


    //get para obtener una habitacion especifica
    //servicio
    public Optional<Messages> getMessage(int messageId){
	return messageRepository.getMessage(messageId);
    }
    

    //guardar un registro de habitacion 
    public Messages save(Messages message){
        if(message.getIdMessage() ==null){
            return messageRepository.save(message);
        }else{
            Optional<Messages> evt=messageRepository.getMessage(message.getIdMessage());
            if(evt.isPresent()){
                return messageRepository.save(message);
            }else{
                return messageRepository.save(message);
            }
        }
    }
    
    public Messages update (Messages messages){
        if(messages.getIdMessage()!=null){
            Optional<Messages> c= messageRepository.getMessage(messages.getIdMessage());
            if(!c.isEmpty()){
                if(messages.getMessageText()!=null){
                    c.get().setMessageText(messages.getMessageText());
                }
                messageRepository.save(c.get());
                return c.get();
            }else{
                return messages;
            }
        }else{
            return messages;
        }
    }
    

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessage(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }   
}
