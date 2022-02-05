import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

class Herdle1179 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int green = 0;
		char[][] ans = new char[3][3];
		char[][] guess = new char[3][3];
		for (int i = 0; i < 3; i++) {
			String s = br.readLine();
			for (int j = 0; j < 3; j++) {
				ans[i][j] = s.charAt(j);
			}
		}
		for (int i = 0; i < 3; i++) {
			String s = br.readLine();
			for (int j = 0; j < 3; j++) {
				guess[i][j] = s.charAt(j);
				if (ans[i][j] == guess[i][j]) green++;
			}
		}

		int yellow = 0;
		int[] ansChars = new int[26];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				ansChars[ans[i][j] - 65]++;
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (ansChars[guess[i][j] - 65] > 0) {
					ansChars[guess[i][j] - 65]--;
					yellow++;
				}
			}
		}
		yellow -= green;

		pw.println(green);
		pw.print(yellow);
		br.close();
		pw.close();
	}
}