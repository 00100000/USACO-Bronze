import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class revegetate {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] grass = new int[n];
		int[][] cows = new int[m][2];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= 4; j++) {
				boolean isValidSeed = true;
				for (int k = 0; k < m; k++) {
					// check if seed j has been used on the other pasture cow k grazes in
					if (cows[k][0] - 1 == i && grass[cows[k][1] - 1] == j) {
						isValidSeed = false;
					} else if (cows[k][1] - 1 == i && grass[cows[k][0] - 1] == j) {
						isValidSeed = false;
					}
				}
				if (isValidSeed) {
					grass[i] = j;
					pw.print(j);
					break;
				}
			}
		}

		br.close();
		pw.close();
	}
}
