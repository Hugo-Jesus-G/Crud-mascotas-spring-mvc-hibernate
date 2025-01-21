package com.example.mascotas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

public class AppIngresar {

    public static void main(String[] args) {
    	
    	
        // Cargar el contexto desde application-context.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        // Obtener el bean del servicio de mascotas
        MascotaService mascotaService = context.getBean(MascotaService.class);

        // Crear una nueva mascota
        Mascota nuevaMascota = new Mascota();
        nuevaMascota.setNombre("mariano");
        nuevaMascota.setDescripcion("perro chaparro");
        nuevaMascota.setEdad(12);

        // Guardar la mascota usando el servicio
        try {
            mascotaService.guardar(nuevaMascota);
            System.out.println("Mascota guardada correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
