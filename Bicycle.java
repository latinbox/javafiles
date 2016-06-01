public class Bicycle {
	/**
	 * Die Klasse implementiert die Attribute und Methoden zur einfachen Steuerung 
	 * eines Fahrrad-Objekts und seiner Zustaende und Verhalten. Hier sind die 
	 * Attribute zur Definition des Zustands nicht weiter modifiziert, d.h. auf 
	 * die Klassen-Variablen kann von aussen zugegriffen werden (lesen, schreiben).
	 * Es werden vorgestellt: 
	 * - Komponenten von Klassen (Attribute, Konstruktoren, Methoden)
	 * - spezieller Konstruktor (mit parameterischer Initialisierung der Attribute)
	 * Autor: hn (Oct.2010) - modifiviert mvbutz (Nov. 2013)
	 */

	private double    cadence;  // Trittfrequenz
	private double speed;    // Geschwindigkeit
	private int    gear;     // Gang

	/**
	 *  Konstruktur that initializes all the attributes of a bicycle.
	 */
	public Bicycle(double cadence, double speed, int gear) {
		this.cadence = cadence;
		this.speed   = speed;
		this.gear    = gear;
	} // end constructor Bicycle

	/*############### -- Methoden -- ##############*/

	/**
	 * aendere Trittfrequenz
	 * @param newValue
	 */
	void changeCadence(double newValue) {
		cadence = newValue;
	} // end changeCadence

	void changeGear(int newValue) {         // aendere Gang
		gear = newValue;
	} // end changeGear

	void speedUp(double incrementValue) {   // erhoehe Geschwindigkeit
		speed = speed + incrementValue;
	} // end speedUp

	void slowDown(double decrementValue) {  // bremse Geschwindigkeit ab
		speed = speed - decrementValue;
	} // end slowDown

	void printState() {                     // zeige den aktuellen Zustand an
		System.out.println(" |Cadence: " + cadence + 
				" |Speed:   " + speed + 
				" |Gear:    " + gear);
	} // end printState
	
	public double getCadence() {
		return cadence;
	}
	public double getSpeed() {
		return speed;
	}
	public int getGear() {
		return gear;
	}
	
	/**
	 * Die main Methode erzeugt zwei Bicycle Objekte und fuehrt ihre Methoden aus, 
	 * Eine dritte Variable wird angelegt, die auf eines der Objekte verweist. 
	 * Es werden vorgestellt: 
	 * - Spezifikation von Klassen mit ihren Attributen und Methoden
	 * - (default) Kontruktoren fuer Klassen
	 * - Manipulation der Zustaende durch Aufruf der Methoden
	 * Autor: hn, Oct.2010; modified: mvbutz 11/2013
	 */
} // end class Bicycle