/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj2zad1;

import java.util.Random;
import java.util.Scanner;

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
        int roz, los, liczbkom = 0;
        Scanner in = new Scanner(System.in);
        do {
            roz = r.nextInt(51) + 50;//rozmiar tablicy
        } while (roz % 4 != 0);
        System.out.println("Podaj zakres losowania liczb: ");
        int zak1 = in.nextInt();
        int zak2 = in.nextInt();
        roz = 4;
        int[][] tab1 = new int[roz][roz];//przypisz rozmiar
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                tab1[i][j] = r.nextInt((zak2 - zak1) + 1) + zak1;
            }
        }
        for (int i = 0; i < tab1.length; i++) {
            for (int j = 0; j < tab1[i].length; j++) {
                if (i == j || i + j + 1 == roz) {//2 przekątne
                    los = r.nextInt(4);
                    if (los == 0)//do poprawy
                    {
                        tab1[i][j] = -1;
                    } else {
                        tab1[i][j] = 1;
                    }
                }
                if (tab1[i][j] < i * j) {
                    liczbkom++;
                }

            }
        }
        for (int[] x : tab1) {//foreach 2-wymiary
            for (int y : x) {
                System.out.print(y);
            }
            System.out.println();

        }
        System.out.println("Liczba komórek o wartości mniejszej od iloczynu wiersza i kolumny: "+liczbkom );
    }

}
//00  01  02 03 04
//10  11  12 13 14
//20  21  22 23 24
//30  31  32 33 34
//40  41  42 43 44
