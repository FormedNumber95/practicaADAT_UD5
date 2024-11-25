package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.ModeloEquipo;

/**
 * The Class DaoEquipo.
 */
public class DaoEquipo {

	/**
	 * Insertar.
	 *
	 * @param e the e
	 * @param db the db
	 */
	public static void insertar(ModeloEquipo e,ObjectContainer db) {
		db.store(e);
	}
	
	/**
	 * Conseguir por nombre.
	 *
	 * @param nombre the nombre
	 * @param db the db
	 * @return the modelo equipo
	 */
	public static ModeloEquipo conseguirPorNombre(String nombre, ObjectContainer db) {
		ModeloEquipo dep=new ModeloEquipo();
		dep.setNombre(nombre);
		ObjectSet<ModeloEquipo> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
