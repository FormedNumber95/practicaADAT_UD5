package es.aketzagonzalez.dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import es.aketzagonzalez.model.modeloEquipo;

public class daoEquipo {

	public static void insertar(modeloEquipo e,ObjectContainer db) {
		db.store(e);
	}
	
	public static modeloEquipo conseguirPorNombre(String nombre, ObjectContainer db) {
		modeloEquipo dep=new modeloEquipo();
		dep.setNombre(nombre);
		ObjectSet<modeloEquipo> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
