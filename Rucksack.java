import java.util.Scanner;

public class Rucksack {
	private double maxVolume;
	private double maxWeight;
	private double currentWeight;
	private double usedVolume;
	private int counter;
	private Gegenstand[] list;
	private String name;
	private boolean empty;

	public Rucksack(double maxWeight, double volume, String name) {
		this.maxWeight = maxWeight;
		this.maxVolume = volume;
		this.list = new Gegenstand[100];
		this.name = name;
		this.empty= true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Wie soll der Rucksack heiﬂen?");
		String rucksackName = scanner.nextLine();
		System.out.println("maxWeight?");
		double maxWeight = scanner.nextDouble();
		System.out.println("Volume?");
		double volume = scanner.nextDouble();
		Rucksack rucksack = new Rucksack(maxWeight, volume, rucksackName);
		System.out.println(rucksack.toString());
		
		System.out.println("\nErzeuge Gegenst‰nde:\n");
		
		Gegenstand Banane = new Gegenstand("Banane",10,2);
		System.out.println(Banane.toString());
		Gegenstand Schuh = new Gegenstand("Schuh",20,5);
		System.out.println(Schuh.toString());
		Gegenstand Kugel = new Gegenstand("Kugel",71,10);
		System.out.println(Kugel.toString());
		
		
		System.out.println("banane in "+rucksackName+" stecken: ");
		rucksack.input(Banane);
		
		System.out.println(rucksack.toString());
		
		System.out.println("Schuh in "+rucksackName+" stecken: ");
		rucksack.input(Schuh);
		
		System.out.println(rucksack.toString());
		
		System.out.println("Kugel in "+rucksackName+" stecken: ");
		rucksack.input(Kugel);
		
		System.out.println(rucksack.toString());
		
		System.out.println("Banane und Schuh entnehmen.");
		rucksack.output("Banane");
		rucksack.output("Schuh");
		System.out.println(rucksack.toString());
		
		System.out.println("Schuh entnehmen:\n");
		rucksack.output("Schuh");
		
		
		scanner.close();
		
		
		
		
	}

	public String toString() {
		
		String inhalt = this.name + "-Inhalt:\n";
		if(this.empty){
			inhalt +="Nichts\n";
		}else{
		for (int i = 0; i < this.list.length; i++) {
			if(this.list[i]!=null)
			inhalt += (i+1) + ": " + this.list[i].toString()+"\n";
		}
		}
		return inhalt;
	}

	public void input(Gegenstand gegenstand) {
		if (this.currentWeight + gegenstand.getWeight() > this.maxWeight
				|| this.usedVolume + gegenstand.getVolume() > this.maxVolume
				|| counter >= 100) {
			System.out.println(this.name + " hat nicht genug Platz\n");
		} else {
			counter += 1;
			this.list[this.counter - 1] = gegenstand;
			this.empty = false;
			this.currentWeight+=gegenstand.getWeight();
			this.usedVolume+=gegenstand.getVolume();
		}

	}

	public void output(String name) {
		if (this.counter == 0) {
			System.out.print(this.name + " ist leer!\n");
		} else {
			for (int i = 0; i < this.list.length; i++) {
				if (name == this.list[i].getName()) {
					this.currentWeight-=list[i].getWeight();
					this.usedVolume-=list[i].getVolume();
					this.list[i] = this.list[counter - 1];
					this.list[counter - 1] = null;
					counter -= 1;
					System.out.println(this.name + " wurde " + name
							+ " entnommen.\n");
					break;
				}
			}
		}
		if(this.counter==0){
			this.empty=true;
		}
	}

	public void output(int index) {
		if (counter == 0) {
			System.out.print(this.name + " ist leer!\n");
		} else if (index > 100 || index < 0) {
			System.out.println("falscher IndexWert!");
		} else {
			this.currentWeight-=list[index].getWeight();
			this.usedVolume-=list[index].getVolume();
			this.list[index] = this.list[counter - 1];
			this.list[counter - 1] = null;
			counter -= 1;
		}
		if(this.counter==0){
			this.empty=true;
		}
	}

}
