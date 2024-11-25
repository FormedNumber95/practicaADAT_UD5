package es.aketzagonzalez.model;

import java.util.Objects;

public class modeloEvento {

	private String nombre;
	private modeloOlimpiada olimpiada;
	private modeloDeporte deporte;
	
	public modeloEvento(int id_evento, String nombre, modeloOlimpiada olimpiada, modeloDeporte deporte) {
		super();
		this.nombre = nombre;
		this.olimpiada = olimpiada;
		this.deporte = deporte;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(deporte, nombre, olimpiada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		modeloEvento other = (modeloEvento) obj;
		return Objects.equals(deporte, other.deporte) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(olimpiada, other.olimpiada);
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public modeloOlimpiada getOlimpiada() {
		return olimpiada;
	}
	public void setOlimpiada(modeloOlimpiada olimpiada) {
		this.olimpiada = olimpiada;
	}
	
	public modeloDeporte getDeporte() {
		return deporte;
	}
	
	public void setDeporte(modeloDeporte deporte) {
		this.deporte = deporte;
	}

}
