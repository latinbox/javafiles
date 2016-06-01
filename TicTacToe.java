import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[][] arr = new String[3][3];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] ="-";
			}

		}
		int playerturn = 1;
		int winner = 0;
		while (winner < 1){
			System.out.println("Aktuelles Spielfeld:");
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.print('\n');
			}
			int i;
			int j;
			if (playerturn == 1) {
				System.out.println("linha:");
				i = scan.nextInt();
				System.out.println("coluna");
				j = scan.nextInt();
				arr[i][j] ="X";

			} else{
				i = (int)(Math.random()*3);
				j = (int)(Math.random()*3);
				System.out.print(i);
				while (arr[i][j] == "X") {
					i = (int)(Math.random()*3);
					j = (int)(Math.random()*3);
				}
				arr[i][j] = "O";

				System.out.println("pc jogou");
			}
			if ((arr[i][0]==arr[i][1]&& arr[i][0]==arr[i][2])|| (arr[0][j]==arr[1][j] && arr[0][j]==arr[2][j])) {
				winner +=1;
				if (playerturn ==1){
					System.out.println("you win!");
				}else{System.out.println("you loose");
				}

			}
			int velha = 0;
			for (int k = 0; k < arr.length; k++) {
				for (int l = 0; l < arr.length; l++) {
					if(arr[k][l] == "-"){
						velha+=1;
					}

				}
			}
			if (velha == 0){
				System.out.println("Deu velha");
				winner+=1;
			}
			
			playerturn *= -1;

		}

		scan.close();
	}

}

