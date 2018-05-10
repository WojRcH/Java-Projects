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
    static void sortuj(String s) {
        String[] tabsplit = s.split(" ");
        String[] tabwyjsc = new String[tabsplit.length];
        for (int i = 0; i < tabsplit.length-1; i++) {
            for (int j = 0; j < tabsplit[j].length(); j++) {
                if (tabsplit[i].charAt(j) > tabsplit[i+1].charAt(j)) {
                    String tmp = tabsplit[i];
                    tabsplit[i] = tabsplit[i+1];
                    tabsplit[i+1] = tmp;
                }
            }

        }
        System.out.println();

    }

    public static void main(String[] args) {
        sortuj("ala ma kota i dwie agrafki");
    }

}
