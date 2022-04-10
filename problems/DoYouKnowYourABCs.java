import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DoYouKnowYourABCs1059 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[7];
		for (int i = 0; i < 7; i++) num[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(num);

		for (int a = 0; a < 7; a++) {
			for (int b = a + 1; b < 7; b++) {
				for (int c = b + 1; c < 7; c++) {
					int ab = -1;
					int ac = -1;
					int bc = -1;
					int abc = -1;
					for (int i = 0; i < 7; i++) {
						if (i != a && i != b && i != c) {
							if (ab == -1 && num[i] == num[a] + num[b]) {
								ab = i;
							} else if (ac == -1 && num[i] == num[a] + num[c]) {
								ac = i;
							} else if (bc == -1 && num[i] == num[b] + num[c]) {
								bc = i;
							} else if (abc == -1 && num[i] == num[a] + num[b] + num[c]) {
								abc = i;
							} else {
								break;
							}
						}
					}
					if (ab > -1 && ac > -1 && bc > -1 && abc > -1) {
						pw.print(num[a] + " " + num[b] + " " + num[c]);
						br.close();
						pw.close();
						return;
					}
				}
			}
		}
	}
}