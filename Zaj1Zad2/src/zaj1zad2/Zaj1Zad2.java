/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj1zad2;

import java.util.Random;
// Napisać program, który generuje liczby pseudolosowe z zakresu [-10,0; 10,0] dopóty, dopóki nie zostanie
//wylosowana liczba 0,0. Co ważne – liczby powinny być zmiennopozycyjne z dokładnością do pierwszego
//miejsca po przecinku (tylko i wyłącznie). W wyniku wykonania programu (bez wykorzystania tablic),
//powinna zostać wyświetlona suma co drugiej z wylosowanych liczb (zaczynając od pierwszej) oraz średnia
//arytmetyczna liczb dodatnich, podzielnych przez trzy.
//Dodatkowo, jeszcze raz powinno zostać wylosowanych (całkowite, zakres [-10, 10]) tyle samo liczb, ile
//wylosowano w pierwszej pętli, a w wyniku powinno zostać wyświetlone, ile z tych liczb było większych od
//największej liczby wylosowanej w pierwszej pętli oraz różnica pomiędzy średnią arytmetyczną liczb
//wylosowanych w pierwszej pętli, a średnią arytmetyczną liczb wylosowanych w drugiej pętli, że
//wskazaniem, która pętla miała wyższą średnią.
//Uwaga,
//nie należy używać (importować) żadnych dodatkowych bibliotek, poza klasą niezbędną do obsługi
//losowania liczb. W programie nie należy używać tablic
/**
 *
 * @author W
 */
public class Zaj1Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //java.text.DecimalFormat df=new java.text.DecimalFormat("0.0");//jedno miejsce po przecinku
        Random r = new Random();
        double randvalue, suma = 0, max = -10, sumasr = 0, srednia = 0,srednia1calosc=0,srednia2=0, liczsr1 = 0,liczsr2=0;
        int licznik = 0, randvalueint, liczwieksze = 0;
        int zaokr = (int) Math.pow(10, 1);
        System.out.println("Pierwsze losowanie:");
        System.out.println();
        do {
            licznik++;
            randvalue = -10.0 + (10.0 - (-10.0)) * r.nextDouble();//Wartość od -10.0 do 10.0
            randvalue *= zaokr;
            randvalue = Math.round(randvalue);
            randvalue /= zaokr;//jedno miejsce po przecinku II metoda
            System.out.println(randvalue);
            //System.out.println(df.format(randvalue));
            srednia1calosc+=randvalue;
            if (licznik % 2 != 0) {
                suma += randvalue;

            }
            if (randvalue > 0 && randvalue % 3.0 == 0.0) {
                liczsr1++;
                sumasr += randvalue;
            }
            if (randvalue > max) {
                max = randvalue;
            }
        } while (randvalue != 0.0);
        System.out.println();
            suma *= zaokr;
            suma = Math.round(suma);
            suma /= zaokr;
        System.out.println("Suma co drugiej liczby: "+suma);
        System.out.println();
        if (liczsr1 > 0) {
            srednia = sumasr / liczsr1;
            srednia *= zaokr;
            srednia = Math.round(srednia);
            srednia /= zaokr;
            System.out.println("Średnia liczb dodatnich podzielnych przez 3 wynosi: " + srednia);
        } else {
            System.out.println("Nie występują liczby dodatnie podzielne przez 3!");
        }
        srednia1calosc=srednia1calosc/licznik;
        System.out.println();
        System.out.println("Drugie losowanie:");
        System.out.println();
        for (int i = 0; i < licznik; i++) {
            randvalueint = r.nextInt(20) - 10;
            System.out.println(randvalueint);
            if (randvalueint > max) {
                liczwieksze++;
            }
            srednia2+=randvalueint;
            liczsr2++;
        }
        //System.out.println(max);
        System.out.println();
        System.out.println("Ilość liczb większych od maksymalnej z I losowania: " + liczwieksze);
        srednia2=srednia2/liczsr2;//srednia calosc druga pętla
//        System.out.println(srednia1calosc);
//        System.out.println(srednia2);
        System.out.println();
        
        if(srednia2>srednia1calosc){
            double roznicasr=srednia2-srednia1calosc;
            roznicasr *= zaokr;
            roznicasr = Math.round(roznicasr);
            roznicasr /= zaokr;
        System.out.println("Wyższą średnią miała pętla druga i była większa o "+(roznicasr));}
        else{ 
            double roznicasr=srednia1calosc-srednia2;
            roznicasr *= zaokr;
            roznicasr = Math.round(roznicasr);
            roznicasr /= zaokr;
            System.out.println("Wyższą średnią miała pętla pierwsza i była większa o "+(roznicasr));}
    }

}
