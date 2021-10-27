/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.usa.reto.ciclo3.web;

import co.usa.reto.ciclo3.model.Cabin;
import co.usa.reto.ciclo3.service.CabinService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JhonV
 */
@RestController
@RequestMapping("/api/Cabin")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CabinController {
    
    @Autowired
    private CabinService cabinService;
    
    @GetMapping("/all")
    public List<Cabin> getCabins(){
        return cabinService.getAll();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cabin save(@RequestBody Cabin c){
        return cabinService.save(c);
    }
    
    @GetMapping("/{id}")
    public Optional<Cabin> getCabin(@PathVariable("id") int id){
        return cabinService.getCabin(id);
    }
}
