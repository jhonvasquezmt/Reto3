package co.usa.reto.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto.ciclo3.model.Score;
import co.usa.reto.ciclo3.repository.ScoreRepository;

/**
 *
 * @author JhonV
 */
@Service
public class ScoreService {
    
    @Autowired
    private ScoreRepository scoreRepository;
    
    public List <Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional <Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    public Score save(Score s){
        if (s.getId()==null){ 
            return scoreRepository.save(s);
        } else{
            Optional <Score> scaux = scoreRepository.getScore(s.getId());
            if (scaux.isEmpty()){
                return scoreRepository.save(s);
            } else{
                return s;
            }

        }

    }
}
