/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj3zad4;

/**
 *
 * @author R
 */
public class Zaj3Zad4 {

    public static void firstlast(String s, char c) {
        int liczb_lit = 0;
        char lit;
        for (int i = 0; i < s.length(); i++) // przejście po tekście
        {
            lit = s.charAt(i);
            if (lit == c) {
                liczb_lit++;
            }
        }
        String strin;
        int odl = 0;
        if (liczb_lit > 1) {
            odl = s.lastIndexOf(c) - s.indexOf(c) - 1;
            strin = s.substring(s.indexOf(c) + 1, s.lastIndexOf(c));
        } else {
            strin = "";
        }
        System.out.println("Odległość liter " + c + ": " + odl + " Wycięty tekst: " + strin);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String tekst = "alarm";
        System.out.println("Słowo: " + tekst);

        firstlast(tekst, 'a');//metoda
    }

}
