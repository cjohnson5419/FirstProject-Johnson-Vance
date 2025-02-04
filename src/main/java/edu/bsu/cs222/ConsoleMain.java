package edu.bsu.cs222;
import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;
public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a wiki page title: ");
        String userInput = scan.nextLine();
        WikiURL urlConnector = new WikiURL();
        URLConnection connection = urlConnector.WikiURLConnection(userInput);
        String jsonData = new DataGetter().WikiDataGetter(connection);
        parser
        RevisionGetter().revisionParse(jsonData);

    }
}
