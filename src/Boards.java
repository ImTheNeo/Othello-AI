
public class Boards {
int maxpossibility;
int totalwhite;
int totalblack;
char[][] boards = new char[8][8];
int score;
int turn;
Boards(int i,char[][] b) {
	totalwhite=0;
	totalblack=0;
	turn = i ;
	boards=b;
	//calculate_white();
	//calculate_black();
	find_score();
}

void calculate_white() {
	int i,j;
	for(i=0;i<12;i++) {
		for(j=0;j<12;j++) {
			if(boards[i][j]=='W')
				totalwhite++;
		}
	}
	
	
}
void calculate_black() {
	int i,j;
	for(i=0;i<12;i++) {
		for(j=0;j<12;j++) {
			if(boards[i][j]=='B')
				totalblack++;
		}
	}
	
	
}
void find_score() {
	calculate_black();
	calculate_white();
	
	if(turn==0) {
		score=totalwhite-totalblack;
	}
	else
		score=totalblack-totalwhite;
}


}
