package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.modeloEvento;

public class daoEvevto {

	public static void insertar(modeloEvento e,ObjectContainer db) {
		db.store(e);
	}
	
	public static modeloEvento conseguirPorNombre(String nombre, ObjectContainer db) {
		modeloEvento dep=new modeloEvento();
		dep.setNombre(nombre);
		ObjectSet<modeloEvento> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
