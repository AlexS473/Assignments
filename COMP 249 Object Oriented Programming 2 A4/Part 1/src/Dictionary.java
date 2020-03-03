/**
 * Name: Shereece A.A. Victor
 * ID: 40105094
 * COMP 249
 * Assignment #4
 * Due April 8th 2019
 * Question 1
 */
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Contains an Array List for each letter in the alphabet
 * Each of which contain words starting with the same letter listed in alphabetical order
 */

public class Dictionary {

    /**
     * A word passed in from the input file
     */
    String word;

    /**
     * An array list of Nodes containing array lists for each letter
     */
    ArrayList <Node> dictionary = new ArrayList<>(26);

    /**
     * A count of the total number of words entered
     */
    static int count =0;

    /**
     * Constructor
     *
     * Doubles as the dictionary builder using the input file
     * @param input The file entered by the user
     */
    public Dictionary (Scanner input) {

        char letter='A';
        for (int i = 0; i < 26; i++) {
            dictionary.add(new Node(letter));
            letter++;
        }

        while (input.hasNext()) {
            String[] tokens=null;
            word = input.next();

            if (!word.isEmpty()) {

                /*
                 * A very special case for the MC² word since the superscript character isn't recognised by this ide.
                 */
                if (word.equals("mc�,")) {
                    word = new String("MC²");
                    int index = Math.abs(word.charAt(0) - 'A');
                    dictionary.get(index).add(word);
                }

                else {
                    String delims = "[:.,?!'=;1234567890�’]+";
                    tokens = word.split(delims);

                    if (tokens.length != 0 && !(tokens[0].isEmpty())) {

                        word = tokens[0].toUpperCase();

                        if (word.equals("A") || word.equals("I") || word.length() > 1) {
                            int index = Math.abs(word.charAt(0) - 'A');
                            dictionary.get(index).add(word);
                        }
                    }
                }
            }
        } //end while

        for (int i = 0; i < 26; i++) {
            count = count + dictionary.get(i).count();
        }
    }

    /**
     * Accessor for the dictionary created
     * @return dictionary
     */
    public ArrayList<Node> getDictionary() {
        return dictionary;
    }

    /**
     * Accessor for count
     * @return count A count of the total number of words entered
     */
    public static int getCount() {

        return count;
    }
}
