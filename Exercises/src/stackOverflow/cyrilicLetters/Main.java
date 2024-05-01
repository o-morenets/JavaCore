package stackOverflow.cyrilicLetters;

public class Main {

    public static void main(String[] args) {
        String[] cyrLetters = {"й", "ц", "у", "к", "е", "н", "г", "ш", "щ", "з", "х", "ф", "ы", "в", "а", "п", "р", "о", "л", "д", "ж", "э", "я", "ч", "с", "м", "и", "т", "ь", "б", "ю", "ъ", "ё"};

        boolean isSpam = false;

        for(String x: cyrLetters){
            String lowermail = "кириллица@mail.com";
            if(lowermail.contains(x)){
                isSpam = true;
            }
        }
    }
}
