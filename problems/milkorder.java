// does not work for test cases 7 and 8 (empty output file)

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class milkorder {
	public static void main(String[]args) throws IOException {
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
		// all cows in the hierarchy that aren't already in a fixed position or 1
		ArrayList<Integer> nonKHierarchy = new ArrayList<Integer>(0);
		for (int i = 0; i < m; i++) {
			boolean orderContains = false;
			for (int j = 0; j < n; j++) {
				if (hierarchy[i] == order[j] || hierarchy[i] == 1) {
					orderContains = true;
					break;
				}
			}
			if (!orderContains) nonKHierarchy.add(hierarchy[i]);
		}

		for (int i = 0; i < n; i++) {
			// add cow 1 to each spot in the order
			if (order[i] == 0) {
				// copy order to tempOrder
				int[] tempOrder = new int[n];
				for (int j = 0; j < n; j++) {
					tempOrder[j] = order[j];
				}
				tempOrder[i] = 1;
				// add rest of important cows to order
				for (int j = 0, nonKPos = 0; j < n && nonKPos < nonKHierarchy.size(); j++) {
					if (tempOrder[j] == 0) {
						tempOrder[j] = nonKHierarchy.get(nonKPos);
						nonKPos++;
					}
				}
				// check if this is a valid ordering
				int cnt = 0;
				for (int j = 0, hierarchyPos = 0; j < n && hierarchyPos < m; j++) {
					if (tempOrder[j] == hierarchy[hierarchyPos]) {
						cnt++;
						hierarchyPos++;
					}
				}
				if (cnt == m) {
					pw.println(i + 1);
					break;
				}
			}
		}

		br.close();
		pw.close();
	}
}