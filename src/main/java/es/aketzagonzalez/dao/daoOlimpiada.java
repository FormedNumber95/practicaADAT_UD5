package es.aketzagonzalez.dao;

import java.util.List;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import es.aketzagonzalez.model.modeloOlimpiada;

public class daoOlimpiada {

	public static void insertar(modeloOlimpiada o,ObjectContainer db) {
	db.store(o);	
	}
	
	public static List<modeloOlimpiada> conseguirPorTemporada(String temporada,ObjectContainer db){
		List<modeloOlimpiada> olimpiadas=db.query(new Predicate<modeloOlimpiada>() {

			@Override
			public boolean match(modeloOlimpiada o) {
				return o.getTemporada().equals(temporada);
			}
		});
		return olimpiadas;
	}
	
	public static modeloOlimpiada conseguirPorNombre(String nombre, ObjectContainer db) {
		modeloOlimpiada dep=new modeloOlimpiada();
		dep.setNombre(nombre);
		ObjectSet<modeloOlimpiada> set=db.queryByExample(dep);
		return set.hasNext() ? set.next() : null;
	}
	
}
