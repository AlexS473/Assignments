/**
 * Name: Shereece A.A. Victor
 * ID: 40105094
 * COMP 249
 * Assignment #4
 * Due April 8th 2019
 * Question 1
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * SubDictionaryCreator Class
 *
 * Accepts a text file and compiles a list in alphabetical order of the words it contains.
 */

public class SubDictionaryCreator {

    public static void main(String[] args) {

        System.out.print("Starting Sub Dictionary Creator Software...\n");
        System.out.println("Let's begin. Please enter a file name: ");

        /*
            Accepting the file to be opened and testing to see if it can be opened.
         */
        String filename = new Scanner(System.in).nextLine();
        Scanner input = null;
        Boolean done = false;
        int chance = 0;

        //Gives the user 3 chances to enter a valid file name
        while (!done && chance<3) {

            try {
                input = new Scanner(new FileInputStream(filename));
                done = input.hasNext()? true:false;
                chance++;
            }
            catch (FileNotFoundException e) {
                System.out.println("We could not find " + filename + " .");
                System.out.println("Please input another filename: ");
                filename = new Scanner(System.in).nextLine();
            }
        }

        if (chance ==3) {
            System.out.println("Unable to access a valid file. Terminating system...\n ");
            System.exit(-1);
        }

        //Creates a new Dictionary with all the words in the file
        Dictionary d = new Dictionary(input);
        ArrayList <Node> dictionary = d.getDictionary();

        //Output time
        File output = new File ("SubDictionary.txt");
        PrintWriter outfile =null;

        try{
            outfile = new PrintWriter(output);
        }
        catch(FileNotFoundException e){
            System.out.println("File not found. Unable to write to file.");
            System.exit(-69);
        }

        outfile.write("This document produced a sub-dictionary, which includes " + d.getCount()+" entries.\n");

        for (int i  = 0; i<dictionary.size(); i++){
            outfile.write(dictionary.get(i)+"\n");

        }

        input.close();
        outfile.close();
    }
}


