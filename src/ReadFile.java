import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Emil on 21/01/16.
 */
public class ReadFile {
    public static void readFile() throws IOException {
        String strLine;
        // Opening text file
        FileInputStream fstream = new FileInputStream("main.in");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        System.out.print(br.readLine());
        // Reading file by line
//        while ((strLine = br.readLine()) != null) {
//            System.out.println(strLine);
//        }

        // Close the input stream
        br.close();
    }
}
