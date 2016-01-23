import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Emil on 21/01/16.
 */
public class Implementation {
   static int n = 0, total_sum = 0, mst_sum = 0;
    int a = 0, b = 0, w = 0, min_edge = 100, prims_start = 0;

    public static void main(String[] args) throws IOException {
        ReadFile rFile = new ReadFile();

        List<Integer> treeParameters = new ArrayList<Integer>();
        // New Edge class instance
        Edge tempEdge;

        // Dealing with file reading
        Scanner scanner = new Scanner(new File("main.in"));
        n = scanner.nextInt();

//        Node verticles = new Node(499);

        // Walking through all integer values in text file
        while (scanner.hasNextInt()) {}
    }
}
