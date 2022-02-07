import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class censor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("censor.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

		String s = br.readLine();
		String t = br.readLine();

		char[] res = new char[s.length()];
		Arrays.fill(res, ' ');
		for (int i = 0, resI = 0; i < s.length(); i++, resI++) {
			res[resI] = s.charAt(i);
			// check last characters of res to see if they are equal to t
			int similar = 0;
			if (resI >= t.length()) for (int j = resI - t.length() + 1, k = 0; j <= resI; j++, k++) {
				if (res[j] == t.charAt(k)) {
					similar++;
				} else {
					break;
				}
			}
			// if they are, remove the end of t characters of res
			if (similar == t.length()) {
				for (int j = resI - t.length() + 1; j <= resI; j++) {
					res[j] = ' ';
				}
				resI -= t.length();
			}
		}
		for (int i = 0; i < s.length(); i++) {
			if (res[i] == ' ') break;
			pw.print(res[i]);
		}
		br.close();
		pw.close();
	}
}
