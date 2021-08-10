import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class mixmilk {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

        int[][] a = new int[3][2];

        for (int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }

		int change = 0;
        for (int i = 0; i < 33; i++) {
			change = Math.min(a[0][1], a[1][0] - a[1][1]);
			a[0][1] -= change;
			a[1][1] += change;
			change = Math.min(a[1][1], a[2][0] - a[2][1]);
			a[1][1] -= change;
			a[2][1] += change;
		    change = Math.min(a[2][1], a[0][0] - a[0][1]);
			a[2][1] -= change;
			a[0][1] += change;
		}
		change = Math.min(a[0][1], a[1][0] - a[1][1]);
		a[0][1] -= change;
		a[1][1] += change;

        pw.println(a[0][1]);
		pw.println(a[1][1]);
        pw.println(a[2][1]);
		br.close();
		pw.close();
    }
}