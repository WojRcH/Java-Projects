/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj5zad2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author W
 *
 * 2. Dany jest plik, w którym zapisano informacje o nieruchomościach w postaci
 * kolejnych trójek: • String nazwDom; • int lKondygn; • BigDecimal cena;
 * Napisać funkcję zwiększającą o 15 procent cenę domów 2-piętrowych i wpisującą
 * dane tych domów do pliku tekstowego (dane o jednym domu w jednym wierszu;
 * cena po zmianie) i zwracającą jako swoją wartość liczbę domów, których cen
 * nie zmieniono. Nazwy plików są przekazywane przez parametry funkcji.
 */
class Nieruchomosc implements Serializable {

    String nazwDom;
    int lKondygn;
    BigDecimal cena;

    public Nieruchomosc(String _nazwDom, int _lKondygn, BigDecimal _cena)//konstruktor
    {
        nazwDom = _nazwDom;
        lKondygn = _lKondygn;
        cena = _cena;
    }
}

public class Zaj5Zad2 {

    /**
     * @param args the command line arguments
     */
    public static void zapisz(String pl) throws IOException {
        ObjectOutputStream plikObj = null;
        BigDecimal ile = new BigDecimal(320000);
        Nieruchomosc nier1 = new Nieruchomosc("blok", 11, ile);//Koniecznie tutaj aby nie nadpisywać pliku object
        ile = new BigDecimal(230000);
        Nieruchomosc nier2 = new Nieruchomosc("wolnostojący", 1, ile);
        ile = new BigDecimal(630000);
        Nieruchomosc nier3 = new Nieruchomosc("bliźniak", 2, ile);
        try {
            plikObj = new ObjectOutputStream(new FileOutputStream(pl));
            plikObj.writeObject(nier1);
            plikObj.writeObject(nier2);
            plikObj.writeObject(nier3);
            plikObj.flush();
        } finally {
            if (plikObj != null) {
                plikObj.close();
            }
        }

    }

    public static int zwieksz(String pl, String plwy) throws FileNotFoundException, IOException, ClassNotFoundException {
        int liczbezzmian = 0;
        BufferedWriter bw = null;
        ObjectInputStream plikObj = null;
        try {
            plikObj = new ObjectInputStream(new FileInputStream(pl));
            bw = new BufferedWriter(new FileWriter(plwy));
            while (true) {
                Nieruchomosc n = (Nieruchomosc) plikObj.readObject();
                if (n.lKondygn == 2) {
                    n.cena = n.cena.multiply(new BigDecimal(1.15));
                    bw.write(n.nazwDom + " " + n.cena.round(new MathContext(10)));//zaokrąglenie BigDecimal
                } else {
                    liczbezzmian++;
                }
            }
        } finally {
            if (plikObj != null) {
                plikObj.close();
            }
            if (bw != null) {
                bw.close();
            }
            return liczbezzmian;
        }

    }

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        String sciezka = "C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj5Zad2\\src\\zaj5zad2\\obj.data";
        String sciezkawyj = "C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj5Zad2\\src\\zaj5zad2\\domy.txt";
        //BigDecimal ile = new BigDecimal(320000);
        //Nieruchomosc nier1 = new Nieruchomosc("blok", 11, ile);
        //ile = new BigDecimal(230000);
        //Nieruchomosc nier2 = new Nieruchomosc("wolnostojący", 1, ile);
        //ile = new BigDecimal(630000);
        //Nieruchomosc nier3 = new Nieruchomosc("bliźniak", 2, ile);
        zapisz(sciezka);
        //zapisz(sciezka, nier2);//ObjectInputStream nadpisuje
        //zapisz(sciezka, nier3);
        System.out.println("Liczba nieruchomości bez zmian ceny: " + zwieksz(sciezka, sciezkawyj));
    }

}
