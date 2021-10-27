/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto.ciclo3.service;

import co.usa.reto.ciclo3.model.Message;
import co.usa.reto.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JhonV
 */
@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message m){
        if (m.getId()==null){
            return messageRepository.save(m);
        } else{
            Optional<Message> messaux = messageRepository.getMessage(m.getId());
            if (messaux.isEmpty()){
                return messageRepository.save(m);
            } else{
                return m;
            }

        }

    }
}
