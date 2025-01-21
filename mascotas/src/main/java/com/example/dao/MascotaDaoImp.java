package com.example.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Mascota;

@Repository // pARA QUE SE RECONOZCA OMO UN BEAN
public class MascotaDaoImp implements CrudDAO<Mascota> {
	private static final Logger log = LogManager.getLogger();


	// si quito el bean del dipatcher solo basta con @Autowired
	@Autowired
	private SessionFactory hibernatesessionFactory;

	/*
	 * esta inyeccion se definia desde le dispatcher como stter public void
	 * setSessionFactory(SessionFactory sf) { this.sessionFactory = sf; }
	 */

	@Override
	//@Transactional//transactional hace automaticamnete el begin y el commit
//@Transactional
	public void guardar(Mascota mascota) {
		Session myseSession = hibernatesessionFactory.openSession();
		myseSession.beginTransaction();
		myseSession.persist(mascota);
		myseSession.getTransaction().commit();
		log.info("Mascota Guardada Correctamnete, Detalles="+mascota);

	}

	@Override
	public Mascota encontrarPorId(int id) {
		Session myseSession = hibernatesessionFactory.openSession();
		
		myseSession.beginTransaction();
		Mascota mascota = myseSession.get(Mascota.class, id);
		log.info("Mascota Encontrada Correctamnete, Detalles="+mascota);
		myseSession.getTransaction().commit();


		return mascota;
	}

	@Override
	public List<Mascota> mostrarTodos() {
		Session myseSession = hibernatesessionFactory.openSession();
		myseSession.beginTransaction();
		List<Mascota> mascotas = myseSession.createQuery("From Mascota", Mascota.class).getResultList();

		myseSession.getTransaction().commit();
		log.info("Mascotas Cargadas Correctamnete, Detalles="+mascotas);

		return mascotas;
	}

	@Override
	public void actualizar(Mascota mascota) {
		Session myseSession = hibernatesessionFactory.openSession();
		myseSession.beginTransaction();
		myseSession.merge(mascota);

		myseSession.getTransaction().commit();
		log.info("Mascota Actualixada Correctamnete, Detalles="+mascota);


	}

	@Override
	public void eliminar(Mascota mascota) {
		Session myseSession = hibernatesessionFactory.openSession();
		myseSession.beginTransaction();
		myseSession.remove(mascota);

		myseSession.getTransaction().commit();
		log.info("Mascota Eliminada Correctamnete, Detalles="+mascota);


	}

}
