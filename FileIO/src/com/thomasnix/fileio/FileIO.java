package com.thomasnix.fileio;
import java.io.*;

public class FileIO {

    public static void main(String[] args) throws IOException{
        File inFile = new File("src/inFile.txt");

        try{

            // Write to file with FileWriter
            FileWriter inFw = new FileWriter(inFile);
            inFw.write("Roses are Red\n" +
                    "Violets are Blue\n" +
                    "Java is great\n" +
                    "and so are you");
            inFw.close();

            // Read code with FileReader and BufferedReader
            FileReader inFr = new FileReader(inFile);
            BufferedReader bR = new BufferedReader(inFr);
            String lineContent;
            while ((lineContent = bR.readLine()) != null){
                System.out.println(lineContent);
            }
        }catch(IOException e){
            System.out.println("IO Exception encountered:\n\t" + e.getMessage());
        }
    }
}
