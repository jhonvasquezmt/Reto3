/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto.ciclo3.repository.crud;


import co.usa.reto.ciclo3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JhonV
 */
public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
    
}
