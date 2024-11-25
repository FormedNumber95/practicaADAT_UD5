package es.aketzagonzalez.model;

import java.util.Objects;

public class modeloParticipacion {

	private modeloDeportista deportista;
	private modeloEvento evento;
	private modeloEquipo equipo;
	private int edad;
	private String medalla;

	public modeloParticipacion(modeloDeportista deportista, modeloEvento evento, modeloEquipo equipo, int edad,
			String medalla) {
		super();
		this.deportista = deportista;
		this.evento = evento;
		this.equipo = equipo;
		this.edad = edad;
		this.medalla = medalla;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(deportista, edad, equipo, evento, medalla);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		modeloParticipacion other = (modeloParticipacion) obj;
		return Objects.equals(deportista, other.deportista) && edad == other.edad
				&& Objects.equals(equipo, other.equipo) && Objects.equals(evento, other.evento)
				&& Objects.equals(medalla, other.medalla);
	}

	public modeloDeportista getDeportista() {
		return deportista;
	}

	public void setDeportista(modeloDeportista deportista) {
		this.deportista = deportista;
	}

	public modeloEvento getEvento() {
		return evento;
	}

	public void setEvento(modeloEvento evento) {
		this.evento = evento;
	}

	public modeloEquipo getEquipo() {
		return equipo;
	}

	public void setEquipo(modeloEquipo equipo) {
		this.equipo = equipo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getMedalla() {
		return medalla;
	}

	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
}
