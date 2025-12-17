package com.uma.example.springuma.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SintomaService {

    @Autowired
    private RepositorySintoma repositorySintoma;

    // Obtiene todos los síntomas registrados
    public List<Sintoma> getAllSintomas(){
        return repositorySintoma.findAll();
    }

    // Obtiene un síntoma por su ID, devuelve null si no existe
    public Sintoma getSintoma(Long id){
        return repositorySintoma.findById(id).orElse(null);
    }

    // Guarda un nuevo síntoma en la base de datos
    public Sintoma addSintoma(Sintoma s){
        return repositorySintoma.save(s);
    }

    /**
     * Actualiza un síntoma existente.
     * Lanza IllegalArgumentException si el síntoma no existe para cumplir con el test de referencia.
     */
    public Sintoma updateSintoma(Sintoma s){
        Sintoma sintomaExistente = repositorySintoma.findById(s.getId()).orElse(null);
        
        if (sintomaExistente == null) {
            throw new IllegalArgumentException("El síntoma con ID " + s.getId() + " no existe.");
        }
        
        sintomaExistente.setNombre(s.getNombre());
        sintomaExistente.setFecha(s.getFecha());
        sintomaExistente.setDescripcion(s.getDescripcion());
        
        return repositorySintoma.save(sintomaExistente);
    }

    /**
     * Elimina un síntoma pasando el objeto.
     * Lanza IllegalArgumentException si el síntoma no existe en la BD.
     */
    public void removeSintoma(Sintoma s){
        if (!repositorySintoma.existsById(s.getId())) {
            throw new IllegalArgumentException("No se puede eliminar: el síntoma no existe.");
        }
        repositorySintoma.delete(s);
    }

    /**
     * Elimina un síntoma por ID.
     * Valida que el ID no sea nulo y que exista antes de intentar borrar.
     */
    public void removeSintomaID(Long id){
        if (id == null || !repositorySintoma.existsById(id)) {
            throw new IllegalArgumentException("ID nulo o síntoma inexistente.");
        }
        repositorySintoma.deleteById(id);
    }
}