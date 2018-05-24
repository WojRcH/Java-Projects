/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author W
 *
 * 2. Napisać funkcję: public static void szukaj(String nazwaPlikWe, String
 * nazwaPlikWy, String slowo) której zadaniem jest znalezienie wszystkich
 * wierszy w pliku, które zawierają szukane słowo. Wszystkie wiersze, które
 * zawierają słowo powinny zostać zapisane w pliku wynikowym wraz z nr wiersza
 * (z pierwszego pliku). Nazwa pierwszego pliku zapamiętana jest w parametrze
 * nazwaPlikWe, nazwa pliku wynikowego podana jest w parametrze nazwaPlikWy,
 * natomiast szukane słowo w parametrze slowo. Przykład - plik wejściowy: Ala ma
 * jutro egzamin z biologii. Jan myje auto. Eh, jutro kolejny egzamin. Nie lubie
 * polityki. Jeżeli szukanym słowem byłoby ”egzamin”, to plik wynikowy powinien
 * wyglądać następująco: 1: Ala ma jutro egzamin z biologii. 3: Eh, jutro
 * kolejny egzamin.
 *
 */
public class Zaj4Zad2 {

    /**
     * @param nazwaPlikWe
     * @param nazwaPlikWy
     * @param slowo
     * @throws java.io.IOException
     */
    public static void szukaj(String nazwaPlikWe, String nazwaPlikWy, String slowo) throws IOException {
        BufferedReader br = null;
        PrintWriter pw = new PrintWriter(nazwaPlikWy);
        String linia;
        int liczwierszow = 1;
        try {
            br = new BufferedReader(new FileReader(nazwaPlikWe));
            while ((linia = br.readLine()) != null) {

                //System.out.println(linia);
                if (linia.contains(slowo)) {
                    pw.print(liczwierszow + ": " + linia + "\n");
                }
                liczwierszow++;

            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        szukaj("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad2\\src\\zaj4zad2\\plikwe.txt", "C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj4Zad2\\src\\zaj4zad2\\plikwy.txt", "egzamin");
    }

}
