package stackOverflow.hangman;

public class WordGenerator {

    private String[] words = {
            "пальто", "одиночество", "лопата",
            "коромысло", "леопард"
    };

    public String generateWord() {
        return words[(int) (Math.random() * words.length)];
    }
}