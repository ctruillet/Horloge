package eu.ctruillet.processing.horloge;

import processing.core.PApplet;

public class MainClass extends PApplet {
	//Attributs
	public static PApplet processing;

	public Horloge h;


	//Methodes
	/**
	 * Méthode main
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		PApplet.main("eu.ctruillet.processing.horloge.MainClass", args);
	}

	public void setup() {
		//Initialisation
		processing = this;
		h = new Horloge();

	}

	public void settings() {
		size(400, 400);
	}

	public void draw() {
		h.draw();
	}
}

