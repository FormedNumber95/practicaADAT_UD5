package es.aketzagonzalez.model;

import java.util.Objects;

/**
 * The Class ModeloDeporte.
 */
public class ModeloDeporte {

	/** The nombre. */
	private String nombre;
	
	/**
	 * Instantiates a new modelo deporte.
	 */
	public ModeloDeporte() {}
	
	/**
	 * Instantiates a new modelo deporte.
	 *
	 * @param nombre the nombre
	 */
	public ModeloDeporte(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
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
		ModeloDeporte other = (ModeloDeporte) obj;
		return nombre == other.nombre;
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
	
}
