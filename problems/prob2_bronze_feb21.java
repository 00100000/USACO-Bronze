import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class prob2_bronze_feb21 {
	static boolean[][] pasture = new boolean[1001][1001];
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = Integer.parseInt(br.readLine());

		int comfortable = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
			// remove comfortable cows that cow i will make uncomfortable
			comfortable -= checkAround(x, y);

			pasture[x][y] = true;
			if (isComfortable(x, y)) comfortable++;
			comfortable += checkAround(x, y);
			pw.println(comfortable);
		}

		br.close();
		pw.close();
	}
	// returns how many cows around x y are comfortable
	static int checkAround(int x, int y) {
		int ret = 0;
		if (x > 0) if (isComfortable(x - 1, y)) ret++;
		if (x < 1000) if (isComfortable(x + 1, y)) ret++;
		if (y > 0) if (isComfortable(x, y - 1)) ret++;
		if (y < 1000) if (isComfortable(x, y + 1)) ret++;
		return ret;
	}
	// returns if a cow is comfortable or not
	static boolean isComfortable(int x, int y) {
		int neighbors = 0;
		if (x > 0) if (pasture[x - 1][y]) neighbors++;
		if (x < 1000)if (pasture[x + 1][y]) neighbors++;
		if (y > 0) if (pasture[x][y - 1]) neighbors++;
		if (y < 1000) if (pasture[x][y + 1]) neighbors++;
		if (!pasture[x][y] || neighbors != 3) return false;
		return true;
	}
}