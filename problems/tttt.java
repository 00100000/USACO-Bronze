import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class tttt {
	private static String soloWins = "";
	private static ArrayList<String> duoWins = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

		char[][] board = new char[3][3];
		// create board as 2d array
		String temp;
		for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			temp = st.nextToken();
			for (int j = 0; j < 3; j++) {
				board[i][j] = temp.charAt(j);
			}
		}
		// check horizontal and vertical
		for (int i = 0; i < 3; i++) {
			checkRow(board[i][0], board[i][1], board[i][2]);
			checkRow(board[0][i], board[1][i], board[2][i]);
		}
		// diagonals
		checkRow(board[0][0], board[1][1], board[2][2]);
		checkRow(board[0][2], board[1][1], board[2][0]);

		pw.println(soloWins.length());
		pw.println(duoWins.size());
		pw.close();
		br.close();
	}
	// check rows for doubles and triples
	static void checkRow(char a, char b, char c) {
		if (a == b && a == c) {
			if (soloWins.contains("" + a)) return;
			soloWins += a;
		} else if (a == b) {
			if (duoWins.contains("" + a + c) || duoWins.contains("" + c + a)) return;
			duoWins.add("" + a + c);
		} else if (a == c) {
			if (duoWins.contains("" + a + b) || duoWins.contains("" + b + a)) return;
			duoWins.add("" + a + b);
		} else if (b == c) {
			if (duoWins.contains("" + b + a) || duoWins.contains("" + a + b)) return;
			duoWins.add("" + a + b);
		}
	}
}