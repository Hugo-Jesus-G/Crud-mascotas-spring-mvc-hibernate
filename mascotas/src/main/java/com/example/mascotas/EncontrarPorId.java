package com.example.mascotas;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.entities.Mascota;
import com.example.service.MascotaService;

public class EncontrarPorId {
	public static void main(String[] args) {
		
		
		
	  ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
	    
	  MascotaService m=context.getBean(MascotaService.class);
	    
	  Mascota mas=m.encontrarPorId(1);
	  System.out.println(mas);
	  
	  
	  
		
	}
}
