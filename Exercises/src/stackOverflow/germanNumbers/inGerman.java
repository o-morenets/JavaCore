package stackOverflow.germanNumbers;

public class inGerman {

    static void convert_to_words(char[] num) {
        int len = num.length;

        if (len == 0) {
            System.out.println("empty string");
            return;
        }
        if (len > 6) {
            System.out.println("unbekannt");
            return;
        }

        String[] single_digits = new String[]{"null", "eins",
                "zwein", "drei", "vier",
                "fünf", "sechs", "sieben",
                "acht", "neun"};

        String[] two_digits = new String[]{"", "zehn", "elf", "zwölf",
                "dreizehn", "vierzehn",
                "fünfzehn", "sechzehn", "siebzehn",
                "achtzehn", "neunzehn"};

        String[] tens_multiple = new String[]{"", "", "zwanzig", "dreißig", "vierzig",
                "fünfzig", "sechzig", "siebzig",
                "achtzig", "neunzig"};

        String[] tousands = new String[]{"hundert", "tausend", "tausend", "hunderttausend"};

        System.out.print(String.valueOf(num) + ":");
        if (len == 1) {
            System.out.println(single_digits[num[0] - '0']);
            return;
        }

        /* Iterate while num is not '\0' */
        int x = 0;
        while (x < num.length) {
            if (len >= 3) {
                if (num[x] - '0' != 0) {
                    System.out.print(single_digits[num[x] - '0'] + "");
                    System.out.print(tousands[len - 3] + "");
                    // here len can be 3 or 4
                }
                --len;
            } else {
                if (num[x] - '0' == 1) {
                    int sum = num[x + 1] - '0' + num[x] - '0';
                    System.out.println(two_digits[sum]);
                    return;
                } else if (num[x] - '0' == 2 &&
                        num[x + 1] - '0' == 0) {
                    System.out.println("zwanzig");
                    return;
                } else {
                    int i = (num[x] - '0');
                    if (i > 0)
                        System.out.print(tens_multiple[i] + "");
                    else
                        System.out.print("");
                    ++x;
                    if (num[x] - '0' != 0)
                        System.out.println(single_digits[num[x] - '0']);
                }

            }
            ++x;

        }
    }

    public static void main(String[] args) {
        char[] chars = {49, 49, 49};
        convert_to_words(chars);
    }
}