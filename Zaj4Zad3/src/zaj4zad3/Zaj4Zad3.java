/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author W
 *
 * 3. Napisać funkcję public static void sumujIZapisz(String nazwaPliku) , któ-
 * ra odczytuje plik o podanej nazwie zawierający liczby całkowite (po jednej w
 * wierszu). Funkcja ma za zadanie odczytać i zsumować wszystkie liczby z pliku,
 * a następnie dopisać na końcu pliku wyznaczoną sumę powiększoną o 1. Ponowne
 * uruchomienia funkcji będą skutkowały dopisywaniem kolejnych wierszy. Jeżeli
 * plik nie istnieje to ma zostać utworzony – suma dla pustego pliku wyniesie 0,
 * a więc należy dopisać wiersz zawierający 1.
 */
public class Zaj4Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void sumujIZapisz(String nazwaPliku) throws IOException {
        Scanner sc = null;
        BufferedWriter bw = null;
        int suma = 0;
        File f = new File(nazwaPliku);
        try {

            if (!f.exists()) {
                bw = new BufferedWriter(new FileWriter(nazwaPliku));
            } else {
                bw = new BufferedWriter(new FileWriter(nazwaPliku, true));
            }
            sc = new Scanner(new BufferedReader(new FileReader(nazwaPliku)));
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    suma += sc.nextInt();
                } else {
                    sc.next();
                }
            }
            bw.newLine();
            bw.write("Wyznaczona suma(+1) wynosi: " + String.valueOf(suma + 1));
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        sumujIZapisz("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad3\\src\\zaj4zad3\\plik.txt");
    }

}
