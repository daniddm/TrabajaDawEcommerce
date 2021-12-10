package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class AbstracDao {
	
	protected EntityManagerFactory emf; //de la librer�a persistence
	protected EntityManager em; //el EntityManager que llevar� los m�todosd del persiste, el find, querys y dem�s 
	protected EntityTransaction tx; //hereda tambi�n del java persistence para las transacciones
	protected Query query; //para las querys
	protected String sql; //para las jpql el string, que llamaremos sql
	
	public AbstracDao() {
		//llamamos a la clase persistence y su m�todo, al que le pasaremos un String con la unidad de persistencia.
		emf = Persistence.createEntityManagerFactory("Ecommerce_SanTierno"); //le pasamos el nombre del proyecto para que coja la conexi�n
		em = emf.createEntityManager(); //crea el entityManager y lo devuelve
		tx = em.getTransaction(); //Devuelve la transacci�n. 
	}

}
