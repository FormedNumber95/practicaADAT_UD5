package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.modeloDeporte;

public class daoDeporte {

	public static void insertar(modeloDeporte dep, ObjectContainer db) {
		db.store(dep);
	}
	
	public static modeloDeporte conseguirPorNombre(String nombre, ObjectContainer db) {
		modeloDeporte dep=new modeloDeporte();
		dep.setNombre(nombre);
		ObjectSet<modeloDeporte> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
