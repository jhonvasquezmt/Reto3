/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto.ciclo3.service;

import co.usa.reto.ciclo3.model.Cabin;
import co.usa.reto.ciclo3.repository.CabinRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JhonV
 */
@Service
public class CabinService {
    
    @Autowired
    private CabinRepository cabinRepository;
    
    public List<Cabin> getAll(){
        return cabinRepository.getAll();
    }
    
    public Optional<Cabin> getCabin(int id){
        return cabinRepository.getCabin(id);
    }
    
    public Cabin save(Cabin c){
        if (c.getId()==null){
            return cabinRepository.save(c);
        } else{
            Optional<Cabin> cabaux = cabinRepository.getCabin(c.getId());
            if (cabaux.isEmpty()){
                return cabinRepository.save(c);
            } else{
                return c;
            }

        }

    }
}

