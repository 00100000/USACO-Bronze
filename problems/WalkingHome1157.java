import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WalkingHome1157 {
	private static int n, k;
	private static int paths;
	private static char[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			paths = 0;
			grid = new char[n][n];
			for (int j = 0; j < n; j++) {
				grid[j] = br.readLine().toCharArray();
			}

			moveTo(0, 0, 0, 0);
			pw.println(paths);
		}
		br.close();
		pw.close();
	}
	// recursively traverse the grid
	static void moveTo(int x, int y, int turns, int state) {
		// for state:
		// 0 = can go any direction
		// 1 = going right
		// 2 = going down

		// out of bounds/ran into haybale/too many turns
		if (x >= n || y >= n || grid[x][y] == 'H' || turns > k) {
			return;
		// reached end
		} else if (x == n - 1 && y == n - 1) {
			paths++;
			return;
		} else {
			moveTo(x + 1, y, turns + (state == 1 ? 1 : 0), 2);
			moveTo(x, y + 1, turns + (state == 2 ? 1 : 0), 1);
		}
	}
}