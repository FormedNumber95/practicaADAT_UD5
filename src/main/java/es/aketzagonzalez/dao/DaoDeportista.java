package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.ModeloDeportista;

/**
 * The Class DaoDeportista.
 */
public class DaoDeportista {

	/**
	 * Insertar.
	 *
	 * @param dep the dep
	 * @param db the db
	 */
	public static void insertar(ModeloDeportista dep,ObjectContainer db) {
		db.store(dep);
	}
	
	/**
	 * Conseguir por nombre.
	 *
	 * @param nombre the nombre
	 * @param db the db
	 * @return the modelo deportista
	 */
	public static ModeloDeportista conseguirPorNombre(String nombre, ObjectContainer db) {
		ModeloDeportista dep=new ModeloDeportista();
		dep.setNombre(nombre);
		ObjectSet<ModeloDeportista> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
