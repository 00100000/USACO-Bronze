import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class prob2_bronze_jan21 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int evens = 0;
		int odds = 0;
		for (int i = 0; i < n; i++) {
			if (Integer.parseInt(st.nextToken()) % 2 == 0) {
				evens++;
			} else {
				odds++;
			}
		}

		if (evens >= odds) {
			System.out.println(odds * 2 + (evens > odds ? 1 : 0));
		} else {
			// dumb math stuff
			System.out.println(evens * 2
					+ (odds - evens) / 3 * 2
					+ (((odds - evens) % 3 == 2) ? 1 : 0)
					- (((odds - evens) % 3 == 1) ? 1 : 0));
		}

		br.close();
	}
}
