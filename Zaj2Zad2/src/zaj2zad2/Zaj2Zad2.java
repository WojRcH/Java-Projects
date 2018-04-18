/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj2zad2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author R
 */
//2. Napisać funkcję, która w dwuwymiarowej tablicy łańcuchów znaków (podanej przez parametr) znajduje liczbę 
//wystąpień frazy podanej jako drugi parametr. Jeśli w danej komórce fraza występuje kilkukrotnie, to należy policzyć 
//każde jej wystąpienie.
//Funkcja zwraca liczbę wystąpień frazy.  Natomiast dodatkowo wyświetlona zostaje średnią długość łańcuchów 
//znajdujących się w tabeli oraz łańcuch stworzony z konkatenacji trzech pierwszych* znaków łańcuchów leżących w 
//kolumnach o indeksach podzielnych przez 5 i niepodzielnych przez liczbę przekazaną przez trzeci parametr funkcji.
//* Jeśli łańcuch jest krótszy od 3 znaków, to należy zastosować wszystkie jego znaki.
public class Zaj2Zad2 {

    /**
     * @param tab
     * @param fraza
     * @return
     */
    public static int ile_wystapien(String[][] tab, String fraza) {
        int ilosc_wyst = 0;
//        Pattern patt=Pattern.compile(fraza);
//        Matcher match;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
//                match=patt.matcher(tab[i][j]) ;//próby z find, lookingAt i contains
                if (tab[i][j].matches("(.*)" + fraza + "(.*)")) {
                    ilosc_wyst++;
                }
            }

        }

        return ilosc_wyst;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String lancuchkonk = "";
        double dlsred = 0, sred, iloscsred = 0;//zmienne do sredniej
//        System.out.println("Podaj zdania do sprawdzenia: ");        
//        String zdanie=s.nextLine();     

        String[][] tab = {{"Ala ma kot kot kot", "dw"}, {"a kot", "ma", "a", "Ala kot"}};

        System.out.println("Podaj frazę do znalezienia: ");
        String fraza = s.nextLine();
        System.out.println("Fraza " + fraza + " wystąpiła " + ile_wystapien(tab, fraza) + " razy");
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                dlsred += tab[i][j].length();
                iloscsred++;
                if (j % 5 == 0 ) {//podzielne przez 5 i niepodzielne przez III-ci parametr funkcji ???? && j%ile_wystapien(tab, fraza)!=0 
                    if (tab[i][j].length() < 3) {
                        lancuchkonk = lancuchkonk.concat(tab[i][j]);
                    } else {
                        char act;
                        for (int it = 0; it <= 3; it++) {
                            act = tab[i][j].charAt(it);
                            lancuchkonk = lancuchkonk.concat(Character.toString(act));
                        }
                    }
                }
            }
        }
        sred = dlsred / iloscsred;
        System.out.println("Średnia ilość znaków w łańcuchu: " + sred);
        System.out.println("Łańcuch stworzony z 3 znaków: " + lancuchkonk);

    }

}
