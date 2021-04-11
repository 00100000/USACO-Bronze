import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class gymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
        StringTokenizer t = new StringTokenizer(r.readLine());
        PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        ArrayList<int[]> pairs = new ArrayList<int[]>();

        int k = Integer.parseInt(t.nextToken());
        int n = Integer.parseInt(t.nextToken());
        // construct ArrayList
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i != j) {
                    int[] temp = {i, j};
                    pairs.add(temp);
                }
            }
        }

        int[] row = new int[n];
        for (int i = 0; i < k; i++) {
            // construct a row
            t = new StringTokenizer(r.readLine());
            for (int j = 0; j < n; j++) {
                row[j] = Integer.parseInt(t.nextToken());
            }
            // check all pairs
            for (int j = 0; j < pairs.size(); j++) {
                // remove pair if second cow in pair appears before first
                for (int l = 0; l < row.length; l++) {
                    if (row[l] == pairs.get(j)[0]) {
                        break;
                    }
                    if (row[l] == pairs.get(j)[1]) {
                        pairs.remove(j);
                        // decrease j so it doesn't skid a pair after removing
                        j--;
                        break;
                    }
                }
            }
        }

        w.println(pairs.size());
        r.close();
        w.close();
    }
}