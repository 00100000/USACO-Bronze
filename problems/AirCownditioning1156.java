import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class AirCownditioning1156 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] diff = new int[n];
		for (int i = 0; i < n; i++) {
			diff[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st2.nextToken());
		}

		// differences in every block of stalls that can be adjusted together MUST always be accounted
		// for in separate blocks/individually, so the difference between every block / 2 so we don't
		// double count bother outer edges of the stalls is the solution
		int cmds = 0;
		cmds += Math.abs(0 - diff[0]);
		cmds += Math.abs(diff[n - 1] - 0);
		for (int i = 0; i < n - 1; i++) {
			cmds += Math.abs(diff[i] - diff[i + 1]);
		}
		cmds /= 2;

		pw.println(cmds);
		br.close();
		pw.close();
	}
}