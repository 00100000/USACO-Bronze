import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class cowqueue {
	static public class Cow {
		int a, b;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));

		int n = Integer.parseInt(br.readLine());
		Cow[] queue = new Cow[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			queue[i] = new Cow();
			queue[i].a = Integer.parseInt(st.nextToken());
			queue[i].b = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(queue, new Comparator<Cow>() {
			@Override
			public int compare(Cow c1, Cow c2) {
				return c1.a - c2.a;
			}
		});

		int time = 0;
		for (int i = 0; i < n; i++) {
			time = Math.max(time, queue[i].a) + queue[i].b;
		}

		pw.print(time);
		br.close();
		pw.close();
	}
}
