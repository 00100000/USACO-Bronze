import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class cbarn {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("cbarn.out"));

		int n = Integer.parseInt(br.readLine());
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			r[i] = Integer.parseInt(br.readLine());
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int distance = 0;
			int roomCnt = 1;
			// simulate unlocking each exterior room
			for (int j = i + 1; j < n; j++) {
				distance += r[j] * roomCnt;
				roomCnt++;
			}
			for (int j = 0; j < i; j++) {
				distance += r[j] * roomCnt;
				roomCnt++;
			}
			if (min > distance) min = distance;
		}

		pw.println(min);
		br.close();
		pw.close();
	}
}
