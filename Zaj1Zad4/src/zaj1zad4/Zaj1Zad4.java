/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj1zad4;

import java.util.Scanner;
//4. Napisać program, który wczytuje dwie liczby naturalne oznaczające numer roku i wyświetlający łączną
//liczbę dni od 1 stycznia pierwszego podanego roku do 31 grudnia drugiego podanego roku. Należy
//uwzględnić lata przestępne. Rok jest przestępny jeżeli jest podzielny przez 4, ale nie jest podzielny przez
//100, lub jest podzielny przez 400. Lata przestępne mają 366 dni, natomiast pozostałe 365.
//Przykładowo jeżeli użytkownik poda 2000 i 2007, wynikiem powinno być 2922
//(bo 366 + 3 * 365 + 366 + 3 * 365).
//Inny przykład, jeżeli użytkownik poda 1945 i 1945, to wynikiem powinno być 365.

/**
 *
 * @author W
 */
public class Zaj1Zad4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner pob = new Scanner(System.in);
        int latasuma = 0, lata, lataprzestępne, rokspr;
        System.out.println("Podaj pierwszą datę(rok): ");
        int rok1 = pob.nextInt();
        System.out.println("Podaj drugą datę późniejszą(rok): ");
        int rok2 = pob.nextInt();

        if (rok1 <= rok2) {
            rokspr = rok1;
            do {
                if (rokspr % 4 == 0 && rokspr % 100 != 0 || rokspr % 400 == 0) {
                    latasuma += 366;
                } else {
                    latasuma += 365;
                }
                rokspr++;
            } while (rokspr - 1 != rok2);
            System.out.println("Ilość dni wynosi: " + latasuma);
        } else {
            System.out.println("Druga data musi być późniejsza lub taka sama!!!");
        }

    }

}
