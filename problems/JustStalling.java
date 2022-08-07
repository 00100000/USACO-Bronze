import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JustStalling {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[] cows = new int[n];
		int[] stalls = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) cows[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) stalls[i] = Integer.parseInt(st.nextToken());
		// solve
		Arrays.sort(cows);
		Arrays.sort(stalls);

		long arrangements = 1;
		// find lowest stall j each cow i can fit into
		for (int i = n - 1; i > -1; i--) {
			int lowest = 0;
			for (int j = i; j > -1; j--) {
				if (cows[i] <= stalls[j]) lowest++;
			}
			arrangements *= lowest;
		}

		System.out.println(arrangements);
		br.close();
	}
}
