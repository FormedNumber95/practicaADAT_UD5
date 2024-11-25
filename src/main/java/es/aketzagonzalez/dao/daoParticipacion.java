package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.modeloDeportista;
import es.aketzagonzalez.model.modeloEvento;
import es.aketzagonzalez.model.modeloParticipacion;

public class daoParticipacion {

	public static void insertar(modeloParticipacion p,ObjectContainer db) {
		db.store(p);
	}
	
	public static modeloParticipacion conseguirPorDeportistaEvento(modeloDeportista dep,modeloEvento e, ObjectContainer db) {
		modeloParticipacion par=new modeloParticipacion();
		par.setDeportista(dep);
		par.setEvento(e);
		ObjectSet<modeloParticipacion> set=db.queryByExample(par);
		return set.hasNext() ? set.next() : null;
	}
	
}
