package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.ModeloDeportista;
import es.aketzagonzalez.model.ModeloEvento;
import es.aketzagonzalez.model.ModeloParticipacion;

/**
 * The Class DaoParticipacion.
 */
public class DaoParticipacion {

	/**
	 * Insertar.
	 *
	 * @param p the p
	 * @param db the db
	 */
	public static void insertar(ModeloParticipacion p,ObjectContainer db) {
		db.store(p);
	}
	
	/**
	 * Conseguir por deportista y evento.
	 *
	 * @param dep the dep
	 * @param e the e
	 * @param db the db
	 * @return the modelo participacion
	 */
	public static ModeloParticipacion conseguirPorDeportistaEvento(ModeloDeportista dep,ModeloEvento e, ObjectContainer db) {
		ModeloParticipacion par=new ModeloParticipacion();
		par.setDeportista(dep);
		par.setEvento(e);
		ObjectSet<ModeloParticipacion> set=db.queryByExample(par);
		return set.hasNext() ? set.next() : null;
	}
	
}
