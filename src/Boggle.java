import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Boggle {

    public static String[] findWords(char[][] board, String[] dictionary) {

        ArrayList<String> goodWords = new ArrayList<String>();

        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.

        // Create a boolean array that holds the information of whether a spot has been searched
        // Sort all dictionary words into a Trie
        Boolean[][] searched = new Boolean[board.length][board[0].length];
        Stack<Character> trie = new Stack<>();
        for(int i = 0; i < dictionary.length; i++) {
            for(int j = 0; j < dictionary[i].length(); i++) {
                trie.push(dictionary[i].charAt(j));
            }
        }

        // Start the search from a designated spot [0,0] on the board
            // Move through each letter to look for word in the Trie
            // Once the spot has been searched:
                // Update the boolean array
            // If match is not found:
                // Go to different part of board (using DFS)
            // If word ends:
                // Make sure word is not already in goodWords ArrayList (checking for duplicates)
                // Add to goodWords

        // Need to make a new Object like in MazeSolver??


        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
}
