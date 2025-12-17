package com.uma.example.springuma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.uma.example.springuma.model.Sintoma;

public class SintomaTest {
    
    private Sintoma sintoma;

    @BeforeEach
    public void setUp() {
        sintoma = new Sintoma();
    }

    @Test
    @DisplayName("Comprueba que el síntoma se crea correctamente con el constructor")
    public void sintoma_Constructor_Correcto() {
        // Arrange
        String nombre = "Migraña";
        LocalDate fecha = LocalDate.now();
        String desc = "Dolor fuerte";

        // Act
        Sintoma nuevo = new Sintoma(nombre, fecha, desc);
        
        // Assert
        assertEquals(nombre, nuevo.getNombre()); 
        assertEquals(fecha, nuevo.getFecha());
    }

    @Test
    @DisplayName("Comprueba que el nombre se gestiona correctamente")
    public void nombre_getSet_Correcto() {
        sintoma.setNombre("Fiebre");
        assertEquals("Fiebre", sintoma.getNombre()); 
    }

    @Test
    @DisplayName("Comprueba que el id se gestiona correctamente")
    public void id_getSet_Correcto() {
        sintoma.setId(1L);
        assertEquals(1L, sintoma.getId()); 
    }

    @Test
    @DisplayName("Comprueba que la fecha se gestiona correctamente")
    public void fecha_getSet_Correcto() {
        LocalDate hoy = LocalDate.now();
        sintoma.setFecha(hoy);
        assertEquals(hoy, sintoma.getFecha()); 
    }

    @Test
    @DisplayName("Comprueba que la descripción se gestiona correctamente")
    public void descripcion_getSet_Correcto() {
        sintoma.setDescripcion("Tos seca");
        assertEquals("Tos seca", sintoma.getDescripcion()); 
    }
}
