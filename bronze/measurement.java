import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class measurement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

		int n = Integer.parseInt(br.readLine());
		int[][] log = new int[n][3];
		int b = 7, e = 7, m = 7;
		int changes = 0;
		// store log in int[][]
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			log[i][0] = Integer.parseInt(st.nextToken());
			// Bessie = 0, Elsie = 1, Mildred = 2
			String cow = st.nextToken();
			if (cow.startsWith("B")) {
				log[i][1] = 0;
			} else if (cow.startsWith("E")) {
				log[i][1] = 1;
			} else {
				log[i][1] = 2;
			}
			log[i][2] = Integer.parseInt(st.nextToken());
		}
		// bubble sort the log because I'm too dumb to implement quicksort
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (log[j][0] > log[j + 1][0]) {
					int[] temp = log[j];
					log[j] = log[j + 1];
					log[j + 1] = temp;
				}
			}
		}
		// display is always Bessie Elsie Mildred at the start
		String display = "BEM";
		for (int i = 0; i < n; i++) {
			String newDisplay = "";
			// add changed milk value
			if (log[i][1] == 0) {
				b += log[i][2];
			} else if (log[i][1] == 1) {
				e += log[i][2];
			} else if (log[i][1] == 2) {
				m += log[i][2];
			}

			if (b >= e && b >= m) newDisplay += "B";
			if (m >= b && m >= e) newDisplay += "E";
			if (e >= b && e >= m) newDisplay += "M";

			if (!display.equals(newDisplay)) changes++;
			display = newDisplay;
		}

		pw.println(changes);
		br.close();
		pw.close();
	}
}