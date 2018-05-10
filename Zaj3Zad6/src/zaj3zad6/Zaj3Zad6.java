/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj3zad6;

/**
 *
 * @author W
 */
public class Zaj3Zad6 {

    /**
     * @param args the command line arguments Zaimplementować funkcję z dwoma
     * parametrami (liczby całkowita). W funkcji należy wyznaczyć moduł
     * pierwszej liczby, a następnie odwróci kolejność cyfr, z których składa
     * wyznaczony moduł. W funkcji powinna zostać zwrócona nowo powstała liczba,
     * a dodatkowo poprzez drugi parametr suma pierwotnej i nowej liczby. Uwaga:
     * Nie wolno korzystać z funkcji dokonujących konwersji liczby na łańcuch
     * znaków (szeroko rozumiany) i łańcuchów znaków na liczby. Przykład: 5327 
     * Zwrócone zostanie:  7235  12562 
     *
     */    
    static void modul(int liczba) {
        int liczba1=liczba,liczba2 = 0,suma=0;
        if (liczba < 0) {
            liczba = liczba * -1;
        }
        while (liczba != 0) {//odwraca liczbę
            liczba2 = liczba2 * 10 + liczba % 10;
            liczba /= 10;
        }
        suma=liczba1+liczba2;
        System.out.println(liczba2+"  "+suma);
        
    }

    public static void main(String[] args) {
        modul(5327);
    }

}
