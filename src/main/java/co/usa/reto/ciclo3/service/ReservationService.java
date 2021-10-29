package co.usa.reto.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.reto.ciclo3.model.Reservation;
import co.usa.reto.ciclo3.repository.ReservationRepository;

/**
 *
 * @author JhonV
 */
@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    public Reservation save(Reservation r){
        if (r.getIdReservation()==null){
            return reservationRepository.save(r);
        } else{
            Optional<Reservation> reaux = reservationRepository.getReservation(r.getIdReservation());
            if  (reaux.isEmpty()){
                return reservationRepository.save(r);
            } else{
                return r;
            }

        }

    }
}
