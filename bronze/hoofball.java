import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class hoofball {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("hoofball.out"));

		int n = Integer.parseInt(br.readLine());
		int[] cows = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		// [i][0] = gives to, [i][1] = recieves from
		// -1 = none, 0 = left, 1 = right, 2 = both directions
		int[][] fromTo = new int[n][2];
		// default recieves from none
		for (int i = 0; i < n; i++) {
			fromTo[i][1] = -1;
		}
		// special cases
		fromTo[0][0] = 1;
		fromTo[1][1] = 0;
		fromTo[n - 1][0] = 0;
		fromTo[n - 2][1] = 1;
		// calculate recieve/give
		for (int i = 1; i < n - 1; i++) {
			if (cows[i + 1] - cows[i] >= cows[i] - cows[i - 1]) {
				fromTo[i][0] = 0;
				fromTo[i - 1][1] = fromTo[i - 1][1] == -1 ? 1 : 2;
			} else {
				fromTo[i][0] = 1;
				fromTo[i + 1][1] = fromTo[i + 1][1] == -1 ? 0 : 2;
			}
		}
		// solve
		int balls = 0;
		for (int i = 0; i < n; i++) {
			if (fromTo[i][1] == -1) {
				balls++;
			// cows stuck in a loop
			} else if (i < n - 1 && fromTo[i][0] == 1 && fromTo[i + 1][0] == 0 && fromTo[i][1] == 1 && fromTo[i + 1][1] == 0) {
				balls++;
			}
		}

		pw.println(balls);
		br.close();
		pw.close();
	}
}