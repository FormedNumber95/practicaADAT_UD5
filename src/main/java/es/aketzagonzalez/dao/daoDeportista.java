package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;

import es.aketzagonzalez.model.modeloDeportista;

public class daoDeportista {

	public static void insertar(modeloDeportista dep,ObjectContainer db) {
		db.store(dep);
	}
	
}
