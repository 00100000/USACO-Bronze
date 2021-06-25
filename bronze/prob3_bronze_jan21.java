import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class prob3_bronze_jan21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		long ret = 1;

		int n = Integer.parseInt(st.nextToken());

		// construct cow and stall array
		int[] cows = new int[n];
		int[] stalls = new int[n];
		StringTokenizer cowsString = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			cows[i] = Integer.parseInt(cowsString.nextToken());
		}
		StringTokenizer barnHeightsString = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			stalls[i] = Integer.parseInt(barnHeightsString.nextToken());
		}

		Arrays.sort(cows);
		Arrays.sort(stalls);

		int temp = 0;
		for (int i = n - 1; i > -1; i--) {
			for (int j = i; j > -1; j--) {
				// find lowest stall
				if (cows[i] <= stalls[j]) temp++;
			}
			ret *= temp;
			// reset
			temp = 0;
		}

		pw.println(ret);
		br.close();
		pw.close();
	}
}