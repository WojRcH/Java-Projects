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
     * @param args the command line arguments
     Zaimplementować funkcję z dwoma parametrami (liczby całkowita). W funkcji należy wyznaczyć moduł pierwszej
liczby, a następnie odwróci kolejność cyfr, z których składa wyznaczony moduł. W funkcji powinna zostać zwrócona
nowo powstała liczba, a dodatkowo poprzez drugi parametr suma pierwotnej i nowej liczby.
Uwaga: Nie wolno korzystać z funkcji dokonujących konwersji liczby na łańcuch znaków (szeroko rozumiany) i
łańcuchów znaków na liczby.
Przykład:
5327 
Zwrócone zostanie: 
7235 
12562 
* */
    static double modul(double liczba)
    { 
        double lic;
        double tab[]=new double[10];
        if(liczba<0)
        {
            liczba=liczba*-1;
        }
        for(int i =0;i<tab.length;i++)
        {
           lic=liczba[i];          
        }
        return liczba;
    }
    public static void main(String[] args) {
        double licz=5327;
        modul(licz);
    }
    
}
