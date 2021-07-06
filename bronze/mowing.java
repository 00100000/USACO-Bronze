import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

class mowing {
	public static void main(String[]args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mowing.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("mowing.out"));

		int n = Integer.parseInt(br.readLine());

		pw.println(n);
		br.close();
		pw.close();
	}
}
