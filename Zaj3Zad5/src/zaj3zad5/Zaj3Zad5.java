/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj3zad5;

/**
 *
 * @author W
 *
 * Zaimplementować funkcję  void sortuj(String s), która drukuje na standardowym
 * wyjściu posortowane (w kolejności rosnącej) wyrazy zapisane w ciągu znaków s.
 * Wielkość liter nie ma znaczenia, w związku z czym np. 'a'=='A'. Po
 * wyświetleniu wyrazów należy także wyświetlić średnią długość wszystkich
 * łańcuchów zapisanych w podanym ciągu znaków. Uwaga: Dla utrudnienia nie wolno
 * korzystać z funkcji standardowych toUpperCase() oraz to toLowerCase(). Dla
 * następujących wywołań funkcji: sortuj(”Aleksandra Joanna, Agnieszka”);
 * sortuj(”Ala ma kota i dwie agrafki”); na wyjściu powinien zostać wydrukowany
 * tekst: 'Agnieszka Aleksandra Joanna', 8,33 'agrafki Ala dwie i kota ma', 3,5
 */
public class Zaj3Zad5 {

    /**
     * @param args the command line arguments
     */
    static boolean porstring(String str1, String str2) {
        int ascii = 0;
        char znak1 = 0, znak2 = 0;
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) < 97) {//zmiana z dużej litery na małą
                ascii = str1.charAt(i) + 32;
                znak1 = (char) ascii;
            } else {
                znak1 = str1.charAt(i);
            }
            if (str2.charAt(i) < 97) {
                ascii = str2.charAt(i) + 32;
                znak2 = (char) ascii;

            } else {
                znak2 = str2.charAt(i);
            }
            if (znak1 > znak2) {
                return true;
            } else if (znak1 < znak2) {
                return false;
            }
        }
        if (str1.length() > str2.length()) {
            return true;
        }
        return false;
    }

    static void sortuj(String s) {
        double dl, il, srednia;
        String tmp = "";
        String[] tabsplit = s.split(" ");
        for (int i = 0; i < tabsplit.length; i++) {
            for (int j = 0; j < tabsplit.length - 1; j++) {
                if (porstring(tabsplit[j], tabsplit[j + 1])) {
                    tmp = tabsplit[j];
                    tabsplit[j] = tabsplit[j + 1];
                    tabsplit[j + 1] = tmp;
                }
            }

        }
        System.out.print("'");
        for (String x : tabsplit) {
            System.out.print(x + " ");
        }
        System.out.print("' ");
        dl = s.length() - (tabsplit.length - 1);//liczy też przecinek
        il = tabsplit.length;
        srednia = dl / il;
        System.out.println(srednia);

    }

    public static void main(String[] args) {
        sortuj("Aleksandra Joanna, Agnieszka");
        sortuj("Ala ma kota i dwie agrafki");

    }

}
