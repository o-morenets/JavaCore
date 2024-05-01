package stackOverflow.reverseString;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] inputArr = {"Don't", "worry", ",", "be", "happy", "!"};
        String[] resultArr = new String[inputArr.length];
        Character[] chars = Stream.of(inputArr)
                .flatMapToInt(CharSequence::chars).mapToObj(i -> (char) i).toArray(Character[]::new);
        int pos = chars.length - 1;
        for (int j = 0; j < inputArr.length; j++) {
            resultArr[j] = "";
            for (int i = 0; i < inputArr[j].length(); i++) {
                resultArr[j] += chars[pos--];
            }
        }
        System.out.println(Arrays.toString(resultArr));
    }
}
