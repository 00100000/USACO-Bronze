import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class diamond {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int max = 0;

		int[] diamonds = new int[n];
		for (int i = 0; i < n; i++) {
			diamonds[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(diamonds);
		// find the highest sequence of diamonds
		for (int i = 0; i < n; i++) {
			// a single diamond means a sequence of displayed diamonds must
			// always contain at least one diamond
			int count = 1;
			for (int j = i + 1; j < n; j++) if (Math.abs(diamonds[i] - diamonds[j]) <= k) count++;
			if (count > max) max = count;
		}

		pw.print(max);
		br.close();
		pw.close();
	}
}
