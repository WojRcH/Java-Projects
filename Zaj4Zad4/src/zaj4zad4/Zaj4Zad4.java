/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author W
 *
 * 4. Stworzyć dwie funkcje: void szyfruj(String nazwaWe, int przesun) void
 * deszyfruj(String nazwaWe, int przesun) Funkcja szyfruj dokonuje szyfrowania
 * pliku, którego nazwa podana została jako pierwszy parametr. Szyfrowanie
 * polega na zamianie każdej litery na znak przesunięty o wartość podaną drugim
 * parametrem np. dla przesunięcia równego 2 literka ’a’ powinna zostać
 * zastąpiona literką ’c’, literka ’z’ literką ’b’ itp. Wynikiem działania
 * funkcji ma być plik o nazwie utworzonej na podstawie nazwy pliku wejściowego
 * poprzez dołączenie znaku ’_’ np. dla pliku dane.txt zaszyfrowana postać
 * powinna mieć nazwę _dane.txt. Funkcja deszyfruj powinna deszyfrować plik
 * (niekoniecznie ten sam) zaszyfrowany przez funkcję szyfruj.
 *
 */
public class Zaj4Zad4 {

    /**
     * @param args the command line arguments
     */
    static void szyfruj(String nazwaWe, int przesun) throws IOException {
        FileReader fr = null;
        PrintWriter pw = null;
        int znak;
        try {
            fr = new FileReader("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad4\\src\\zaj4zad4\\" + nazwaWe + ".txt");
            pw = new PrintWriter("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad4\\src\\zaj4zad4\\_" + nazwaWe + ".txt");
            while ((znak = fr.read()) != -1) {
                if (znak > 96 && znak + przesun < 123) {  //małe litery 
                    pw.write((char) (znak + przesun));
                } else if (znak > 96 && znak < 123) {
                    pw.write((char) (znak - 26 + przesun));
                } else if (znak == 9 || znak == 13 || znak == 32) {
                    pw.write(znak);
                }
            }
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    static void deszyfruj(String nazwaWe, int przesun) throws FileNotFoundException, IOException {
        FileReader fr = null;
        PrintWriter pw = null;
        int znak;
        try {
            fr = new FileReader("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad4\\src\\zaj4zad4\\" + nazwaWe + ".txt");
            nazwaWe = nazwaWe.replace("_", "");
            pw = new PrintWriter("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad4\\src\\zaj4zad4\\" + nazwaWe + ".txt");
            while ((znak = fr.read()) != -1) {
                if (znak - przesun > 96 && znak < 123) {  //małe litery 
                    pw.write((char) (znak - przesun));
                } else if (znak > 96 && znak < 123) {
                    pw.write((char) (znak + 26 - przesun));
                } else if (znak == 9 || znak == 13 || znak == 32) {
                    pw.write(znak);
                }
            }
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        szyfruj("dane", 2);
        //deszyfruj("_dane", 2);
    }

}
