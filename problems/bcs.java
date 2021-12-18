import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class bcs {
	static int n;
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcs.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcs.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[][] fig = new char[n][n];
		for (int i = 0; i < n; i++) {
			fig[i] = br.readLine().toCharArray();
		}
		char[][][] p = new char[k][n][n];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < n; j++) {
				p[i][j] = br.readLine().toCharArray();
			}
		}
		solve:
		for (int i = 0; i < k; i++) {
			for (int j = i + 1; j < k; j++) {
				char[][] a = trim(p[i]);
				char[][] b = trim(p[j]);
				// iterate through every possible starting point for each piece
				for (int ax = 0; ax < n; ax++) {
					for (int ay = 0; ay < n; ay++) {
						for (int bx = 0; bx < n; bx++) {
							for (int by = 0; by < n; by++) {
								char[][] temp = new char[n][n];
								for (int l = 0; l < n; l++) {
									for (int m = 0; m < n; m++) {
										temp[l][m] = fig[l][m];
									}
								}
								// awful awful try catch needed. I'll figure out how to do it
								// properly later, but this problem has taken me many weeks to do,
								// and I can't stand it any longer
								try {
									if (fits(temp, a, b, ax, ay, bx, by)) {
										pw.print((i + 1) + " " + (j + 1));
										break solve;
									}
								} catch (IndexOutOfBoundsException e) {}
							}
						}
					}
				}
			}
		}
		// System.out.println(fits(fig, trim(p[0]), trim(p[2]), 0, 2, 0, 0));
		br.close();
		pw.close();
	}
	// removes outside rows and columns of a char[][] with only '.'
	static char[][] trim(char[][] c) {
		int rowStart = 0, rowEnd = n;
		int colStart = 0, colEnd = n;
		rowStartLoop:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == '#') break rowStartLoop;
			}
			rowStart++;
		}
		rowEndLoop:
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == '#') break rowEndLoop;
			}
			rowEnd--;
		}
		colStartLoop:
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[j][i] == '#') break colStartLoop;
			}
			colStart++;
		}
		colEndLoop:
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 0; j < n; j++) {
				if (c[j][i] == '#') break colEndLoop;
			}
			colEnd--;
		}
		// copy over to new array
		char[][] newC = new char[rowEnd - rowStart][colEnd - colStart];
		for (int i = rowStart; i < rowEnd; i++) {
			for (int j = colStart; j < colEnd; j++) {
				newC[i - rowStart][j - colStart] = c[i][j];
			}
		}
		return newC;
	}
	// returns true if a and b fit on f when overlayed with their top right corners at (ax, ay) and
	// (bx, by) respectively
	static boolean fits(char[][] f, char[][] a, char[][] b, int ax, int ay, int bx, int by) {
	 	// overlay a and b on f
		for (int i = ax, j = 0; j < a.length; i++, j++) {
			for (int k = ay, l = 0; l < a[0].length; k++, l++) {
				if (a[j][l] == '#') {
					if (f[i][k] == '#') {
						f[i][k] = '.';
					} else {
						return false;
					}
				}
			}
		}
		for (int i = bx, j = 0; j < b.length; i++, j++) {
			for (int k = by, l = 0; l < b[0].length; k++, l++) {
				if (b[j][l] == '#') {
					if (f[i][k] == '#') {
						f[i][k] = '.';
					} else {
						return false;
					}
				}
			}
		}
		// check if f has no '#' pieces
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (f[i][j] == '#') return false;
			}
		}
		return true;
	}
}