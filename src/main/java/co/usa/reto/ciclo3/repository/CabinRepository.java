/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto.ciclo3.repository;

import co.usa.reto.ciclo3.model.Cabin;
import co.usa.reto.ciclo3.repository.crud.CabinCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author JhonV
 */
@Repository
public class CabinRepository {
    
    @Autowired
    private CabinCrudRepository cabinCrudRepository;
    
    public List<Cabin> getAll(){
        return (List<Cabin>) cabinCrudRepository.findAll();
    }
    public Optional<Cabin> getCabin(int id){
        return cabinCrudRepository.findById(id);
    }
    public Cabin save(Cabin c){
        return cabinCrudRepository.save(c);
    }
    
}
