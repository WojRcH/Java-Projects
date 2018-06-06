/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj5zad1;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author W
 *
 * 1. Dany jest plik, w którym zapisano (w postaci wewnętrznej) kolejne trójki
 * danych tworzące informację o budynkach: • String nazwDom; • int lKondygn; •
 * double cena; Napisać funkcję zmniejszającą (bezpośrednio w pliku, bez
 * wczytywania całego pliku do pamięci) o 10 procent cenę domów parterowych i
 * zwracającą jako wartość nazwę domu (nazwDom) o największej liczbie
 * kondygnacji (jeśli jest takich więcej, to dowolny z nich). Nazwa pliku jest
 * przekazana jako parametr funkcji. *
 */
public class Zaj5Zad1 {

    /**
     * @param args the command line arguments
     */
    public static void stworz_dodaj(String pl, String nazwDom, int lKondygn, double cena) throws IOException { //Tworzy oraz dodaje dane do RandomAccesFile
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(pl, "rw");
            rf.seek(rf.length());
            rf.writeUTF(nazwDom);
            rf.writeInt(lKondygn);
            rf.writeDouble(cena);

        } finally {
            if (rf != null) {
                rf.close();
            }
        }
    }

    public static void wypisz(String pl) throws IOException { //Wypisuje w konsoli cały plik RandomAccessFile
        RandomAccessFile rf = null;
        try {
            rf = new RandomAccessFile(pl, "rw");

            while (rf.getFilePointer() < rf.length()) {
                String nazwDom = rf.readUTF();
                int lKondygn = rf.readInt();
                double cena = rf.readDouble();
                System.out.println(nazwDom + " " + lKondygn + " " + cena);
            }
        } finally {
            if (rf != null) {
                rf.close();
            }
        }

    }

    public static String zmniejsz(String pl) throws IOException {
        RandomAccessFile rf = null;
        String nazwDomNajw = "";
        int maxLKondygn = 0;
        try {
            rf = new RandomAccessFile(pl, "rw");
            while (rf.getFilePointer() < rf.length()) {
                String nazwDom = rf.readUTF();
                int lKondygn = rf.readInt();
                long pozycja = rf.getFilePointer();//pozycja przed cena
                double cena = rf.readDouble();
                if (lKondygn == 1) {
                    long tmppos = rf.getFilePointer();//pozycja za cena
                    rf.seek(pozycja);
                    rf.writeDouble(cena * 0.9);
                    rf.seek(tmppos);
                }
                if (maxLKondygn < lKondygn) {
                    nazwDomNajw = nazwDom;
                    maxLKondygn = lKondygn;
                }
            }

        } finally {
            if (rf != null) {
                rf.close();
            }
            return nazwDomNajw;
        }
    }

    public static void main(String[] args) throws IOException {
        String sciezka = "C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj5Zad1\\src\\zaj5zad1\\plik.data";
        stworz_dodaj(sciezka, "Bliźniak", 2, 250000);
        stworz_dodaj(sciezka, "Blok", 11, 300000);
        stworz_dodaj(sciezka, "Wolnostojący", 1, 600000);
        System.out.println(zmniejsz(sciezka));
        wypisz(sciezka);

    }

}
