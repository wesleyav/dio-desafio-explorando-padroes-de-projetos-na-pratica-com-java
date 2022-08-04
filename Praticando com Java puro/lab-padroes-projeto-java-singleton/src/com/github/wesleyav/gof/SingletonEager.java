package com.github.wesleyav.gof;

/**
 * Singleton "apressado"
 * 
 * @author Wesley
 *
 */
public class SingletonEager {

	private static SingletonEager instancia = new SingletonEager();

	private SingletonEager() {
		super();
	}

	public static SingletonEager getInstancia() {
		return instancia;
	}

}
