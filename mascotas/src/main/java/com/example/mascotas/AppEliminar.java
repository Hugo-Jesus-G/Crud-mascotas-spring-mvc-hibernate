package com.example.mascotas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

public class AppEliminar {

    public static void main(String[] args) {
        // Cargar el contexto desde application-context.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        // Obtener el bean del servicio de mascotas
        MascotaService mascotaService = context.getBean(MascotaService.class);

        int mascotaId = 2;

        // Buscar la mascota por ID
        Mascota mascota = mascotaService.encontrarPorId(mascotaId);
        
        System.out.println("se eliminara a :"+mascota);

        // Verificar si la mascota existe
        if (mascota != null) {
            // Eliminar la mascota usando el servicio
            try {
                mascotaService.eliminar(mascota);
                System.out.println("Mascota eliminada correctamente.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La mascota con ID " + mascotaId + " no existe.");
        }
    }
}
