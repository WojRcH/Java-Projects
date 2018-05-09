/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj3zad8;

/**
 *
 * @author W
 */
public class Zaj3Zad8 {

    /**
     * @param args the command line arguments
     *
     * Zaimplementować funkcję void akronim(String s), która drukuje na
     * standardowym wyjściu akronim (wyraz sztucznie ułożony z pierwszych liter
     * innych wyrazów). Należy pamiętać aby wyjściowy akronim był ułożony
     * wyłącznie z wielkich liter. Uwaga: nie wolno korzystać z funkcji
     * standardowej toupper(). Założenia: Przekazywany łańcuch składa się tylko
     * z poprawnych słów oddzielonych pojedynczą spacją (spacje nie występują w
     * żadnych innych miejscach). Dla następujących wywołań funkcji:
     * akronim(”Rzeczpospolita Polska”);
     * akronim(”Wydział Informatyki i Nauki o Materiałach”); akronim(”Polski Zwi
     * zek Piłki No nej”); ą ż na wyjściu powinien zostać wydrukowany tekst:
     * Akronim wyra enia 'Rzeczpospolita Polska' to 'RP' ż Akronim wyra
     * enia 'Wydział Informatyki i Nauki o Materiałach' to 'WIINOM' ż
     * Akronim wyra enia 'Polski Zwi zek Piłki No nej' to 'PZPN'
     *
     */
    static void akronim(String s) {
        String akron = "";
        int ascii = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) > 90) {//zmiana z małej litery na dużą
                    ascii = s.charAt(i) - 32;
                    akron += (char) ascii;
                } else {
                    akron += s.charAt(i);
                }
            }
            if (s.charAt(i) == ' ' || s.charAt(i) == '\t' || s.charAt(i) == '\n' || s.charAt(i) == '\r') {
                if (s.charAt(i + 1) > 90) {
                    ascii = s.charAt(i + 1) - 32;
                    akron += (char) ascii;
                } else {
                    akron += s.charAt(i + 1);
                }
            }

        }
        System.out.println("Akronim wyrażenia: '" + s + "' to '" + akron + "'");
    }

    public static void main(String[] args) {
        akronim("Rzeczpospolita polska");
        akronim("Wydział Informatyki i Nauki o Materiałach");
        akronim("Polski Związek Piłki Nożnej");
    }

}
