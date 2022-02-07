import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

		int n = Integer.parseInt(br.readLine());

		int[][] guards = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			guards[i][0] = Integer.parseInt(st.nextToken());
			guards[i][1] = Integer.parseInt(st.nextToken());
		}
		// bubble sort lol
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (guards[j + 1][0] < guards[j][0]) {
					int[] temp = guards[j + 1];
					guards[j + 1] = guards[j];
					guards[j] = temp;
				}
			}
		}
		// simulate removal of every guard
		int max = 0;
		int[] temp = new int[2];
		for (int i = 0; i < n; i++) {
			int time = 0;
			// replace i with i + 1 so the code will behave properly without any array copying
			// shenanigans. I actually feel slightly bigbrain for thinking of this lol.
			if (i != n - 1) {
				temp = guards[i];
				guards[i] = guards[i + 1];
			}
			// calculate time
			for (int j = 0; j < n - 1; j++) {
				if (i == j) continue;
				time += guards[j][1] - guards[j][0] -
				// compensate for overlap by removing the time of the earlier shift guard
				(guards[j][1] > guards[j + 1][0] ? guards[j][1] - guards[j + 1][0] : 0);
			}
			// add final element
			if (i != n - 1) time += guards[n - 1][1] - guards[n - 1][0];
			max = Math.max(max, time);
			// reset guard
			guards[i] = temp;
		}

		pw.print(max);
		br.close();
		pw.close();
	}
}