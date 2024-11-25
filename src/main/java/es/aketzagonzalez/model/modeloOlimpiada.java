package es.aketzagonzalez.model;

import java.util.Objects;

public class modeloOlimpiada {

	private String nombre;
	private int anio;
	private String temporada;
	private String ciudad;
	
	public modeloOlimpiada() {}
	
	public modeloOlimpiada(String nombre, int anio, String temporada, String ciudad) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.temporada = temporada;
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(anio, ciudad, nombre, temporada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		modeloOlimpiada other = (modeloOlimpiada) obj;
		return anio == other.anio && Objects.equals(ciudad, other.ciudad) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(temporada, other.temporada);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
}
