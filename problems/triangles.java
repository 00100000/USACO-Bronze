import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class triangles {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

		int n = Integer.parseInt(br.readLine());

		int[][] posts = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			posts[i][0] = Integer.parseInt(st.nextToken());
			posts[i][1] = Integer.parseInt(st.nextToken());
		}
		// try all post combinations
		int max = 0;
		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++) {
				for (int k = j + 1; k < n; k++) {
					int area = 0;
					int[] mid = new int[2];
					int x = 0, y = 0;
					// utter garbage code. I hate this problem with a passion.
					if (posts[i][0] == posts[j][0] && posts[i][1] == posts[k][1]) {
						mid = posts[i];
						x = posts[k][0];
						y = posts[j][1];
					} else if (posts[i][0] == posts[k][0] && posts[i][1] == posts[j][1]) {
						mid = posts[i];
						x = posts[j][0];
						y = posts[k][1];
					} else if (posts[j][0] == posts[i][0] && posts[j][1] == posts[k][1]) {
						mid = posts[j];
						x = posts[k][0];
						y = posts[i][1];
					} else if (posts[j][0] == posts[k][0] && posts[j][1] == posts[i][1]) {
						mid = posts[j];
						x = posts[i][0];
						y = posts[k][1];
					} else if (posts[k][0] == posts[i][0] && posts[k][1] == posts[j][1]) {
						mid = posts[k];
						x = posts[j][0];
						y = posts[i][1];
					} else if (posts[k][0] == posts[j][0] && posts[k][1] == posts[i][1]) {
						mid = posts[k];
						x = posts[i][0];
						y = posts[j][1];
					} else {
						continue;
					}
					area = Math.abs(mid[0] - x) * Math.abs(mid[1] - y);
					Math.max(max, area);
				}
			}
		}

		pw.print(max);
		br.close();
		pw.close();
	}
}