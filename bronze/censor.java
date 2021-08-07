import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class censor {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("censor.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("censor.out")));

		String s = br.readLine();
		String t = br.readLine();
		// literally LCP lol
		while (s.contains(t)) s = s.replaceAll(t, "");

		pw.print(s);
		br.close();
		pw.close();
	}
}
