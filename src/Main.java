import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static ArrayList<AllowedMoves> Possible_Moves = new ArrayList<AllowedMoves>();
	static ArrayList<Boards> Boards_alpa_beta = new ArrayList<Boards>();
	
	
	static int totalwhite=0;
	static int totalblack=0;
	static int temp_total_white=0;
	static int temp_total_black=0;
	static char[][] temp_possible_board = new char[12][12];
	static char[][] temp_board = new char[12][12];
	static char[][] Board = new char[12][12];
	public static int h1_numberofpieces(int i,char[][] this_board) {
		int j=0;
		int k,l;
			if(i==0) {
				for(k=2;k<10;k++) {
					for(l=2;l<10;j++) {
						if(this_board[k][l]=='W')
							j++;
					}
				}
			}
			else {
				for(k=2;k<10;k++) {
					for(l=2;l<10;j++) {
						if(this_board[k][l]=='B')
							j++;
					}
				}
			}
			return j;
	}
	
 	public static void printBoard() {
		int i,j;
		for( i=0;i<12;i++) {
			for(j=0;j<12;j++) {
				System.out.print(Board[i][j] + " ");
			}
			System.out.println();
			
		}
		System.out.println();
	}
	public static void initiliazeBoard() {
		int i,j;
		for( i=0;i<11;i++) {
			for(j=0;j<11;j++) {
				Board[i][j]='0';
				temp_possible_board[i][j]='0';
						
			}
		
			
			
		}
		for(i=0;i<12;i++) {
			Board[i][0]='X';
			Board[0][i]='X';
			Board[11][i]='X';
			Board[i][11]='X';
			Board[i][10]='X';
			Board[10][i]='X';
			Board[1][i]='X';
			Board[i][1]='X';
		}
		
		
		/*Board[0][2]='1';
		Board[0][3]='2';
		Board[0][4]='3';
		Board[0][5]='4';
		Board[0][6]='5';
		Board[0][7]='6';
		Board[0][8]='7';
		Board[0][9]='8';
	
		Board[2][0]='1';
		Board[3][0]='2';
		Board[4][0]='3';
		Board[5][0]='4';
		Board[6][0]='5';
		Board[7][0]='6';
		Board[8][0]='7';
		Board[9][0]='8';*/
		
		
		Board[5][5]='W';
		Board[6][6]='W';
		Board[5][6]='B';
		Board[6][5]='B';
		
			
			
		
	}
	public static void next_Turn_White(int i,int j) {
		int c=1;
		int c1=1;
		int k;
		
		while(Board[i+c][j]!='0'&&Board[i+c][j]!='X') {
			if(Board[i+c][j]=='W') {
				for(k=0;k<c;k++) {
					Board[i+k][j]='W';
				}
				break;
			}
			
			c++;
		}
		c=-1;
		while(Board[i+c][j]!='0'&&Board[i+c][j]!='X') {
			if(Board[i+c][j]=='W') {
				for(k=0;k>c;k--) {
					Board[i+k][j]='W';
				}
				break;
			}
			
			c--;
		}
		c=1;
		while(Board[i][j+c]!='0'&&Board[i][j+c]!='X') {
			if(Board[i][j+c]=='W') {
				for(k=0;k<c;k++) {
					Board[i][j+k]='W';
				}
				break;
			}
			
			c++;
		}
		c=-1;
		while(Board[i][j+c]!='0'&&Board[i][j+c]!='X') {
			if(Board[i][j+c]=='W') {
				for(k=0;k>c;k--) {
					Board[i][j+k]='W';
				}
				break;
			}
			
			c--;
		}
		c=1;
		c1=1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//Sag asagi
			if(Board[i+c][j+c1]=='W') {
				for(k=0;k<c;k++) {
					Board[i+k][j+k]='W';
				}
				break;
			}
			
			c++;
			c1++;
		}
		c=1;
		c1=-1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//Sol asagi
			if(Board[i+c][j+c1]=='W') {
				for(k=0;k<c;k++) {
					Board[i+k][j-k]='W';
					//System.out.println("elma");
				}
				break;
			}
			
			c++;
			c1--;
		}
		
		c=-1;
		c1=-1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//sol yukari
			if(Board[i+c][j+c1]=='W') {
				for(k=0;k>c;k--) {
					Board[i+k][j+k]='T';
				}
				break;
			}
			
			c--;
			c1--;
		}
		c=-1;
		c1=1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//sag yukari
			if(Board[i+c][j+c1]=='W') {
				for(k=0;k<c1;k++) {
					Board[i-k][j+k]='W';
					//System.out.println("kalem");
				}
				break;
			}
			
			c--;
			c1++;
		}
	}
	public static void next_Turn_Black(int i,int j) {
		int c=1;
		int c1=1;
		int k;
		
		
			
		
		
		while(Board[i+c][j]!='0'&&Board[i+c][j]!='X') {//asagi
			if(Board[i+c][j]=='B') {
				for(k=0;k<c;k++) {
					Board[i+k][j]='B';
				}
				break;
			}
			
			c++;
		}
		c=1;
		c1=1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//Sag asagi
			if(Board[i+c][j+c1]=='B') {
				for(k=0;k<c;k++) {
					Board[i+k][j+k]='B';
				}
				break;
			}
			
			c++;
			c1++;
		}
		c=1;
		c1=-1;
		while(Board[i+c][j+c1]!='0') {//Sol asagi
			if(Board[i+c][j+c1]=='B') {
				for(k=0;k<c;k++) {
					Board[i+k][j-k]='B';
					//System.out.println("nuaaa");
				}
				break;
			}
			
			c++;
			c1--;
		}
		
		c=-1;
		c1=-1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//sol yukari
			if(Board[i+c][j+c1]=='B') {
				for(k=0;k>c;k--) {
					Board[i+k][j+k]='B';
				}
				break;
			}
			
			c--;
			c1--;
		}
		c=-1;
		c1=1;
		while(Board[i+c][j+c1]!='0'&&Board[i+c][j+c1]!='X') {//sag yukari
			if(Board[i+c][j+c1]=='B') {
				for(k=0;k<c1;k++) {
					Board[i-k][j+k]='B';
					//System.out.println("buuuua");
				}
				break;
			}
			
			c--;
			c1++;
		}
		c=1;
		while(Board[i+c][j]!='0'&&Board[i+c][j]!='X') {//yukari
			if(Board[i+c][j]=='B') {
				for(k=0;k>c;k--) {
					Board[i+k][j]='B';
				}
				break;
			}
			
			c--;
		}
		c=-1;
		while(Board[i+c][j]!='0'&&Board[i+c][j]!='X') {
			if(Board[i+c][j]=='B') {
				for(k=0;k>c;k--) {
					Board[i+k][j]='B';
				}
				break;
			}
			
			c--;
		}
		
		c=1;
		while(Board[i][j+c]!='0'&&Board[i][j+c]!='X') {
			if(Board[i][j+c]=='B') {
				for(k=0;k<c;k++) {
					Board[i][j+k]='B';
				}
				break;
			}
			
			c++;
		}
		c=-1;
		while(Board[i][j+c]!='0'&&Board[i][j+c]!='X') {
			if(Board[i][j+c]=='B') {
				for(k=0;k>c;k--) {
					Board[i][j+k]='B';
				}
				break;
			}
			
			c--;
		}
	}
	public static char[][] next_Temp_Turn_Black(int i,int j,char[][] k_board) {
		int c=1;
		int c1=1;
		int k;
		int l,m;
		for(l=0;l<12;l++) {
			for(m=0;m<12;m++)
				temp_board[l][m]=k_board[l][m];
		}
		
		while(temp_board[i+c][j]!='0'&&temp_board[i+c][j]!='X') {//asagi
			if(temp_board[i+c][j]=='B') {
				for(k=0;k<c;k++) {
					temp_board[i+k][j]='B';
				}
				break;
			}
			
			c++;
		}
		c=1;
		c1=1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//Sag asagi
			if(temp_board[i+c][j+c1]=='B') {
				for(k=0;k<c;k++) {
					temp_board[i+k][j+k]='B';
				}
				break;
			}
			
			c++;
			c1++;
		}
		c=1;
		c1=-1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//Sol asagi
			if(temp_board[i+c][j+c1]=='B') {
				for(k=0;k<c;k++) {
					temp_board[i+k][j-k]='B';
				}
				break;
			}
			
			c++;
			c1--;
		}
		
		c=-1;
		c1=-1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//sol yukari
			if(temp_board[i+c][j+c1]=='B') {
				for(k=0;k>c;k--) {
					temp_board[i+k][j+k]='B';
				}
				break;
			}
			
			c--;
			c1--;
		}
		c=-1;
		c1=1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//sag yukari
			if(temp_board[i+c][j+c1]=='B') {
				for(k=0;k<c;k++) {
					temp_board[i-k][j+k]='B';
				}
				break;
			}
			
			c--;
			c1++;
		}
		c=1;
		while(temp_board[i+c][j]!='0'&&temp_board[i+c][j]!='X') {//yukari
			if(temp_board[i+c][j]=='B') {
				for(k=0;k>c;k--) {
					temp_board[i+k][j]='B';
				}
				break;
			}
			
			c--;
		}
		c=-1;
		while(temp_board[i+c][j]!='0'&&temp_board[i+c][j]!='X') {
			if(temp_board[i+c][j]=='B') {
				for(k=0;k>c;k--) {
					temp_board[i+k][j]='B';
				}
				break;
			}
			
			c--;
		}
		
		c=1;
		while(temp_board[i][j+c]!='0'&&temp_board[i][j+c]!='X') {
			if(temp_board[i][j+c]=='B') {
				for(k=0;k<c;k++) {
					temp_board[i][j+k]='B';
				}
				break;
			}
			
			c++;
		}
		c=-1;
		while(temp_board[i][j+c]!='0'&&temp_board[i][j+c]!='X') {
			if(temp_board[i][j+c]=='B') {
				for(k=0;k>c;k--) {
					temp_board[i][j+k]='B';
				}
				break;
			}
			
			c--;
		}
		return temp_board;
		}
	
	public static char[][] next_Temp_Turn_White(int i,int j,char[][] k_board) {
		int c=1;
		int c1=1;
		int k;
		int l,m;
		for(l=0;l<12;l++) {
			for(m=0;m<12;m++)
				temp_board[l][m]=k_board[l][m];
		}
		
		
		while(temp_board[i+c][j]!='0'&&temp_board[i+c][j]!='X') {
			if(temp_board[i+c][j]=='W') {
				for(k=0;k<c;k++) {
					temp_board[i+k][j]='W';
				}
				break;
			}
			
			c++;
		}
		c=-1;
		while(temp_board[i+c][j]!='0'&&temp_board[i+c][j]!='X') {
			if(temp_board[i+c][j]=='W') {
				for(k=0;k>c;k--) {
					temp_board[i+k][j]='W';
				}
				break;
			}
			
			c--;
		}
		c=1;
		while(temp_board[i][j+c]!='0'&&temp_board[i][j+c]!='X') {
			if(temp_board[i][j+c]=='W') {
				for(k=0;k<c;k++) {
					temp_board[i][j+k]='W';
				}
				break;
			}
			
			c++;
		}
		c=-1;
		while(temp_board[i][j+c]!='0'&&temp_board[i][j+c]!='X') {
			if(temp_board[i][j+c]=='W') {
				for(k=0;k>c;k--) {
					temp_board[i][j+k]='W';
				}
				break;
			}
			
			c--;
		}
		c=1;
		c1=1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//Sag asagi
			if(temp_board[i+c][j+c1]=='W') {
				for(k=0;k<c;k++) {
					temp_board[i+k][j+k]='W';
				}
				break;
			}
			
			c++;
			c1++;
		}
		c=1;
		c1=-1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//Sol asagi
			if(temp_board[i+c][j+c1]=='W') {
				for(k=0;k<c;k++) {
					temp_board[i+k][j-k]='W';
					//System.out.println("elma");
				}
				break;
			}
			
			c++;
			c1--;
		}
		
		c=-1;
		c1=-1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//sol yukari
			if(temp_board[i+c][j+c1]=='W') {
				for(k=0;k>c;k--) {
					temp_board[i+k][j+k]='T';
				}
				break;
			}
			
			c--;
			c1--;
		}
		c=-1;
		c1=1;
		while(temp_board[i+c][j+c1]!='0'&&temp_board[i+c][j+c1]!='X') {//sag yukari
			if(temp_board[i+c][j+c1]=='W') {
				for(k=0;k<c1;k++) {
					temp_board[i-k][j+k]='W';
					//System.out.println("kalem");
				}
				break;
			}
			
			c--;
			c1++;
		}
		return temp_board;
	}
	public static void show_Allowed_Moves() {
		int i;
		int c=Possible_Moves.size()-1;
		System.out.println("Moves that can be made:");
		for(i=0;i<=c;i++) {
			System.out.println((Possible_Moves.get(i).x)+" "+(Possible_Moves.get(i).y));
		}
		
		
	}
	public static void Find_numbers(char [][] temp_possible_board) {
		temp_total_black=0;
		temp_total_white=0;
		int i,j;
		for(i=1;i<9;i++) {
			for(j=1;j<9;j++) {
				if(temp_possible_board[i][j]=='B')
					temp_total_black++;
				if(temp_possible_board[i][j]=='W')
					temp_total_white++;
			}
		}
		
		
			
	}
	public static int Allowed_Moves(int turn,char[][] array) {
		int i,j,k,l;
		int prew_total_black=0;
		int prew_total_white=0;
		Possible_Moves.clear();
		if(turn==1) {
			for(i=1;i<9;i++) {
				for(j=1;j<9;j++) {
					
					
					for(k=1;k<9;k++) {
						for(l=1;l<9;l++) {
							temp_possible_board[k][l]=array[k][l];
						}
					}
					Find_numbers(temp_possible_board);
					prew_total_black=temp_total_black;
					temp_board=next_Temp_Turn_Black(i,j,temp_possible_board);
					Find_numbers(temp_board);
					if(temp_total_black-2>=prew_total_black&&array[i][j]=='0') {
						AllowedMoves Temp = new AllowedMoves(i,j);
						Possible_Moves.add(Temp);
					}
					
				}
			}
		}
		if(turn==0) {
			for(i=1;i<9;i++) {
				for(j=1;j<9;j++) {
					
					
					for(k=1;k<9;k++) {
						for(l=1;l<9;l++) {
							temp_possible_board[k][l]=array[k][l];
						}
					}
					Find_numbers(temp_possible_board);
					prew_total_white=temp_total_white;
					temp_board=next_Temp_Turn_White(i,j,temp_possible_board);
					Find_numbers(temp_board);
					if(temp_total_white-2>=prew_total_white&&array[i][j]=='0') {
						AllowedMoves Temp = new AllowedMoves(i,j);
						Possible_Moves.add(Temp);
					}
					
				}
			}
		}
		return Possible_Moves.size();
		
		
	}
	public static void random_play() {
		int c=0;
		int a=1;
		initiliazeBoard();
		Random rand = new Random();
		while(c!=60) {
			if(a%2==1) {
				Allowed_Moves(1,Board);
				
				if(Possible_Moves.size()<=0)
					continue;
				int rand1=rand.nextInt(Possible_Moves.size());
				
				
				next_Turn_Black(Possible_Moves.get(rand1).x,Possible_Moves.get(rand1).y);
				System.out.println(c);
				printBoard();
				
			}
			else {
				
				Allowed_Moves(0,Board);
				if(Possible_Moves.size()<=0)
					continue;
				int rand1=rand.nextInt(Possible_Moves.size());
				
				next_Turn_White(Possible_Moves.get(rand1).x,Possible_Moves.get(rand1).y);
				System.out.println(c);
				printBoard();
				
			}
			c++;
			a++;
			
				
			
		}
	}
	
	public static void human_vs_human() {
		initiliazeBoard();
		printBoard();
		int i=0;
		int c,a;
		a=1;
		c=0;
		Scanner myObj = new Scanner(System.in);
			while(c!=60) {
				if(a%2==1) {
					Allowed_Moves(1,Board);
					System.out.println("Black's turn -> you can play this moves\n");
					show_Allowed_Moves();
					System.out.println("please enter the cordinate of x");
					int k= myObj.nextInt();
					System.out.println("please enter the cordinate of y");
					int l= myObj.nextInt();
					next_Turn_Black(k,l);
					System.out.println(c);
					printBoard();
					
					
				}
				else {
					Allowed_Moves(0,Board);
					System.out.println("White's turn -> you can play this moves\n");
					show_Allowed_Moves();
					System.out.println("please enter the cordinate of x");
					int k= myObj.nextInt();
					System.out.println("please enter the cordinate of y");
					int l= myObj.nextInt();
					next_Turn_White(k,l);
					System.out.println(c);
					printBoard();
					
					
				}
				c++;
				a++;
				
					
				
			}
		
	}
	
	
	public static void open_tree(int i,char[][] a_board) {
		int j;
		int c;
		Boards_alpa_beta.clear();
		
		Allowed_Moves(i,a_board);
		c=Possible_Moves.size();
		char temp_board[][]=new char[12][12];
		if(i==1) {
		for(j=0;j<c;j++) {
			temp_board=next_Temp_Turn_Black(Possible_Moves.get(j).x,Possible_Moves.get(j).y,a_board);
			Boards b = new Boards(i,temp_board);
			Boards_alpa_beta.add(b);
		}
		}
		else {
			for(j=0;j<c;j++) {
				temp_board=next_Temp_Turn_White(Possible_Moves.get(j).x,Possible_Moves.get(j).y,a_board);
				Boards b = new Boards(i,temp_board);
				Boards_alpa_beta.add(b);
			}
		}
		
		
	}
	
	public static AllowedMoves h1_minimax_differenceofpieces() {
		int i;
		int max=Boards_alpa_beta.get(0).score;
		if(Boards_alpa_beta.size()==0) {
			return null;
		}
		else {
			int check=0;
			for(i=0;i<Boards_alpa_beta.size();i++) {
				if(max<Boards_alpa_beta.get(i).score) {
					max=Boards_alpa_beta.get(i).score;
					check=i;
				}
			}
		return Possible_Moves.get(check);
		}
	}
	public static  AllowedMoves h2_maximum_possibility(int t) {
		int i;
		
		if(Boards_alpa_beta.size()==0)
			return null;
		else {
			int max=Allowed_Moves(t,Boards_alpa_beta.get(0).boards);
			int check=0;
			for(i=0;i<Boards_alpa_beta.size();i++) {
				if(max<Allowed_Moves(t,Boards_alpa_beta.get(i).boards)) {
					max=Allowed_Moves(t,Boards_alpa_beta.get(i).boards);
					check=i;
				}
			}
			return Possible_Moves.get(check);
		}
		
		
	}
	public static void human_vs_computer() {
		Scanner myObj = new Scanner(System.in);
		AllowedMoves nextMove = new AllowedMoves();
		initiliazeBoard();
		printBoard();
		int i,j;
		System.out.println("human is black computer is white it is human's turn");
		for(i=0;i<60;i++) {
			if(i%2==0) {
				Allowed_Moves(1,Board);
				show_Allowed_Moves();
				System.out.println("please enter the cordinate of x");
				int k= myObj.nextInt();
				System.out.println("please enter the cordinate of y");
				int l= myObj.nextInt();
				next_Turn_Black(k,l);
				
				printBoard();
				
			}
			else {
				Allowed_Moves(0,Board);
				show_Allowed_Moves();
				open_tree(0,Board);
				
				nextMove=h1_minimax_differenceofpieces();
				
				next_Turn_White(nextMove.x,nextMove.y);
				printBoard();
			}
		}
	}
	public static void computer_vs_computer() {
		Scanner myObj = new Scanner(System.in);
		AllowedMoves nextMove = new AllowedMoves();
		initiliazeBoard();
		printBoard();
		int i,j;
		System.out.println(" black computer is starting");
		for(i=0;i<60;i++) {
			if(i%2==0) {
				Allowed_Moves(1,Board);
				show_Allowed_Moves();
				open_tree(0,Board);
				
				nextMove=h1_minimax_differenceofpieces();
			
				next_Turn_Black(nextMove.x,nextMove.y);
				printBoard();
				
			}
			else {
				Allowed_Moves(0,Board);
				show_Allowed_Moves();
				open_tree(0,Board);
				
				nextMove=h1_minimax_differenceofpieces();
			
				next_Turn_Black(nextMove.x,nextMove.y);
				printBoard();
			}
		}
	}
	public static void main(String[] args) {
		System.out.print("press 1 for human vs human-2 for human vs computer 3 or above for computer vs computer");
		Scanner myObj = new Scanner(System.in);
		int i=myObj.nextInt();		
		if(i==1)
		human_vs_human();
		if(i==2)
		human_vs_computer();
		else
			computer_vs_computer();
		/*System.out.print("please press 1 for human vs human 2 for human vs computer");
		Scanner myObj = new Scanner(System.in);
		int i=myObj.nextInt();
		if(i==1) {
			
		}*/
		

		
		// TODO Auto-generated method stub

	}
	
}
