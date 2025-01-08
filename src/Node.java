public class Node {
    public static final int NUM_CHARS = 256;
    private boolean isWord = false;
    public Node[] next = new Node[NUM_CHARS];

    // Checks if the node has ended the word / contains the final letter of a word
    boolean isWord() {
        return isWord;
    }

    void setWord(boolean end) {
        isWord = end;
    }

    // Gets the next node to continue the word
    public Node[] getNext() {
        return next;
    }
}
