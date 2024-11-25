package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;

import es.aketzagonzalez.model.modeloEquipo;

public class daoEquipo {

	public static void insertar(modeloEquipo e,ObjectContainer db) {
		db.store(e);
	}
	
}
