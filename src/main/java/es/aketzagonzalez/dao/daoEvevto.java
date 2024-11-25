package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;

import es.aketzagonzalez.model.modeloEvento;

public class daoEvevto {

public static void insertar(modeloEvento e,ObjectContainer db) {
		db.store(e);
	}
	
}
