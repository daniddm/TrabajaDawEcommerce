package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class AbstracDao {
	
	protected EntityManagerFactory emf; //de la librería persistence
	protected EntityManager em; //el EntityManager que llevará los métodosd del persiste, el find, querys y demás 
	protected EntityTransaction tx; //hereda también del java persistence para las transacciones
	protected Query query; //para las querys
	protected String sql; //para las jpql el string, que llamaremos sql
	
	public AbstracDao() {
		//llamamos a la clase persistence y su método, al que le pasaremos un String con la unidad de persistencia.
		emf = Persistence.createEntityManagerFactory("Ecommerce_SanTierno"); //le pasamos el nombre del proyecto para que coja la conexión
		em = emf.createEntityManager(); //crea el entityManager y lo devuelve
		tx = em.getTransaction(); //Devuelve la transacción. 
	}

}
