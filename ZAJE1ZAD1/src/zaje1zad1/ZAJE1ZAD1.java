/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaje1zad1;

import static java.lang.Math.abs;//wartość bezwględna
import java.util.Random;

/**
 *
 * @author W
 */
public class ZAJE1ZAD1 {

    public static int fib(int n) { //metoda licząca ciąg fibbonaciego
        if ((n == 1) || (n == 2)) {

            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        int ilofib1 = 0, ilofib2 = 0, fibiloczyn;
        double srednia, suma = 0, i, ile = 0, max = -49, min = 100;
        do {
            i = r.nextInt(150) - 49;//[-49,100]
            System.out.println(i);

            if (i > max) {
                ilofib2 = (int) max;
                max = i;
            } else if (i < min) {
                min = i;
            }
            if (i % 2 == 0 && i > 0) {
                ile++;
                suma += i;
            }
        } while (i != 0);
        ilofib1 = (int) min;
        if (ilofib1 < 0 || ilofib2 < 0) {
            ilofib1 = abs(ilofib1);
            ilofib2 = abs(ilofib2);
            fibiloczyn = ilofib1 * ilofib2;
        } else {
            fibiloczyn = ilofib1 * ilofib2;
        }
        if (ile > 0) {
            srednia = suma / ile;
            System.out.println("Średnia liczb parzystych: " + srednia);
        } else {
            System.out.println("Nie da się policzyć średniej");
        }

        System.out.println("MAX: " + max);
        System.out.println("MIN: " + min);
        System.out.println("Ciąg liczb fibbonaciego: ");
        //System.out.println(fibiloczyn); //Iloczyn

        if (fibiloczyn > 1) {
            int j = 1;//który wyraz ciągu
            System.out.println("0");
            while (fib(j) < fibiloczyn) {
                System.out.println(fib(j));
                j++;
            }
        } else {
            System.out.println("0");
        }
    }

}
