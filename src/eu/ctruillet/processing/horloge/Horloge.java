/*
 * Clément Truillet (clement@ctruillet.eu)
 * Copyright (c) 2020.
 *
 */
package eu.ctruillet.processing.horloge;

import processing.core.PApplet;
import processing.core.PFont;

import static eu.ctruillet.processing.horloge.MainClass.*;

/**
 * Horloge
 */
public class Horloge {
	//Attributs
	private final PFont font = processing.loadFont("ressources/AgencyFB-Reg-48.vlw");
	private int centerX = processing.width / 2;
	private int centerY = processing.height / 2;
	private int radius = 100;
	private boolean displayHourText = true;
	private boolean displayDateText = true;
	private boolean displayHour = true;
	private boolean displayMinute = true;
	private boolean displaySecond = true;

	//Constructeur

	/**
	 * Constructeur d'une Horloge
	 *
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Horloge(int x, int y, int radius) {
		this.centerX = x;
		this.centerY = y;
		this.radius = radius;
	}

	/**
	 * Constructeur d'une Horloge au centre de la fenetre
	 *
	 * @param radius
	 */
	public Horloge(int radius) {
		this.radius = radius;
	}

	/**
	 * Constructeur d'une Horloge avec un rayon de 100px
	 *
	 * @param x
	 * @param y
	 */
	public Horloge(int x, int y) {
		this.centerX = x;
		this.centerY = y;
	}

	/**
	 *
	 */
	public Horloge() {

	}


	//Méthodes

	/**
	 * Affichage de l'Horloge dans la fenetre processing
	 */
	public void draw() {
		processing.textFont(font, (float) (40 * this.radius / 100.0));
		float x = 0;
		float y = 0;

		processing.background(200);
		processing.strokeCap(processing.SQUARE);
		processing.ellipseMode(processing.CENTER);
		processing.translate(this.centerX, this.centerY);
		processing.textAlign(processing.CENTER);

		//Recuperation des valeurs
		float day = PApplet.day();
		float hour = PApplet.hour();
		float minute = PApplet.minute();
		float second = PApplet.second();


		//Affichage Textuel
		processing.fill((float) ((day / 31.0 * 255) % 128 + 128));

		if (this.displayHourText) {
			processing.text((hour < 10.0 ? "0" : "") + (int) hour + ":" + (minute < 10.0 ? "0" : "") + (int) minute, 0, (float) (-10 * this.radius / 100.0));
		}

		if (this.displayDateText) {
			processing.textSize((float) (30 * this.radius / 100.0));
			processing.text((day < 10.0 ? "0" : "") + (int) day + "/" + (month() < 10.0 ? "0" : "") + month() + "/" + year(), 0, (float) (+40 * this.radius / 100.0));
		}

		//Heures
		if (this.displayHour) {
			processing.noFill();
			processing.strokeWeight((float) (0.1 * this.radius));
			processing.stroke((float) ((day / 31.0) + 80));
			processing.arc(0, 0, (float) (2.2 * this.radius - 2), (float) (2.2 * this.radius - 2), -HALF_PI, (float) ((2 * PI * (60 * hour + minute) / (60.0 * 24.0)) - HALF_PI));
		}

		//Minutes
		if (this.displayMinute) {
			processing.noFill();
			processing.strokeWeight((float) (0.1 * this.radius));
			processing.stroke((float) ((day / 31.0 * 255) % 128 + 96));
			processing.arc(0, 0, 2 * this.radius, 2 * this.radius, -HALF_PI, (float) ((2 * PI * (60 * minute + second) / (60.0 * 60.0)) - HALF_PI));
		}

		//Secondes
		if (this.displaySecond) {
			processing.noStroke();
			processing.fill((float) ((day / 31.0 * 255) % 128 + 112));
			x = (float) (0.8 * this.radius * cos((float) (HALF_PI + 2 * PI * (processing.millis() % 60000) / 1000.0)));
			processing.ellipse(x, y, (float) (20 * this.radius / 100.0), (float) (20 * this.radius / 100.0));
		}

	}

	@Override
	/**
	 * Méthode toString
	 */
	public String toString() {
		return "Horloge{" +
				"font=" + font +
				", centerX=" + centerX +
				", centerY=" + centerY +
				'}';
	}

	/**
	 * @return
	 */
	public PFont getFont() {
		return font;
	}

	/**
	 * @return
	 */
	public int getCenterX() {
		return centerX;
	}

	/**
	 * @param centerX
	 */
	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	/**
	 * @return
	 */
	public int getCenterY() {
		return centerY;
	}

	/**
	 * @param centerY
	 */
	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

	/**
	 * @return
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * @param radius
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * @return
	 */
	public boolean isDisplayHourText() {
		return displayHourText;
	}

	/**
	 * @param displayHourText
	 */
	public void setDisplayHourText(boolean displayHourText) {
		this.displayHourText = displayHourText;
	}

	/**
	 * @return
	 */
	public boolean isDisplayDateText() {
		return displayDateText;
	}

	/**
	 * @param displayDateText
	 */
	public void setDisplayDateText(boolean displayDateText) {
		this.displayDateText = displayDateText;
	}

	/**
	 * @return
	 */
	public boolean isDisplayHour() {
		return displayHour;
	}

	/**
	 * @param displayHour
	 */
	public void setDisplayHour(boolean displayHour) {
		this.displayHour = displayHour;
	}

	/**
	 * @return
	 */
	public boolean isDisplayMinute() {
		return displayMinute;
	}

	/**
	 * @param displayMinute
	 */
	public void setDisplayMinute(boolean displayMinute) {
		this.displayMinute = displayMinute;
	}

	/**
	 * @return
	 */
	public boolean isDisplaySecond() {
		return displaySecond;
	}

	/**
	 * @param displaySecond
	 */
	public void setDisplaySecond(boolean displaySecond) {
		this.displaySecond = displaySecond;
	}
}
