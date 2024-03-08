package tema8;

import java.util.Arrays;
import java.util.NoSuchElementException;

import tema8.cola.ColaDoble;
import tema8.cola.ColaEnteros;
import tema8.pila.PilaEnteros;

public class ListaNumeros implements ColaEnteros, PilaEnteros, ColaDoble {
	
	private int numeros[];

	public ListaNumeros() {
		this.numeros= new int [5];
	}
	
	
	//insertarPrincipio(int n)
	
	public void insertarPrincipio(int n) {
		this.numeros = Arrays.copyOf(this.numeros, this.numeros.length+1);
		System.arraycopy(this.numeros, 0, this.numeros, 1, this.numeros.length-1);
		this.numeros[0] = n;
		
	}
	//insertarFinal (int n)
	public void insertarFinal(int n) {
		this.numeros = Arrays.copyOf(this.numeros, this.numeros.length+1);
		this.numeros[this.numeros.length-1] = n;
	}
	
	//insertar(int posicion, int num)
	public void insertar (int i, int n) {
		if(i<0 || i > this.numeros.length-1) {
			throw new IllegalArgumentException("La posición indicada no se encuentra en el array");
		}
		//Ensanchamos un hueco
		this.numeros = Arrays.copyOf(this.numeros, this.numeros.length+1);
		//Desplazamos a partir de la posición i
		System.arraycopy(this.numeros, i, this.numeros, i+1, this.numeros.length-1-i);
		//insertamos N en la posición i
		this.numeros[i]= n;
		
	}
	
	//eliminar(int i)
	
	public void eliminar(int i) {
		if(i<0 || i > this.numeros.length-1) {
			throw new IllegalArgumentException("La posición indicada no se encuentra en el array");
		}
		System.arraycopy(this.numeros, i+1, this.numeros, i, this.numeros.length-(i+1));
		this.numeros = Arrays.copyOf(this.numeros, this.numeros.length-1);
	}
	
	//get(int i)
	public int get(int i) {
		if(i<0 || i > this.numeros.length-1) {
			throw new IllegalArgumentException("La posición indicada no se encuentra en el array");
		}
		return this.numeros[i];
		
	}
	
	
	//buscar(int clave)
	public int buscar(int clave) {
		int result = -1;
		
		for(int i=0; i<this.numeros.length && result == -1; i++) {
			if(this.numeros[i] == clave) {
				result = i;
			}
		}
		
		return result;
		
	}
	
	//elementos()

	public int elementos() {
		return this.numeros.length;
	
	}



	
	@Override
	public void encolar(int n) {
		this.insertarFinal(n);
		
	}


	@Override
	public int desencolar() {
		if(this.elementos()==0) {
			throw new NoSuchElementException("La cola no contiene elementos");
		}
		int elemento = this.get(0);
		this.eliminar(0);
		
		return elemento;
	}


	@Override
	public void apilar(int n) {
		this.insertarFinal(n);
		
	}


	@Override
	public int desapilar() {
		
		int elemento = this.get(this.elementos()-1);
		this.eliminar(this.elementos()-1);
		return elemento;
	}


	@Override
	public void encolarPrincipio(int n) {
		this.insertarPrincipio(n);
		
		
	}


	@Override
	public int desencolarFinal() {
		int elemento = this.get(this.elementos()-1);
		this.eliminar(this.elementos()-1);
		return elemento;
	}
	
	


}
