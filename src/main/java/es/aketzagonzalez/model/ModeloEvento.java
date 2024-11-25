package es.aketzagonzalez.model;

import java.util.Objects;

/**
 * The Class ModeloEvento.
 */
public class ModeloEvento {

	/** The nombre. */
	private String nombre;
	
	/** The olimpiada. */
	private ModeloOlimpiada olimpiada;
	
	/** The deporte. */
	private ModeloDeporte deporte;
	
	/**
	 * Instantiates a new modelo evento.
	 */
	public ModeloEvento() {}
	
	/**
	 * Instantiates a new modelo evento.
	 *
	 * @param nombre the nombre
	 * @param olimpiada the olimpiada
	 * @param deporte the deporte
	 */
	public ModeloEvento(String nombre, ModeloOlimpiada olimpiada, ModeloDeporte deporte) {
		this.nombre = nombre;
		this.olimpiada = olimpiada;
		this.deporte = deporte;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(deporte, nombre, olimpiada);
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
		ModeloEvento other = (ModeloEvento) obj;
		return Objects.equals(deporte, other.deporte) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(olimpiada, other.olimpiada);
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
	 * Gets the olimpiada.
	 *
	 * @return the olimpiada
	 */
	public ModeloOlimpiada getOlimpiada() {
		return olimpiada;
	}
	
	/**
	 * Sets the olimpiada.
	 *
	 * @param olimpiada the new olimpiada
	 */
	public void setOlimpiada(ModeloOlimpiada olimpiada) {
		this.olimpiada = olimpiada;
	}
	
	/**
	 * Gets the deporte.
	 *
	 * @return the deporte
	 */
	public ModeloDeporte getDeporte() {
		return deporte;
	}
	
	/**
	 * Sets the deporte.
	 *
	 * @param deporte the new deporte
	 */
	public void setDeporte(ModeloDeporte deporte) {
		this.deporte = deporte;
	}

}
