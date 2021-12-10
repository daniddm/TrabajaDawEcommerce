package modelo.dao;


import java.util.List;


import modelo.beans.Usuario;

public class UsuarioDaoImpl extends AbstracDao implements IntUsuarioDao{

	public UsuarioDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int altaUsuario(Usuario usuario) {
		int filas = 0; //Si el usuario no existe
		try { //intentar
			tx.begin(); //hacer la transacción 
			em.persist(usuario); //Definimos la transacción con em + método()
			tx.commit(); //Confirmamos la transacción comenzada
			filas = 1; //y decimos que ahora la fila ya tiene un valor
		} catch (Exception e) { //hacemos la excepción
			e.printStackTrace();
		} 
		return filas; //y retornamos las filas
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByUser(String email, String password) {
		sql = "SELECT u FROM Usuario u WHERE u.email =:cod1 AND u.password =:cod2"; //consulta sql
		query = em.createQuery(sql); 
		query.setParameter("cod1", email); 
		query.setParameter("cod2", password); 
		return query.getResultList(); 
	}

	@Override
	public Usuario findById(int id_Usuario) {
		return em.find(Usuario.class,id_Usuario);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> findByAll() {
		sql = "select u from Usuario u";
		query = em.createQuery(sql);
		return query.getResultList();
	}

	@Override
	public Usuario findByEmail(String email) {
		sql = "SELECT u FROM Usuario u WHERE u.email =:cod1"; 
		query = em.createQuery(sql); 
		query.setParameter("cod1", email); 
		return query.getResultList().isEmpty() ? null : (Usuario) query.getResultList().get(0); 
	}

	@Override
	public Boolean checkLogin(String email, String password) {
		sql = "SELECT u FROM Usuario u WHERE u.email =:cod1 AND u.password =:cod2"; 
		query = em.createQuery(sql);
		query.setParameter("cod1", email); 
		query.setParameter("cod2", password); 
		return query.getResultList().isEmpty() ? false : true; 
	}

}
