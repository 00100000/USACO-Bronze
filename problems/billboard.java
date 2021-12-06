import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class billboard {
	static class rect {
		int x1, y1, x2, y2;
		int area;
		public rect(String s) {
			StringTokenizer st = new StringTokenizer(s);
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			area = (x2 - x1) * (y2 - y1);
		}
		public int intersection(rect r) {
			int xIntersect = Math.max(0, Math.min(this.x2, r.x2) - Math.max(this.x1, r.x1));
			int yIntersect = Math.max(0, Math.min(this.y2, r.y2) - Math.max(this.y1, r.y1));
			return xIntersect * yIntersect;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

		rect b1 = new rect(br.readLine());
		rect b2 = new rect(br.readLine());
		rect t = new rect(br.readLine());

		pw.print(b1.area + b2.area - b1.intersection(t) - b2.intersection(t));
		br.close();
		pw.close();
	}
}
