import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

		int n = Integer.parseInt(br.readLine());
		int[] pos = new int[n];
		int[] cows = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			// swap positions to make cows go the opposite direction of a shuffle
			pos[Integer.parseInt(st.nextToken()) - 1] = i;
			cows[i] = Integer.parseInt(st2.nextToken());
		}
		// simulate backwards shuffle
		for (int i = 0; i < 3; i++) {
			int[] temp = new int[n];
			for (int j = 0; j < n; j++) {
				temp[pos[j]] = cows[j];
			}
			cows = temp;
		}
		for (int i = 0; i < n; i++) {
			pw.println(cows[i]);
		}

		br.close();
		pw.close();
	}
}
