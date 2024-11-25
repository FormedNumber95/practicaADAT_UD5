package es.aketzagonzalez.model;

import java.util.Objects;

/**
 * The Class ModeloEquipo.
 */
public class ModeloEquipo {

	/** The nombre. */
	private String nombre;
	
	/** The iniciales. */
	private String iniciales;
	
	/**
	 * Instantiates a new modelo equipo.
	 */
	public ModeloEquipo() {}
	
	/**
	 * Instantiates a new modelo equipo.
	 *
	 * @param nombre the nombre
	 * @param iniciales the iniciales
	 */
	public ModeloEquipo(String nombre, String iniciales) {
		this.nombre = nombre;
		this.iniciales = iniciales;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(iniciales, nombre);
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
		ModeloEquipo other = (ModeloEquipo) obj;
		return Objects.equals(iniciales, other.iniciales) && Objects.equals(nombre, other.nombre);
	}

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the iniciales.
	 *
	 * @return the iniciales
	 */
	public String getIniciales() {
		return iniciales;
	}

	/**
	 * Sets the iniciales.
	 *
	 * @param iniciales the new iniciales
	 */
	public void setIniciales(String iniciales) {
		this.iniciales = iniciales;
	}
	
}
