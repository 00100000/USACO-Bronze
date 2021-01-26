import java.util.*;
import java.io.*;

public class tttt {
    private static String soloWins = "";
    private static ArrayList<String> duoWins = new ArrayList<String>();
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

        char[][] board = new char[3][3];
        // create board as 2d array
        String temp;
        for (int i = 0; i < 3; i++) {
            // read line of input
            StringTokenizer t = new StringTokenizer(r.readLine());
            temp = t.nextToken();
            for (int j = 0; j < 3; j++) {
                // add to 2d array
                board[i][j] = temp.charAt(j);
            }
        }
        // horizontal and vertical
        for (int i = 0; i < 3; i++) {
            checkRow(board[i][0], board[i][1], board[i][2]);
            checkRow(board[0][i], board[1][i], board[2][i]);
        }
        // check diagonals
        checkRow(board[0][0], board[1][1], board[2][2]);
        checkRow(board[0][2], board[1][1], board[2][0]);
        // print solutions and close io
        w.println(soloWins.length());
        w.println(duoWins.size());
        w.close();
        r.close();
    }
    // check rows for doubles and triples
    static void checkRow(char a, char b, char c) {
        if (a == b && a == c) {
            if (soloWins.contains("" + a)) return;
            soloWins += a;
        } else if (a == b) {
            if (duoWins.contains("" + a + c) || duoWins.contains("" + c + a)) return;
            duoWins.add("" + a + c);
        } else if (a == c) {
            if (duoWins.contains("" + a + b) || duoWins.contains("" + b + a)) return;
            duoWins.add("" + a + b);
        } else if (b == c) {
            if (duoWins.contains("" + b + a) || duoWins.contains("" + a + b)) return;
            duoWins.add("" + a + b);
        }
    }
}