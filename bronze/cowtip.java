import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class cowtip {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cowtip.out"));

		int n = Integer.parseInt(br.readLine());
		boolean[][] cows = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				if (s.charAt(j) == '0') cows[i][j] = true;
			}
		}
		// simulate
		int flips = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (cows[i][j] == false) {
					flips++;
					for (int k = 0; k <= i; k++) {
						for (int l = 0; l <= j; l++) {
							cows[k][l] = !cows[k][l];
						}
					}
				}
			}
		}

		pw.println(flips);
		br.close();
		pw.close();
	}
}
