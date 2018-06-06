/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author W
 *
 * 5. Napisać funkcję emerytura(String nazwaPliku), która wczyta z pliku o
 * podanej nazwie dane pracowników zapisane w kolejnych wierszach w następujący
 * sposób: Imię Nazwisko Płeć Wiek Przykład: Tomasz Nowak M 45 Marta Ziobro K 42
 * Jan Kowalski M 27 Ewelina Tusk K 59 Następnie funkcja dla każdego pracownika
 * powinna wyznaczyć ile lat pozostało do jego emerytury. Wyniki należy zapisać
 * w następujący sposób: Nazwisko Imię ”Lata do emerytury” Przykład: Nowak
 * Tomasz 20 Kowalski Jan 38 Wyniki dla kobiet należy zapisać w pliku o nazwie
 * ”kobiety.txt”, natomiast wyniki dla mężczyzn należy zapisać w pliku
 * ”mezczyzni.txt”.
 *
 */
public class Zaj4Zad5 {

    /**
     * @param nazwaPliku
     * @param args the command line arguments
     */
    public static void emerytura(String nazwaPliku) throws IOException {

        String[] pracownicy = null;
        int[] emeryturawiek = null;
        String linia = "";
        int liczosob = 0;
        int i = 0;
        BufferedWriter bwm = new BufferedWriter(new FileWriter("C:\\Users\\R\\Documents\\GitHub\\Java-Projects\\Zaj4Zad5\\src\\zaj4zad5\\mezczyzni.txt"));
        BufferedWriter bwk = new BufferedWriter(new FileWriter("C:\\Users\\R\\Documents\\GitHub\\Java-Projects\\Zaj4Zad5\\src\\zaj4zad5\\kobiety.txt"));
        BufferedReader br = null;
        Scanner sc = null;
        try {
            br = new BufferedReader(new FileReader(nazwaPliku));
            sc = new Scanner(new BufferedReader(new FileReader(nazwaPliku)));
            while ((linia = br.readLine()) != null) {
                liczosob++;
            }
            emeryturawiek = new int[liczosob];
            while (sc.hasNext()) {//można było splitem który jest później
                if(sc.hasNextInt()){
                emeryturawiek[i] = 65 - sc.nextInt();//wiek ustalony do emerytury 65 lat
                i++;
                }else
                sc.next();
            }
            br = new BufferedReader(new FileReader(nazwaPliku));
            pracownicy = new String[liczosob];
            i = 0;
            while ((linia = br.readLine()) != null) {
                pracownicy[i] = linia;
                i++;
            }
            linia = "";
            for (i = 0; i < pracownicy.length; i++) {
                String[] spl = pracownicy[i].split(" ");
                linia = spl[1] + " " + spl[0] + " " + emeryturawiek[i]+"\n";
                if ("M".equals(spl[2])) {
                    bwm.write(linia);
                    bwm.newLine();
                } else {
                    bwk.write(linia);
                    bwk.newLine();
                }
                
            }
//            for (String x : pracownicy) {
//                System.out.println(x);
//            }
        } finally {
            if (bwk != null || bwm != null) {
                bwk.close();
                bwm.close();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        emerytura("C:\\Users\\R\\Documents\\GitHub\\Java-Projects\\Zaj4Zad5\\src\\zaj4zad5\\osoby.txt");
    }

}
