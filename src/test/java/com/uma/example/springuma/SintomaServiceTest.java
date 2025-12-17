package com.uma.example.springuma;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.uma.example.springuma.model.Sintoma;
import com.uma.example.springuma.model.SintomaService;
import com.uma.example.springuma.model.RepositorySintoma;

@ExtendWith(MockitoExtension.class)
public class SintomaServiceTest {
    
    @Mock
    RepositorySintoma repositorySintoma;

    @InjectMocks
    private SintomaService sintomaService;

    @Test
    @DisplayName("Comprueba que se pueden obtener todos los síntomas")
    public void getAllSintomas_obtieneLista() {
        Sintoma s1 = new Sintoma("Gripe", LocalDate.now(), "Fiebre");
        when(repositorySintoma.findAll()).thenReturn(Arrays.asList(s1));

        List<Sintoma> result = sintomaService.getAllSintomas();

        assertEquals(1, result.size());
        verify(repositorySintoma).findAll();
    }

    @Test
    @DisplayName("Comprueba que se puede añadir un síntoma")
    public void addSintoma_nuevo_añadido() {
        Sintoma s = new Sintoma("Tos", LocalDate.now(), "Seca");
        when(repositorySintoma.save(s)).thenReturn(s);

        Sintoma result = sintomaService.addSintoma(s);

        assertEquals("Tos", result.getNombre());
        verify(repositorySintoma).save(s);
    }

    @Test
    @DisplayName("Comprueba error al actualizar síntoma inexistente")
    public void updateSintoma_noExiste_lanzaExcepcion() {
        Sintoma s = new Sintoma();
        s.setId(1L);
        when(repositorySintoma.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> sintomaService.updateSintoma(s));
        verify(repositorySintoma, never()).save(any());
    }

    @Test
    @DisplayName("Comprueba que se puede eliminar por ID")
    public void removeSintomaID_existe_eliminado() {
        Long id = 1L;
        when(repositorySintoma.existsById(id)).thenReturn(true);

        sintomaService.removeSintomaID(id);

        verify(repositorySintoma).deleteById(id);
    }
}
