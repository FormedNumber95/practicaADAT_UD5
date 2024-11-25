package es.aketzagonzalez.dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import es.aketzagonzalez.model.ModeloDeporte;
import es.aketzagonzalez.model.ModeloEvento;
import es.aketzagonzalez.model.ModeloOlimpiada;

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
		ModeloEvento e=new ModeloEvento();
		e.setNombre(nombre);
		ObjectSet<ModeloEvento> set=db.queryByExample(e);
		return set.hasNext() ? set.next() : null;
	}
	
	/**
	 * Conseguir por olimpiada.
	 *
	 * @param o the o
	 * @param db the db
	 * @return the list
	 */
	public static List<ModeloEvento> conseguirPorOlimpiada(ModeloOlimpiada o,ObjectContainer db) {
		List<ModeloEvento> eventos=db.query(new Predicate<ModeloEvento>() {

			@Override
			public boolean match(ModeloEvento e) {
				return e.getOlimpiada().equals(o);
			}
		});
		return eventos;

	}
	
	/**
	 * Conseguir por olimpiada deporte.
	 *
	 * @param o the o
	 * @param d the d
	 * @param db the db
	 * @return the list
	 */
	public static List<ModeloEvento> conseguirPorOlimpiadaDeporte(ModeloOlimpiada o,ModeloDeporte d,ObjectContainer db) {
		List<ModeloEvento> eventos=db.query(new Predicate<ModeloEvento>() {

			@Override
			public boolean match(ModeloEvento e) {
				return e.getOlimpiada().equals(o)&&e.getDeporte().equals(d);
			}
		});
		return eventos;

	}
	
}
