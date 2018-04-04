/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj1zad3;
//3. Napisać funkcję sprawdzającą podzielność podanej jako parametr liczby (całkowitej dodatniej long) przez
//3 metodą sumowania cyfr. Jeżeli po pierwszym zsumowaniu cyfr liczby wartość sumy jest większa niż 9,

import java.io.IOException;
import java.util.Scanner;

//sumowanie należy przeprowadzić powtórnie, itd. Gdy końcowa suma cyfr jest mniejsza od 10, to funkcja
//kończy obliczenia i zwraca true (suma jest cyfrą 0, 3, 6, 9) lub false (suma jest jedną z pozostałych cyfr).
//Przykład:
//liczba: 123454, kolejne sumy: 19-10-1, wynik: false
//liczba: 123453, kolejne sumy: 18-9, wynik: true
/**
 *
 * @author W
 */
public class Zaj1Zad3 {

    /**
     * @param wartosc
     * @return
     */
    public static boolean sprawdz_podz(long wartosc) {
        int suma;
        do {
            suma = 0;
            while (wartosc != 0) {//liczenie sumy dopóki przecinek nie przesunie się do końca
                suma += wartosc % 10;
                wartosc /= 10;
            }
            wartosc = suma;
        } while (suma >= 10);//dopóki suma jest większa lub równa 10

        if (suma == 0 || suma == 3 || suma == 6 || suma == 9) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        long pa;
        System.out.println("Podaj liczbę dodatnią do sprawdzenia podzielności: ");
        Scanner pob = new Scanner(System.in);
        pa = pob.nextLong();

        while (pa <= 0) {
            if (pa <= 0) {
                System.out.println("Liczba musi być dodatnia, różna od zera!");
                pa = pob.nextLong();
            } else {
                System.out.println("Coś poszło nie tak, spróbuj jeszcze raz!");
                pa = pob.nextLong();
            }
        }
        System.out.println(sprawdz_podz(pa));//wywolanie metody statycznej sprawdz_podz

    }

}
