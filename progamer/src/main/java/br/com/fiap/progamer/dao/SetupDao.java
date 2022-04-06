package br.com.fiap.progamer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.fiap.progamer.model.Setup;

public class SetupDao {
	
	public void create(Setup setup) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.clear();
	}
	
	public List<Setup> listAll(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("progamer-persistence-unit");
		EntityManager manager = factory.createEntityManager();

		TypedQuery<Setup> query = manager.createQuery("SELECT s FROM Setup s", Setup.class);
		
		return query.getResultList();
	}

}
