package com.example.mascotas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

public class AppActualizar {

    public static void main(String[] args) {
         ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

         MascotaService mascotaService = context.getBean(MascotaService.class);

        int mascotaId = 8;

        Mascota mascota = mascotaService.encontrarPorId(mascotaId);

         if (mascota != null) {
             mascota.setNombre("lalo");
            mascota.setDescripcion("Golden Retriever actualizado");
            mascota.setEdad(4);

             try {
                mascotaService.actualizar(mascota);
                System.out.println("Mascota actualizada correctamente.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("La mascota con ID " + mascotaId + " no existe.");
        }
    }
}
