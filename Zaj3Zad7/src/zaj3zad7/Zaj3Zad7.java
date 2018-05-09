/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj3zad7;

/**
 *
 * @author W
 */
public class Zaj3Zad7 {

    /**
     * @param args the command line arguments Zaimplementować funkcję
     * boolean anagram(String a, String b), która sprawdza, czy wyrażenie a jest
     * anagramem wyrażenia b (wyrażeniem utworzonym przez przestawienie liter
     * alfabetu innego wyrażenia). Jeśli funkcja rozpozna anagram, to zwraca
     * wartość prawdziwy (true), w przeciwnym wypadku zwraca wartość fałszywy
     * (fasle). Uwaga: Różnice w liczbie spacji występujących w ciągach nie mają
     * znaczenia. Wielkość liter nie ma znaczenia, tzn. 'A'=='a'. Nie wolno
     * używać funkcji standardowych zmieniających wielkości liter, należy więc
     * samodzielnie ujednolicić ich wielkości w ciągach. Dla następujących
     * wywołań: anagram(”warta”, ”trawa”);
     * anagram(” zwiedzam     patio   ”, ”tempo zadziwia”);
     * anagram(”abcdcba”, ”abcddcba”); funkcja powinna zwrócić wartości: true
     * true false
     */
    static boolean anagram(String a, String b) {
        int sumaznak1 = 0, sumaznak2 = 0, ascii = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) > 96) {
                sumaznak1 += a.charAt(i);
            } else if (a.charAt(i) != 32) {
                ascii = a.charAt(i) + 32;
                sumaznak1 += (char) ascii;
            }

        }
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) > 96) {
                sumaznak2 += b.charAt(i);
            } else if (b.charAt(i) != 32) {
                ascii = b.charAt(i) + 32;
                sumaznak2 += (char) ascii;
            }

        }
        return sumaznak1 == sumaznak2;//zamiast if true; else false;

    }

    public static void main(String[] args) {
        System.out.println(anagram("Warta", "trawa"));
        System.out.println(anagram("  zwiEdZam patio   ", "tempo  zadziwia"));
        System.out.println(anagram("abcdcba", "abcddcba"));
    }

}
