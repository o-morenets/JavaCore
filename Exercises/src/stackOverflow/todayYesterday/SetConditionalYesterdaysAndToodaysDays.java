package stackOverflow.todayYesterday;

import java.util.Scanner;

class SetConditionalYesterdaysAndToodaysDays {

    static String newConditionalYesterday;
    static String newConditionalTooday;
    static String[] brokenNewConditionalDays = new String[3];

    public static void main(String[] args) throws Exception {
        SetConditionalYesterdaysAndToodaysDays();
    }

    //Ввод условных дат
    static void SetConditionalYesterdaysAndToodaysDays() throws Exception {

        System.out.print("\n Введите новую условную вчерашнюю дату по типу:\"17.11.2018\":");
        Scanner newConditionalYesterdaysAndToodaysDaysObject = new Scanner(System.in);
        newConditionalYesterday = newConditionalYesterdaysAndToodaysDaysObject.next();

        System.out.print(" Введите новую условную вчерашнюю дату по типу:\"18.11.2018\":");
        newConditionalTooday = newConditionalYesterdaysAndToodaysDaysObject.next();

        checkTypeOfEnteredData();
        System.out.print(" Новая условная вчерашняя дата:".concat(newConditionalYesterday).concat("\n Новая условная сегодняшняя дата:").concat(newConditionalTooday));

    }

    //Проверка условной даты на соответствие выбранному типу
    static void checkTypeOfEnteredData() throws Exception {

        //Проверка наличия трёх сигментов даты, разделённых точками
        try {

            brokenNewConditionalDays = newConditionalYesterday.split("\\.");
            if(brokenNewConditionalDays.length != 3){
                SetConditionalYesterdaysAndToodaysDays();
            }

            brokenNewConditionalDays = newConditionalTooday.split("\\.");
            if(brokenNewConditionalDays.length != 3){
                SetConditionalYesterdaysAndToodaysDays();
            }

        }

        catch(Exception e){
            SetConditionalYesterdaysAndToodaysDays();
        }

    }

}