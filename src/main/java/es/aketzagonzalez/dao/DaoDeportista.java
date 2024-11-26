package es.aketzagonzalez.dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

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
	
	/**
	 * Conseguir por fragmento del nombre.
	 *
	 * @param fragmentoNombre the fragmento nombre
	 * @param db the db
	 * @return the modelo deportista
	 */
	public static List<ModeloDeportista> conseguirPorFragmentoNombre(String fragmentoNombre, ObjectContainer db) {
	    List<ModeloDeportista> resultados = db.query(new Predicate<ModeloDeportista>() {
	        @Override
	        public boolean match(ModeloDeportista dep) {
	            return dep.getNombre() != null && dep.getNombre().contains(fragmentoNombre);
	        }
	    });
	    return resultados.isEmpty() ? null : resultados;
	}

	
}
