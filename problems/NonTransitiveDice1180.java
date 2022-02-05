import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class NonTransitiveDice1180 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] a = new int[4];
			int[] b = new int[4];
			for (int j = 0; j < 4; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < 4; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			// make a beat b
			int aWins = 0, bWins = 0;
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (a[j] > b[k]) {
						aWins++;
					} else if (a[j] < b[k]){
						bWins++;
					}
				}
			}
			if (bWins > aWins) {
				int[] temp = Arrays.copyOf(a, 4);
				a = Arrays.copyOf(b, 4);
				b = temp;
			}
			// brute force
			boolean transitive = false;
			bruteForce:
			for (int j = 1; j < 11; j++) {
				for (int k = 1; k < 11; k++) {
					for (int l = 1; l < 11; l++) {
						for (int m = 1; m < 11; m++) {
							int aW = 0, bW = 0, cWa = 0, cWb = 0;
							// a wins
							for (int o = 0; o < 4; o++) {
								if (j > a[o]) {
									cWa++;
								} else if (j < a[o]) {
									aW++;
								}
							}
							for (int o = 0; o < 4; o++) {
								if (k > a[o]) {
									cWa++;
								} else if (k < a[o]) {
									aW++;
								}
							}
							for (int o = 0; o < 4; o++) {
								if (l > a[o]) {
									cWa++;
								} else if (l < a[o]) {
									aW++;
								}
							}
							for (int o = 0; o < 4; o++) {
								if (m > a[o]) {
									cWa++;
								} else if (m < a[o]) {
									aW++;
								}
							}
							// b wins
							for (int o = 0; o < 4; o++) {
								if (j > b[o]) {
									cWb++;
								} else if (j < b[o]) {
									bW++;
								}
							}
							for (int o = 0; o < 4; o++) {
								if (k > b[o]) {
									cWb++;
								} else if (k < b[o]) {
									bW++;
								}
							}
							for (int o = 0; o < 4; o++) {
								if (l > b[o]) {
									cWb++;
								} else if (l < b[o]) {
									bW++;
								}
							}
							for (int o = 0; o < 4; o++) {
								if (m > b[o]) {
									cWb++;
								} else if (m < b[o]) {
									bW++;
								}
							}
							if (cWa > aW && cWb < bW) {
								transitive = true;
								break bruteForce;
							}
						}
					}
				}
			}
			if (transitive) {
				pw.println("yes");
			} else {
				pw.println("no");
			}
		}

		br.close();
		pw.close();
	}
}