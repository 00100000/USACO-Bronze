import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

class speeding {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));

		int worstInfraction = 0;

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nArr = new int[100];
		int[] mArr = new int[100];
		// add all values of n by each mile
		int truePosN = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int segmentLength = Integer.parseInt(st.nextToken());
			int segmentSpeed = Integer.parseInt(st.nextToken());
			for (int j = 0; j < segmentLength; j++) {
				nArr[truePosN] = segmentSpeed;
				truePosN++;
			}
		}
		// add all values of m by each mile
		int truePosM = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int segmentLength = Integer.parseInt(st.nextToken());
			int segmentSpeed = Integer.parseInt(st.nextToken());
			for (int j = 0; j < segmentLength; j++) {
				mArr[truePosM] = segmentSpeed;
				truePosM++;
			}
		}
		// check all values in each array to find worst infraction
		for (int i = 0; i < 100; i++) {
			if (mArr[i] - nArr[i] > worstInfraction) {
				worstInfraction = mArr[i] - nArr[i];
			}
		}
		pw.println(worstInfraction);
		pw.close();
		br.close();
	}
}