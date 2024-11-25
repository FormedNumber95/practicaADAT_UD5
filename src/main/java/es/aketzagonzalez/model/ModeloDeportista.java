package es.aketzagonzalez.model;

import java.util.Objects;

/**
 * The Class ModeloDeportista.
 */
public class ModeloDeportista {

	/** The nombre. */
	private String nombre;
	
	/** The sexo. */
	private char sexo;
	
	/** The peso. */
	private float peso;
	
	/** The altura. */
	private int altura; //centimetros
	
	/**
	 * Instantiates a new modelo deportista.
	 */
	public ModeloDeportista() {}
	
	/**
	 * Instantiates a new modelo deportista.
	 *
	 * @param nombre the nombre
	 * @param sexo the sexo
	 * @param peso the peso
	 * @param altura the altura
	 */
	public ModeloDeportista(String nombre, char sexo, float peso, int altura) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(altura, nombre, peso, sexo);
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
		ModeloDeportista other = (ModeloDeportista) obj;
		return altura == other.altura && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso) && sexo == other.sexo;
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
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param sexo the new sexo
	 */
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	/**
	 * Gets the peso.
	 *
	 * @return the peso
	 */
	public float getPeso() {
		return peso;
	}

	/**
	 * Sets the peso.
	 *
	 * @param peso the new peso
	 */
	public void setPeso(float peso) {
		this.peso = peso;
	}

	/**
	 * Gets the altura.
	 *
	 * @return the altura
	 */
	public int getAltura() {
		return altura;
	}

	/**
	 * Sets the altura.
	 *
	 * @param altura the new altura
	 */
	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
}
