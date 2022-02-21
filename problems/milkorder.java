import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class milkorder {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] order = new int[n];

		int[] hierarchy = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			hierarchy[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int cow = Integer.parseInt(st.nextToken()), position = Integer.parseInt(st.nextToken()) - 1;
			order[position] = cow;
		}
		// track if each cow in hierarchy is in order
		boolean[] inOrder = new boolean[m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (hierarchy[i] == order[j] || hierarchy[i] == 1) {
					inOrder[i] = true;
					break;
				}
			}
		}
		// try adding cow 1 as early as possible in order
		for (int i = 0; i < n; i++) {
			if (order[i] == 0) {
				int[] tempOrder = Arrays.copyOf(order, n);
				tempOrder[i] = 1;
				// add hierarchy as early as possible to tempOrder
				int l = 0;
				for (int j = 0; j < n && l < m; j++) {
					if (inOrder[l]) {
						if (tempOrder[j] == hierarchy[l]) l++;
					} else {
						if (tempOrder[j] == 0) {
							tempOrder[j] = hierarchy[l];
							l++;
						}
					}
				}
				// if this is a valid ordering, the entire hierarchy must have been traversed
				if (l == m) {
					pw.println(i + 1);
					break;
				}
			}
		}

		br.close();
		pw.close();
	}
}