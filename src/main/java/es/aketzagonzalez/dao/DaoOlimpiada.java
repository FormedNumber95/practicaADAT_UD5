package es.aketzagonzalez.dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import es.aketzagonzalez.model.ModeloOlimpiada;

/**
 * The Class DaoOlimpiada.
 */
public class DaoOlimpiada {

	/**
	 * Insertar.
	 *
	 * @param o the o
	 * @param db the db
	 */
	public static void insertar(ModeloOlimpiada o,ObjectContainer db) {
	db.store(o);	
	}
	
	/**
	 * Conseguir por temporada.
	 *
	 * @param temporada the temporada
	 * @param db the db
	 * @return the list
	 */
	public static List<ModeloOlimpiada> conseguirPorTemporada(String temporada,ObjectContainer db){
		List<ModeloOlimpiada> olimpiadas=db.query(new Predicate<ModeloOlimpiada>() {

			@Override
			public boolean match(ModeloOlimpiada o) {
				return o.getTemporada().equals(temporada);
			}
		});
		return olimpiadas;
	}
	
	/**
	 * Conseguir por nombre.
	 *
	 * @param nombre the nombre
	 * @param db the db
	 * @return the modelo olimpiada
	 */
	public static ModeloOlimpiada conseguirPorNombre(String nombre, ObjectContainer db) {
		ModeloOlimpiada dep=new ModeloOlimpiada();
		dep.setNombre(nombre);
		ObjectSet<ModeloOlimpiada> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
