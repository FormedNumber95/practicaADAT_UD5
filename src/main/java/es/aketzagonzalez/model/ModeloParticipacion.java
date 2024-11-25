package es.aketzagonzalez.model;

import java.util.Objects;

/**
 * The Class ModeloParticipacion.
 */
public class ModeloParticipacion {

	/** The deportista. */
	private ModeloDeportista deportista;
	
	/** The evento. */
	private ModeloEvento evento;
	
	/** The equipo. */
	private ModeloEquipo equipo;
	
	/** The edad. */
	private int edad;
	
	/** The medalla. */
	private String medalla;

	/**
	 * Instantiates a new modelo participacion.
	 */
	public ModeloParticipacion() {}
	
	/**
	 * Instantiates a new modelo participacion.
	 *
	 * @param deportista the deportista
	 * @param evento the evento
	 * @param equipo the equipo
	 * @param edad the edad
	 * @param medalla the medalla
	 */
	public ModeloParticipacion(ModeloDeportista deportista, ModeloEvento evento, ModeloEquipo equipo, int edad,
			String medalla) {
		super();
		this.deportista = deportista;
		this.evento = evento;
		this.equipo = equipo;
		this.edad = edad;
		this.medalla = medalla;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(deportista, edad, equipo, evento, medalla);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModeloParticipacion other = (ModeloParticipacion) obj;
		return Objects.equals(deportista, other.deportista) && edad == other.edad
				&& Objects.equals(equipo, other.equipo) && Objects.equals(evento, other.evento)
				&& Objects.equals(medalla, other.medalla);
	}

	/**
	 * Gets the deportista.
	 *
	 * @return the deportista
	 */
	public ModeloDeportista getDeportista() {
		return deportista;
	}

	/**
	 * Sets the deportista.
	 *
	 * @param deportista the new deportista
	 */
	public void setDeportista(ModeloDeportista deportista) {
		this.deportista = deportista;
	}

	/**
	 * Gets the evento.
	 *
	 * @return the evento
	 */
	public ModeloEvento getEvento() {
		return evento;
	}

	/**
	 * Sets the evento.
	 *
	 * @param evento the new evento
	 */
	public void setEvento(ModeloEvento evento) {
		this.evento = evento;
	}

	/**
	 * Gets the equipo.
	 *
	 * @return the equipo
	 */
	public ModeloEquipo getEquipo() {
		return equipo;
	}

	/**
	 * Sets the equipo.
	 *
	 * @param equipo the new equipo
	 */
	public void setEquipo(ModeloEquipo equipo) {
		this.equipo = equipo;
	}

	/**
	 * Gets the edad.
	 *
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * Sets the edad.
	 *
	 * @param edad the new edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Gets the medalla.
	 *
	 * @return the medalla
	 */
	public String getMedalla() {
		return medalla;
	}

	/**
	 * Sets the medalla.
	 *
	 * @param medalla the new medalla
	 */
	public void setMedalla(String medalla) {
		this.medalla = medalla;
	}
	
}
