package es.aketzagonzalez.practicaUD5ADAT;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.db4o.ObjectContainer;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import es.aketzagonzalez.dao.daoDeporte;
import es.aketzagonzalez.dao.daoDeportista;
import es.aketzagonzalez.dao.daoOlimpiada;
import es.aketzagonzalez.db.DB;
import es.aketzagonzalez.model.modeloDeporte;
import es.aketzagonzalez.model.modeloDeportista;


public class Main {
	
	public static void cargarDatos(File ruta,ObjectContainer db) {
		try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
			 List<String[]> lineas = reader.readAll();
	         lineas.remove(0); // Remover cabecera
	         for (String[] linea : lineas) {
	        	modeloDeporte deporte=daoDeporte.conseguirPorNombre(linea[12],db);
	        	if(deporte==null) {
	        		deporte=new modeloDeporte(linea[12]);
	        	}
	        	modeloDeportista deportista=daoDeportista.conseguirPorNombre(linea[1], db);
	        	if(deportista==null) {
	        		deportista=new modeloDeportista(linea[1],linea[2].charAt(0), Float.parseFloat(linea[4]), Integer.parseInt(linea[3]));
	        	}
	         }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CsvException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ObjectContainer db=new DB().getConnection() ;
		Scanner input=new Scanner(System.in);
        System.out.println("1:\tListado de deportistas participantes:");
        System.out.println("2:\tModificar medalla deportista:");
        System.out.println("3:\tAñadir deportista/participación::");
        System.out.println("4:\tEliminar participación:");
        System.out.println("0:\tSALIR:");
        int respuesta=input.nextInt();
        input.nextLine();
        switch(respuesta) {
	        case 1:
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
	        	System.out.println(daoOlimpiada.conseguirPorTemporada(temporada, db));
	        	break;
	        case 2:
	        	break;
	        case 3:
	        	break;
	        case 4:
	        	break;
        }
	}

}
