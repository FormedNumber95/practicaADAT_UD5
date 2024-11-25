package es.aketzagonzalez.model;

import java.util.Objects;

/**
 * The Class ModeloOlimpiada.
 */
public class ModeloOlimpiada {

	/** The nombre. */
	private String nombre;
	
	/** The anio. */
	private int anio;
	
	/** The temporada. */
	private String temporada;
	
	/** The ciudad. */
	private String ciudad;
	
	/**
	 * Instantiates a new modelo olimpiada.
	 */
	public ModeloOlimpiada() {}
	
	/**
	 * Instantiates a new modelo olimpiada.
	 *
	 * @param nombre the nombre
	 * @param anio the anio
	 * @param temporada the temporada
	 * @param ciudad the ciudad
	 */
	public ModeloOlimpiada(String nombre, int anio, String temporada, String ciudad) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.temporada = temporada;
		this.ciudad = ciudad;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(anio, ciudad, nombre, temporada);
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
		ModeloOlimpiada other = (ModeloOlimpiada) obj;
		return anio == other.anio && Objects.equals(ciudad, other.ciudad) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(temporada, other.temporada);
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
	 * Gets the anio.
	 *
	 * @return the anio
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * Sets the anio.
	 *
	 * @param anio the new anio
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * Gets the temporada.
	 *
	 * @return the temporada
	 */
	public String getTemporada() {
		return temporada;
	}

	/**
	 * Sets the temporada.
	 *
	 * @param temporada the new temporada
	 */
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	/**
	 * Gets the ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Sets the ciudad.
	 *
	 * @param ciudad the new ciudad
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
}
