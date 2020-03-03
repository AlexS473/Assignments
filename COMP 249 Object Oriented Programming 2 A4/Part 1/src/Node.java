/**
 * Name: Shereece A.A. Victor
 * ID: 40105094
 * COMP 249
 * Assignment #4
 * Due April 8th 2019
 * Question 1
 */

import java.util.ArrayList;

/**
 * Node Class
 *
 * Contains an Array list for each letter of the alphabet
 */
public class Node {
    /**
     * Identifies which letter the words of the list start with
     */
    char letter;

    /**
     * Contains words starting with the letter above
     */
    ArrayList <String> words = new ArrayList<>();

    /**
     * A count of the number of words in this list
     */
    static int count =0;

    /**
     * Constructor
     *
     * Creates a node for the letter entered
     * @param letter identifies which letter the words of the list start with
     */
    public Node(char letter){
        this.letter = letter;
    }

    /**
     * Adds words to each array list in ascending alphabetical order
     * @param s The word to be added
     */
    public void add (String s) {
        int v = 0;

        if (words.size() == 0){ //automatically adds word if list is empty
            words.add(s);
            count++;
        }
        else {
            /*
                Searches to find whether or not the word comes before any in the list alphabetically
             */
            while (v < words.size() && words.get(v).compareTo(s) < 0) {
                v++;
            }


                if (v == words.size()) {//Adds to the end of the list if it belongs to the end
                    words.add(s);
                    count++;
                }
                else {
                    if (words.get(v).compareTo(s)==0){ //Ensures that no previously added word is re-added.
                        return;
                    }
                    words.add(v, s);
                    count++;
                }

        }


    }

    /**
     * Accessor for the count value
     * @return count, the number of words in this list
     */
    public int count() {
        return words.size();
    }

    /**
     * Prints all the words in this array list
     * @return output, The words in this list
     */
    @Override
    public String toString(){
        String output = letter + "\n====\n";
        for (int i = 0; i<words.size(); i++){
            output = output + words.get(i)+"\n";
        }
        return output;
    }
}
