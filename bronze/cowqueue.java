import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class cowqueue {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cowqueue.out"));

		int n = Integer.parseInt(br.readLine());
		int[][] queue = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue[i][0] = Integer.parseInt(st.nextToken());
			queue[i][1] = Integer.parseInt(st.nextToken());
		}
		// bubble sort lol
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (queue[j + 1][0] < queue[j][0]) {
					int[] temp = queue[j];
					queue[j] = queue[j + 1];
					queue[j + 1] = temp;
				}
			}
		}

		int time = 0;
		for (int i = 0; i < n; i++) {
			time = Math.max(time, queue[i][0]) + queue[i][1];
		}

		pw.println(time);
		br.close();
		pw.close();
	}
}
