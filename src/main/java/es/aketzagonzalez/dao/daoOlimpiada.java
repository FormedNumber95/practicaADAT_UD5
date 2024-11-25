package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;

import es.aketzagonzalez.model.modeloOlimpiada;

public class daoOlimpiada {

	public static void insertar(modeloOlimpiada o,ObjectContainer db) {
	db.store(o);	
	}
	
}
