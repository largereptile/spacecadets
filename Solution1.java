import org.jsoup.Jsoup; // scrape websites with jsoup for ez access to the title
import org.jsoup.nodes.Document;
import java.io.*;

public class Solution1 {

    public static void main(String[] args) {

        while(true) { // while loop so i can test a bunch without running it too many times

            Document document; // document document

            InputStreamReader r = new InputStreamReader(System.in); // yeah we readin
            BufferedReader br = new BufferedReader(r);

            try {

                System.out.println("Enter username");
                String name = br.readLine().toLowerCase();

                if(name.equals("quit")) { // so i can quit sometimes
                    System.exit(0);
                }

                String url = "https://www.ecs.soton.ac.uk/people/" + name;

                document = Jsoup.connect(url).get();
                String fullName = document.title().startsWith("People") ? "Person not found" : // newline so it isn't too w i d e
                        "Name: "+ document.title().split(" \\| ")[0]; // if person isn't there error if they are say the name

                System.out.println(fullName);


            } catch (Exception e) {

                System.out.println(e);
                System.out.println("Enter a valid name please");

            }


        }

    }

}
