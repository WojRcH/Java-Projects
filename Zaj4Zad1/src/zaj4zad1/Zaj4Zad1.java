/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author R
 *
 * Napisać funkcję liczZnakiSlowa, która zlicza: • liczbę znaków w pliku, •
 * liczbę białych znaków w pliku (białe znaki to spacja, tabulator, znacznik
 * końca wiersza), • liczbę słów w pliku. Wynikiem funkcji jest tablica złożona
 * z 3 liczb całkowitych po jednej dla wymienionych podpunktów.
 */
public class Zaj4Zad1 {

    /**
     * @param args the command line arguments
     */
    static int[] liczZnakiSlowa() throws FileNotFoundException {
        int[]tab=new int[3];
        tab[0]=1;
        try {
            Scanner odczytaj=new Scanner(new File("plik.txt"));
            System.out.println(odczytaj.toString());
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } finally {
            return tab;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        for(int x:liczZnakiSlowa())
        {
            System.out.println(x);
        }
       
    }

}
