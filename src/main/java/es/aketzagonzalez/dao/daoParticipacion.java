package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;

import es.aketzagonzalez.model.modeloParticipacion;

public class daoParticipacion {

	public static void insertar(modeloParticipacion p,ObjectContainer db) {
		db.store(p);
	}
	
}
