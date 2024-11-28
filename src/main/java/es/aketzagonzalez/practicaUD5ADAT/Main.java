package es.aketzagonzalez.practicaUD5ADAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.db4o.ObjectContainer;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import es.aketzagonzalez.dao.DaoDeporte;
import es.aketzagonzalez.dao.DaoDeportista;
import es.aketzagonzalez.dao.DaoEquipo;
import es.aketzagonzalez.dao.DaoEvento;
import es.aketzagonzalez.dao.DaoOlimpiada;
import es.aketzagonzalez.dao.DaoParticipacion;
import es.aketzagonzalez.db.DB;
import es.aketzagonzalez.model.ModeloDeporte;
import es.aketzagonzalez.model.ModeloDeportista;
import es.aketzagonzalez.model.ModeloEquipo;
import es.aketzagonzalez.model.ModeloEvento;
import es.aketzagonzalez.model.ModeloOlimpiada;
import es.aketzagonzalez.model.ModeloParticipacion;

/**
 * The Class Main.
 */
public class Main {
	
	/**
	 * Cargar datos.
	 *
	 * @param ruta the ruta
	 * @param db the db
	 */
	public static void cargarDatos(File ruta,ObjectContainer db) {
		try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
			 List<String[]> lineas = reader.readAll();
	         lineas.remove(0); // Remover cabecera
	         for (String[] linea : lineas) {
	        	ModeloDeporte deporte=DaoDeporte.conseguirPorNombre(linea[12],db);
	        	if(deporte==null) {
	        		deporte=new ModeloDeporte(linea[12]);
	        	}
	        	ModeloDeportista deportista=DaoDeportista.conseguirPorNombre(linea[1], db);
	        	if(deportista==null) {
	        		float f;
	        		try {
	        			f=Float.parseFloat(linea[5]);
	        		}catch (NumberFormatException e) {
	        			f=0f;
	        		}
	        		int i;
	        		try {
	        			i=Integer.parseInt(linea[4]);
	        		}catch (NumberFormatException e) {
	        			i=0;
	        		}
	        		deportista=new ModeloDeportista(linea[1],linea[2].charAt(0), f, i);
	        	}
	        	ModeloEquipo equipo=DaoEquipo.conseguirPorNombre(linea[6], db);
	        	if(equipo==null) {
	        		equipo=new ModeloEquipo(linea[6], linea[7]);
	        	}
	        	ModeloOlimpiada olimpiada=DaoOlimpiada.conseguirPorNombre(linea[8], db);
	        	if(olimpiada==null) {
	        		int i;
	        		try {
	        			i=Integer.parseInt(linea[9]);
	        		}catch(NumberFormatException e) {
	        			i=0;
	        		}
	        		olimpiada=new ModeloOlimpiada(linea[8],i,linea[10],linea[11]);
	        	}
	        	ModeloEvento evento=DaoEvento.conseguirPorNombre(linea[13], db);
	        	if(evento==null) {
	        		evento=new ModeloEvento(linea[13], olimpiada, deporte);
	        	}
	        	ModeloParticipacion participacion=DaoParticipacion.conseguirPorDeportistaEvento(deportista, evento, db);
	        	if(participacion==null) {
	        		int i;
	        		try {
	        			i=Integer.parseInt(linea[3]);
	        		}catch(NumberFormatException e) {
	        			i=0;
	        		}
	        		participacion=new ModeloParticipacion(deportista, evento, equipo, i, linea[14]);
	        	}
	        		DaoDeporte.insertar(deporte, db);
	        		DaoDeportista.insertar(deportista, db);
	        		DaoEquipo.insertar(equipo, db);
	        		DaoEvento.insertar(evento, db);
	        		DaoOlimpiada.insertar(olimpiada, db);
	        		DaoParticipacion.insertar(participacion, db);
	         }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que ejecuta el menu y sus diferentes opciones.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ObjectContainer db=new DB().getConnection() ;
		Scanner input=new Scanner(System.in);
		ModeloDeporte d=new ModeloDeporte();
		File f=null;
		try {
			f = new File(d.getClass().getResource("/csv/athlete_events-sort.csv").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		//Descomentar para cargar los datos
		//cargarDatos(f, db);
        System.out.println("1:\tListado de deportistas participantes:");
        System.out.println("2:\tModificar medalla deportista:");
        System.out.println("3:\tAñadir deportista/participación::");
        System.out.println("4:\tEliminar participación:");
        System.out.println("0:\tSALIR:");
        int respuesta=input.nextInt();
        input.nextLine();
        switch(respuesta) {
	        case 1:
	        	Listar(input,db);
	        	break;
	        case 2:
	        	int resp=0;
	        	List<ModeloDeportista> deportistas=null;
	        	do {
	        		System.out.println("Dime el nombre del deportista a buscar");
		        	String nombre=input.nextLine();
		        	deportistas=DaoDeportista.conseguirPorFragmentoNombre(nombre, db);
		        	if(deportistas==null) {
		        		System.out.println("ningun deportista coincide con el nombre insertado");
		        		
		        	}else {
			        	for(int i=0;i<deportistas.size();i++) {
			        		System.out.println((i+1)+" "+deportistas.get(i).getNombre());
			        	}
			        	resp=input.nextInt();
			        	input.nextLine();
		        	}
	        	}while(resp<1||resp>deportistas.size());
	        	ModeloDeportista deportista=deportistas.get(resp-1);
	        	List<ModeloParticipacion> participaciones=DaoParticipacion.conseguirPorDeportista(deportista, db);
	        	ArrayList<ModeloEvento>eventos=new ArrayList<ModeloEvento>();
	        	for(ModeloParticipacion p:participaciones) {
	        		if(!eventos.contains(p)) {
	        			eventos.add(p.getEvento());
	        		}
	        	}
	        	do {
	        		System.out.println("Elige el evento");
	        		for(int i=0;i<eventos.size();i++) {
		        		System.out.println((i+1)+" "+eventos.get(i).getNombre());
		        	}
	        		resp=input.nextInt();
		        	input.nextLine();
	        	}while(resp<1||resp>eventos.size());
	        	ModeloEvento e=eventos.get(resp-1);
	        	do {
	        		System.out.println("Dime que medalla quieres poner");
	        		System.out.println("1 Gold\n2 Silver\n3 Bronze\n4 NA");
	        		resp=input.nextInt();
	        		input.nextLine();
	        	}while(resp<1||resp>4);
	        	String medalla="NA";
	        	switch (resp) {
				case 1:
					medalla="Gold";
					break;
				case 2:
					medalla="Silver";
					break;
				case 3:
					medalla="Bronze";
					break;
				}
	        	DaoParticipacion.actualizarMedallas(medalla, deportista, e, db);
	        	break;
	        case 3:
	        	break;
	        case 4:
	        	break;
        }
        db.close();
	}

	/**
	 * Listar.
	 *
	 * @param input the input
	 * @param db the db
	 */
	private static void Listar(Scanner input, ObjectContainer db) {
		int resp=0;
    	String temporada="Summer";
    	do {
    		System.out.println("Dime la temporada:\n1 Winter\n2 Summer");
    		resp=input.nextInt();
    		input.nextLine();
    	}while(resp!=1&&resp!=2);
    	if(resp==1) {
    		temporada="Winter";
    	}
    	List<ModeloOlimpiada> olimpiadas=DaoOlimpiada.conseguirPorTemporada(temporada, db);
    	do {
    		System.out.println("Elige la edición olímpica:");
        	for(int i=0;i<olimpiadas.size();i++) {
        		System.out.println((i+1)+" "+olimpiadas.get(i).getNombre());
        	}
        	resp=input.nextInt();
        	input.nextLine();
    	}while(resp<1||resp>olimpiadas.size());
    	ModeloOlimpiada olimpiada=olimpiadas.get(resp-1);
    	List<ModeloEvento> eventos=DaoEvento.conseguirPorOlimpiada(olimpiada, db);
    	if(eventos.size()==0) {
    		System.out.println("No hay deportes en esa olimpiada");
    	}else {
	    	ArrayList<ModeloDeporte> deportesDisponibles=new ArrayList<ModeloDeporte>();
	    	for(ModeloEvento e:eventos) {
	    		if(!deportesDisponibles.contains(e.getDeporte())) {
	    			deportesDisponibles.add(e.getDeporte());
	    		}
	    	}
	    	do {
	    		System.out.println("Elige el deporte");
	    		for(int i=0;i<deportesDisponibles.size();i++) {
	    			System.out.println((i+1)+" "+deportesDisponibles.get(i).getNombre());
	    		}
	    		resp=input.nextInt();
	    		input.nextLine();
	    	}while(resp<1||resp>deportesDisponibles.size());
	    	ModeloDeporte deporte=deportesDisponibles.get(resp-1);
	    	List<ModeloEvento>eventosConFiltro=
	    			DaoEvento.conseguirPorOlimpiadaDeporte(olimpiada, deporte, db);
	    	do {
	    		System.out.println("Elige el evento");
	    		for(int i=0;i<eventosConFiltro.size();i++) {
	    			System.out.println((i+1)+" "+eventosConFiltro.get(i).getNombre());
	    		}
	    		resp=input.nextInt();
	    		input.nextLine();
	    	}while(resp<1||resp>eventosConFiltro.size());
	    	ModeloEvento evento=eventosConFiltro.get(resp-1);
	    	List<ModeloParticipacion> participaciones=
	    			DaoParticipacion.conseguirPorEvento(evento, db);
	    	ArrayList<ModeloDeportista> deportistas=new ArrayList<ModeloDeportista>();
	    	for(ModeloParticipacion par:participaciones) {
	    		if(!deportistas.contains(par.getDeportista())) {
	    			deportistas.add(par.getDeportista());
	    		}
	    	}
	    	for(int i=0;i<deportistas.size();i++) {
	    		ModeloDeportista dep=deportistas.get(i);
	    		ModeloParticipacion par=
	    				DaoParticipacion.conseguirPorDeportistaEvento(dep, evento, db);
	    		System.out.println("Nombre: "+dep.getNombre()+", Altura: "+
	    				dep.getAltura()+", Peso: "+dep.getPeso()+", Edad: "+
	    				par.getEdad()+", Equipo: "+par.getEquipo().getNombre()+
	    				", Medalla: "+par.getMedalla());
	    	}
    	}
		
	}


}
