package es.aketzagonzalez.model;

import java.util.Objects;

public class modeloDeporte {

	private String nombre;
	
	public modeloDeporte(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		modeloDeporte other = (modeloDeporte) obj;
		return nombre == other.nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
