package edu.bsu.cs222;

import java.io.IOException;
import java.net.URLConnection;
import java.util.Scanner;
public class ConsoleMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Errors errorChecker = new Errors();
        WikiURL urlConnector = new WikiURL();

        DataGetter dataGetter = new DataGetter();

        System.out.println("Enter a wiki page title: ");
        String userInput = scan.nextLine().toLowerCase();
        errorChecker.checkEmptyInput(userInput);

        URLConnection connection = urlConnector.wikiURLConnection(userInput);
        String jsonData = dataGetter.WikiDataGetter(connection);

        RevisionGetter revisionsPrinter = new RevisionGetter(jsonData);
        revisionsPrinter.createAndFormatArray();
        revisionsPrinter.checkRedirects();
        revisionsPrinter.printRevisions();

    }
}
