import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class notlast {
	static String[] cow = {"Annabelle", "Bessie", "Daisy", "Elsie", "Gertie", "Henrietta", "Maggie"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));

		int n = Integer.parseInt(br.readLine());

		int[] milk = new int[7];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			milk[indexOf(st.nextToken())] += Integer.parseInt(st.nextToken());
		}
		// find smallest amount of milk
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) min = Math.min(min, milk[i]);
		// 2nd smallest
		int secMin = Integer.MAX_VALUE;
		for (int i = 0; i < 7; i++) if (milk[i] > min) secMin = Math.min(secMin, milk[i]);
		// count how many cows have secMin amounts of milk production
		int cnt = 0;
		int index = -1;
		for (int i = 0; i < 7; i++) {
			if (milk[i] == secMin) {
				index = i;
				cnt++;
			}
		}

		if (cnt == 0 || cnt > 1) {
			pw.print("Tie");
		} else {
			pw.print(cow[index]);
		}
		br.close();
		pw.close();
	}
	static int indexOf(String s) {
		for (int i = 0; i < 7; i++) {
			if (s.equals(cow[i])) {
				return i;
			}
		}
		return -1;
	}
}
