/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author R
 *
 * 1. Napisać funkcję liczZnakiSlowa, która zlicza: • liczbę znaków w pliku, •
 * liczbę białych znaków w pliku (białe znaki to spacja, tabulator, znacznik
 * końca wiersza), • liczbę słów w pliku. Wynikiem funkcji jest tablica złożona
 * z 3 liczb całkowitych po jednej dla wymienionych podpunktów.
 */
public class Zaj4Zad1 {

    /**
     * @return @throws java.io.FileNotFoundException
     */
    public static int[] liczZnakiSlowa() throws FileNotFoundException, IOException {
        int[] tab = new int[3];
        //String[] spl;
        int liczznakow = 0, liczbialznak = 0, liczslow = 0, znak;
        String tostring = "";
        FileReader plik = null;
        try {
            plik = new FileReader("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad1\\src\\zaj4zad1\\plik.txt");
            while ((znak = plik.read()) != -1) {
                tostring += (char) znak;
                if (znak == 32 || znak == 9 || znak == 13) {
                    liczbialznak++;
                }
                liczznakow++;
            }
            StringTokenizer st = new StringTokenizer(tostring); //Lepsza alternatywa niż split 
            while (st.hasMoreTokens()) {
                liczslow++;
                st.nextToken();
            }
            //spl = tostring.split(" "); 
            // liczslow = spl.length;
            tab[0] = liczznakow;
            tab[1] = liczbialznak;
            tab[2] = liczslow;
            return tab;

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            if (plik != null) {
                plik.close();
            }
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //liczZnakiSlowa();
        for (int x : liczZnakiSlowa()) {
            System.out.println(x);
        }

    }

}
