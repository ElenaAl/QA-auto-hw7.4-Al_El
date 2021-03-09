package tf.qa.automation;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(final String[] args) {

        //выводим в консоль список доступных стран

        System.out.println(Arrays.toString(Country.values()));

        System.out.println("Введите назание страны на латинице статус которой Вы хотели бы проверить:");
        Scanner sc = new Scanner(System.in);
        String country = sc.next();
        sc.close();

        //выводим сообщение о том, закрыта страна или открыта

        try {
            Country country1 = Country.valueOf(country.toUpperCase());
            Country.status(country1);
            System.exit(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e + "\nВы ввели неверное название страны на латинице.");
            System.out.println("Проверим, может быть Вы ввели на русском?\n");
        } catch (NullPointerException i) {
            System.out.println(i + "\nТип или имя null");
        }
        try {
            // прежде чем проверить русскую версию, приводим ее к необходимому формату, чтобы сравнить
            String country1 = country.substring(1);
            String country2 = country.substring(0, 1);
            country1 = country1.toLowerCase();
            country2 = country2.toUpperCase();
            country1 = country2 + country1;


            Country.getByRuName(country1);
        } catch (NoSuchCountryException e) {
            System.out.println(e + "\n Страны " + "'" + country + "'" + " не существует");
        }
    }
}
