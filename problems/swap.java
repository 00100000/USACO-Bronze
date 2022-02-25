// extremely disgusting and terrible solution

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class swap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int a_1 = Integer.parseInt(st.nextToken()) - 1;
		int a_2 = Integer.parseInt(st.nextToken()) - 1;
		st = new StringTokenizer(br.readLine());
		int b_1 = Integer.parseInt(st.nextToken()) - 1;
		int b_2 = Integer.parseInt(st.nextToken()) - 1;

		int[] seq = new int[n];
		for (int i = 0; i < n; i++) {
			seq[i] = i + 1;
		}
		// brute force the cycle length
		HashSet<String> cycle = new HashSet<String>();
		for (int i = 0; i < 100000; i++) {
			int temp = 0;
			String s = "";
			for (int j = a_1; j <= a_1 + (a_2 - a_1) / 2; j++) {
				temp = seq[j];
				seq[j] = seq[a_2 - (j - a_1)];
				seq[a_2 - (j - a_1)] = temp;
			}
			for (int j = b_1; j <= b_1 + (b_2 - b_1) / 2; j++) {
				temp = seq[j];
				seq[j] = seq[b_2 - (j - b_1)];
				seq[b_2 - (j - b_1)] = temp;
			}
			for (int j = 0; j < n; j++) {
				s += seq[j];
			}
			cycle.add(s);
		}

		for (int i = 0; i < n; i++) {
			seq[i] = i + 1;
		}
		k %= cycle.size();
		for (int i = 0; i < k; i++) {
			int temp = 0;
			for (int j = a_1; j <= a_1 + (a_2 - a_1) / 2; j++) {
				temp = seq[j];
				seq[j] = seq[a_2 - (j - a_1)];
				seq[a_2 - (j - a_1)] = temp;
			}
			for (int j = b_1; j <= b_1 + (b_2 - b_1) / 2; j++) {
				temp = seq[j];
				seq[j] = seq[b_2 - (j - b_1)];
				seq[b_2 - (j - b_1)] = temp;
			}
		}

		for (int i = 0; i < n; i++) pw.println(seq[i]);
		br.close();
		pw.close();
	}
}
