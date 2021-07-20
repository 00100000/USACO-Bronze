import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class art {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("art.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("art.out")));

		int n = Integer.parseInt(br.readLine());

		int[][] canvas = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				// convert each color to itself - 1
				canvas[i][j] = s.charAt(j) - 49;
			}
		}
		// solve
		boolean[] notFirst = new boolean[9];
		for (int i = 0; i < 9; i++) {
			boolean isVisible = false;
			int[] topLeft = {Integer.MAX_VALUE, Integer.MAX_VALUE};
			int[] bottomRight = {Integer.MIN_VALUE, Integer.MIN_VALUE};
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					// find the farthest possible corner locations of color i, even if they are covered
					if (canvas[j][k] == i) {
						isVisible = true;
						if (j < topLeft[0]) topLeft[0] = j;
						if (k < topLeft[1]) topLeft[1] = k;
						if (j > bottomRight[0]) bottomRight[0] = j;
						if (k > bottomRight[1]) bottomRight[1] = k;
					}
				}
			}
			if (isVisible) {
				// check if colors overlap color i. If they do, they must have not been painted first
				for (int j = topLeft[0]; j <= bottomRight[0]; j++) {
					for (int k = topLeft[1]; k <= bottomRight[1]; k++) {
						if (canvas[j][k] != i) notFirst[canvas[j][k]] = true;
					}
				}
			} else {
				notFirst[i] = true;
			}
		}
		int cnt = 0;
		for (int i = 0; i < 9; i++) {
			if (!notFirst[i]) cnt++;
		}

		pw.println(cnt);
		br.close();
		pw.close();
	}
}