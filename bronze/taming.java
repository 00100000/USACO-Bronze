import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class taming {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));

		int n = Integer.parseInt(br.readLine());
		int[] log = new int[n];

		log[0] = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		st.nextToken();
		for (int i  = 1; i < n; i++) {
			log[i] = Integer.parseInt(st.nextToken());
		}
		// check for invalid
		int possibleNextMin = 0, possibleNextMax = 0, negCnt = 0;
		for (int i = 0; i < n - 1; i++) {
			if (log[i] == 0) {
				possibleNextMin = 0;
				possibleNextMax = 1;
				negCnt = 0;
			} else if (log[i] == -1) {
				possibleNextMax++;
				negCnt++;
			} else {
				if (log[i] < possibleNextMin && log[i] > negCnt || log[i] > possibleNextMax) {
					pw.println("-1");
					br.close();
					pw.close();
					return;
				} else {
					possibleNextMin = log[i] + 1;
					possibleNextMax = log[i] + 1;
				}
				negCnt = 0;
			}
		}
		// fix log
		// this is sort of a slower solution, but it easily bypasses a few annoying issues of other
		// solutions, and N <= 100, so there's a lot of wiggle room for inefficiency
		for (int i = 0; i < n; i++) {
			if (log[i] > 0) {
				for (int j = 1; j <= log[i]; j++) {
					log[i - j] = log[i] - j;
				}
			}
		}
		// solve
		int min = 0, max = 0;
		for (int i = 0; i < n; i++) {
			if (log[i] == 0) {
				min++;
			} else if (log[i] == -1) {
				max++;
			}
		}
		max += min;

		pw.println(min + " " + max);
		br.close();
		pw.close();
	}
}
