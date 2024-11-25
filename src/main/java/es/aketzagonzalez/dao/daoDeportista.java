package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.modeloDeportista;

public class daoDeportista {

	public static void insertar(modeloDeportista dep,ObjectContainer db) {
		db.store(dep);
	}
	
	public static modeloDeportista conseguirPorNombre(String nombre, ObjectContainer db) {
		modeloDeportista dep=new modeloDeportista();
		dep.setNombre(nombre);
		ObjectSet<modeloDeportista> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
