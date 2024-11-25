package es.aketzagonzalez.model;

import java.util.Objects;

public class modeloDeportista {

	private String nombre;
	private char sexo;
	private float peso;
	private int altura; //centimetros
	
	public modeloDeportista() {}
	
	public modeloDeportista(String nombre, char sexo, float peso, int altura) {
		super();
		this.nombre = nombre;
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, nombre, peso, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		modeloDeportista other = (modeloDeportista) obj;
		return altura == other.altura && Objects.equals(nombre, other.nombre)
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso) && sexo == other.sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
}
