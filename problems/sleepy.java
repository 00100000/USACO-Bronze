import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sleepy {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int unordered = 0;
		int a = Integer.parseInt(st.nextToken()), b = 0;
		// find the unordered cow farthest back
		// no need to store all the n cows!
		for (int i = 1; i < n; i++) {
			b = Integer.parseInt(st.nextToken());
			if (a > b) unordered = i;
			a = b;
		}

		pw.print(unordered);
		br.close();
		pw.close();
	}
}