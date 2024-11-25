package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.ModeloEvento;

/**
 * The Class DaoEvento.
 */
public class DaoEvento {

	/**
	 * Insertar.
	 *
	 * @param e the e
	 * @param db the db
	 */
	public static void insertar(ModeloEvento e,ObjectContainer db) {
		db.store(e);
	}
	
	/**
	 * Conseguir por nombre.
	 *
	 * @param nombre the nombre
	 * @param db the db
	 * @return the modelo evento
	 */
	public static ModeloEvento conseguirPorNombre(String nombre, ObjectContainer db) {
		ModeloEvento dep=new ModeloEvento();
		dep.setNombre(nombre);
		ObjectSet<ModeloEvento> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
