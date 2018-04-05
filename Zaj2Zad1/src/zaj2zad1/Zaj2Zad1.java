/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj2zad1;

import java.util.Random;

/**
 *
 * @author R
 */
//1. Napisać program, który tworzy dwuwymiarową tablicę liczb całkowitych o losowej wielkości wymiaru (wylosowanej 
//z zakresu [50, 100] i podzielnej przez 4), gdzie liczba wierszy jest równa liczbie kolumn. Następnie tablica zostaje 
//wypełniona liczbami losowymi, z wyjątkiem elementów znajdujących się na przekątnych. Liczby mają być losowane z 
//zakresu [a, b), gdzie liczby a i b podawane są przez użytkownika. Wartości na przekątnych mają być wypełnione w 
//losowym układzie w 75% przypadków cyfrą 1, a w pozostałych 25% przypadków wartością -1.
//Program powinien wyświetlić na ekran liczbę komórek, których wartość jest mniejsza od iloczynu indeksu wiesza i 
//kolumny tej komórki.
public class Zaj2Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        int roz;
        do {
            roz = r.nextInt(51) + 50;
        } while (roz % 4 != 0);

        int[][] tab1 = new int[roz][roz];
    }

}
