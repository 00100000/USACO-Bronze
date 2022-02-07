import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ClockwiseFence1109 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = Integer.parseInt(br.readLine());

		String[] fence = new String[n];
		for (int i = 0; i < n; i++) {
			fence[i] = br.readLine();
		}

		for (int i = 0; i < n; i++) {
			// check if totalDir > 0 or < 0
			int totalDir = 0;
			for (int j = 0; j < fence[i].length() - 1; j++) {
				totalDir += rOrL(fence[i].charAt(j), fence[i].charAt(j + 1));
			}
			pw.println(totalDir > 0 ? "CW" : "CCW");
		}

		br.close();
		pw.close();
	}
	// returns 1 if b is to the right of a, -1 if b is to the left of a, and 1 otherwise
	static int rOrL(char a, char b) {
		switch (a) {
			case 'N':
				switch (b) {
					case 'E':
						return 1;
					case 'W':
						return -1;
				}
				break;
			case 'S':
				switch (b) {
					case 'E':
						return -1;
					case 'W':
						return 1;
				}
				break;
			case 'E':
				switch (b) {
					case 'N':
						return -1;
					case 'S':
						return 1;
				}
				break;
			case 'W':
				switch (b) {
					case 'N':
						return 1;
					case 'S':
						return -1;
				}
				break;
		}
		return 0;
	}
}
