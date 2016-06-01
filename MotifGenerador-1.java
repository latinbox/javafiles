import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MotifGenerador {
	
	public static int l;
	public static int d;
	public static int n;
	public static int k;
	public static int ind;
	public static StringBuilder str = new StringBuilder();
	
	public static String seqImput;
	
	// create a random DNA of length "l"
	public static String motivGen(int l){
		str = new StringBuilder();
		for (int i = 0; i < l; i++) {
			String dic = "ATGC";
			int caso = (int)(Math.random()*4); 
			str.append(dic.charAt(caso));			
			}
		String motivo = str.toString();
		return motivo;
	}	
	
	// creates random sequences without the motif and the replace some letters with the motif
	public static String randomSet(int n,int l, String motivo){
				
		str = new StringBuilder();
		motivGen(n);
		ind = (int)(Math.random()*(n-l-1));
		str.replace(ind, ind+motivo.length(),motivo);
				
		String randomSeq = str.toString();
		return randomSeq;
	}
	
	//generate random "mismatches"
	public static String genRandomD(String randSeq,int len) {
		for (int i = 0; i < d; i++) { 
			StringBuilder rand = new StringBuilder(randSeq);
			int index = (int)(Math.random()*(len-1)); 
			rand.replace(index, index +1,motivGen(1)); 
			randSeq=rand.toString();
		}
		
		return randSeq;
			
	}

	//gets global variables values
	public static void getImputs(){
		Scanner scan = new Scanner (System.in);

		System.out.println("");
		System.out.println("How many sequences should be generated ? (k)");
		k = scan.nextInt();
		System.out.println("Sequence lenght? (n)");
		n = scan.nextInt();
		System.out.println("How many mismatches are allowed (d)");
		d = scan.nextInt();
		System.out.println("Type 1 to imput your motif or 2 to generate a random");
		int caso = scan.nextInt();
		
						
		switch (caso){
		case 1:
			System.out.println("Please write your motif");
			seqImput = scan.next();
			l = seqImput.length(); 
			break;
		case 2:
			System.out.println("lenght of motif ?");
			l = scan.nextInt();
			seqImput = motivGen(l);
			System.out.println("Your motif is: " + seqImput);
			break;
				
		}
		
	}
	
	public static void userFriendlyExtension(){
		Scanner scan = new Scanner (System.in);
		while(l>n){
			System.out.println("Sorry, but you chosed a motif length smaller than the sequence itself");
			System.out.println("please type again the sequence lenght?");
			n = scan.nextInt();
		}
		while (d>l){
			System.out.println("Sorry, but your motif has more mismatches than characters. "
					+ "I have no clue about how to solve that :(");
			System.out.println("please type again the number of allowed mismatches");
			d = scan.nextInt();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		
		getImputs();
		
		userFriendlyExtension();
			
		File file = new File("MotifSets.fasta");	
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("#Your motif is " + seqImput +"\n");
		bw.write("#Your parameters are:(k = "+k+ ",n = " + n +",l = " +l+",d = "+d+")\n");
		for (int i = 0; i < k; i++) {
			
			String sequence = genRandomD(seqImput,seqImput.length());
			String randon = randomSet( n, l, sequence);
			bw.write(">Your motif begins at the " + (ind+1) +"º character \n");
			bw.write(randon+"\n");
			System.out.println(ind+1 +"\t" + randon);
		}
		bw.close();
	}
}
