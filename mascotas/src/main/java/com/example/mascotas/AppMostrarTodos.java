package com.example.mascotas;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

import io.micrometer.observation.Observation.Context;

public class AppMostrarTodos {
public static void main(String[] args) {
	
	
	
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    
    MascotaService m=context.getBean(MascotaService.class);
    
    List<Mascota> mascotas=m.mostrarTodos();
    
    
for (Mascota ma:mascotas) {
	
	System.out.println(ma);
	
	
	
}
	
}
    
    

}
