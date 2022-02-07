import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class photo {
	public static  void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("photo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

		int n = Integer.parseInt(br.readLine());
		int[] sums = new int[n - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n - 1; i++) {
			sums[i] = Integer.parseInt(st.nextToken());
		}
		// solve
		for (int i = 1; i < n; i++) {
			boolean valid = true;
			boolean[] used = new boolean[n];
			// simulate if first number was i
			int next = i;
			for (int j = 0; j < n - 1; j++) {
				if (used[next - 1] || sums[j] - next < 1 || sums[j] - next > n) {
					valid = false;
					break;
				} else {
					used[next - 1] = true;
					next = sums[j] - next;
				}
			}
			// if it fits constraints, it must be the lowest lexicograhpically possible solution
			if (valid) {
				next = i;
				for (int j = 0; j < n - 1; j++) {
					pw.print(next + " ");
					next = sums[j] - next;
				}
				pw.print(next);
				break;
			}
		}

		br.close();
		pw.close();
	}
}