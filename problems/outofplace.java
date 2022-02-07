import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class outofplace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));

		int n = Integer.parseInt(br.readLine());
		int[] cows = new int[n], sorted = new int[n];

		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(br.readLine());
			sorted[i] = cows[i];
		}
		Arrays.sort(sorted);
		// check for disordered pairs
		int swaps = 0;
		for (int i = 0; i < n; i++) {
			if (cows[i] != sorted[i]) swaps++;
		}

		pw.print(Math.max(swaps - 1, 0));
		br.close();
		pw.close();
	}
}