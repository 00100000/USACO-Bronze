import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class cowsignal {
    public static void main (String[]args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("cowsignal.in"));
        StringTokenizer t = new StringTokenizer(r.readLine());
        PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        int m = Integer.parseInt(t.nextToken());
        int n = Integer.parseInt(t.nextToken());
        int k = Integer.parseInt(t.nextToken());

        String expandedLine = "";
        // loop through all lines
        for (int i = 0; i < m; i++) {
            String originalLine = r.readLine();
            // loop through all characters of a line
            for (int j = 0; j < n; j++) {
                // construct expanded line
                for (int l = 0; l < k; l++) {
                    expandedLine += originalLine.charAt(j);
                }
            }
            // print expanded line as many times as the signal is dialated
            for (int j = 0; j < k; j++) {
                w.println(expandedLine);
            }
            // reset expanded line
            expandedLine = "";
        }
        r.close();
        w.close();
    }
}