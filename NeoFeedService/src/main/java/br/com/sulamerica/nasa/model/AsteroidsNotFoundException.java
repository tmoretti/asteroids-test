package br.com.sulamerica.nasa.model;

public class AsteroidsNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2207081340306306621L;

	public AsteroidsNotFoundException(String msg) {
		super(msg);
	}
}
