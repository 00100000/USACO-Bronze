import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class shell {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shell.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

		int n = Integer.parseInt(br.readLine());

		int[] pebbles = {0, 1, 2};
		int[] picked = {0, 0, 0};
		// simulate
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1, b = Integer.parseInt(st.nextToken()) - 1, g = Integer.parseInt(st.nextToken()) - 1;
			int temp = pebbles[a];
			pebbles[a] = pebbles[b];
			pebbles[b] = temp;
			// track how many times each cup was picked
			picked[pebbles[g]]++;
		}
		// the most picked cup = highest possible score
		int max = 0;
		for (int i = 0; i < 3; i++) {
			if (picked[i] > max) max = picked[i];
		}
		pw.println(max);
		br.close();
		pw.close();
	}
}
