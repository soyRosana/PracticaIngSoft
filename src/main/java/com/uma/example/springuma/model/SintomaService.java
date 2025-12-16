package com.uma.example.springuma.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomaService {

    @Autowired
    RepositorySintoma repositorySintoma;

    public List<Sintoma> getAllSintomas(){
        return repositorySintoma.findAll();
    }

    public Sintoma getSintoma(Long id){
        return repositorySintoma.findById(id).orElse(null);
    }

    public Sintoma addSintoma(Sintoma s){
        return repositorySintoma.save(s);
    }

    public Sintoma updateSintoma(Sintoma s){
        Sintoma sintomaExistente = repositorySintoma.findById(s.getId()).orElse(null);
        
        if (sintomaExistente != null) {
            sintomaExistente.setNombre(s.getNombre());
            sintomaExistente.setFecha(s.getFecha());
            sintomaExistente.setDescripcion(s.getDescripcion());
            
            return repositorySintoma.save(sintomaExistente);
        }
        return null; 
    }

    public void removeSintoma(Sintoma s){
        repositorySintoma.delete(s);
    }

    public void removeSintomaID(Long id){
        repositorySintoma.deleteById(id);
    }
}
