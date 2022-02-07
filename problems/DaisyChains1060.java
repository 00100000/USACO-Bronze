import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DaisyChains1060 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] p = new int[n];
		int count = 0;
		// store all flower petal counts
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			p[i] = Integer.parseInt(st.nextToken());
		}
		// check all possible non-single flower combinations
		for (int i = 0; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				// create photo and calculate average
				double avg = 0;
				int[] photo = new int[j - i];
				for (int k = i, l = 0; k < j; k++, l++) {
					photo[l] = p[k];
					avg += p[k];
				}
				avg /= j - i;
				// check flowers for averages
				for (int k = 0; k < j - i; k++) {
					if (photo[k] == avg) {
						count++;
						break;
					}
				}
			}
		}

		System.out.println(count);
		br.close();
	}
}