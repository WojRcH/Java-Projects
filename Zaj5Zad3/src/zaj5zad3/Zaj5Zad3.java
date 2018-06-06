/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj5zad3;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author W
 *
 * 3. Napisać funkcję Kompresuj( String plikWej, String plikWyn ) przetwarzającą
 * plik tekstowy (plikWej) na plik obiektów (plikWyn). Przetwarzanie polega na
 * zastąpieniu każdego ciągu identycznych znaków pliku tekstowego obiektem
 * zawierającym ten znak i liczbę jego kolejnych wystąpień w tym ciągu. Koniec
 * wiersza należy traktować jako pojedynczy znak CR. znak liczba Przykład:
 * a_bbb_cccc dd_e_ffffff wynik (plik obiektowy z kolejnymi parami danych znak i
 * liczba):: a 1 _ 1 b 3 _ 1 c 3 CR 1 d 2 _ 1 e 1 _ 1 f 6
 */
class Paraznak implements Serializable {

    String znak;
    int licznik;

    public Paraznak(String _znak, int _licznik) {
        znak = _znak;
        licznik = _licznik;
    }
}

public class Zaj5Zad3 {

    /**
     * @param args the command line arguments
     */
    public static void wypiszobj(String pl) throws IOException, ClassNotFoundException {
        ObjectInputStream plikObj = null;
        try {
            plikObj = new ObjectInputStream(new FileInputStream(pl));
            while (true) {
                Paraznak pz = (Paraznak) plikObj.readObject();
                System.out.println(pz.znak + " " + pz.licznik);
            }

        } catch (EOFException ex) {//end of file exception

        } finally {
            if (plikObj != null) {
                plikObj.close();
            }
        }

    }

    public static void kompresuj(String plikWej, String plikWyn) throws FileNotFoundException, IOException {
        FileReader wej = null;
        ObjectOutputStream wyj = null;
        int znak, znakpoprz = 0, licznik = 1, liczpom = 0;
        String wpisz = "";
        try {
            wej = new FileReader(plikWej);
            wyj = new ObjectOutputStream(new FileOutputStream(plikWyn));
            while ((znak = wej.read()) != -1) {
                if (znak == znakpoprz) {
                    licznik++;
                } else {
                    if (liczpom != 0) {
                        if (znakpoprz == 13) {
                            wpisz = "CR";
                        } else if(znak!=13) {// wypisuje enter do poprawy!!!!
                            wpisz = Character.toString((char) znakpoprz);
                        }
                        Paraznak pz = new Paraznak(wpisz, licznik);
                        wyj.writeObject(pz);
                        licznik = 1;
                    }
                }
                liczpom++;
                znakpoprz = znak;
            }
            wpisz = Character.toString((char) znakpoprz);
            Paraznak pz = new Paraznak(wpisz, licznik);
            wyj.writeObject(pz);
        } finally {
            if (wyj != null) {
                wyj.close();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        kompresuj("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj5Zad3\\src\\zaj5zad3\\wejsciowy.txt", "C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj5Zad3\\src\\zaj5zad3\\wyjsciowy.data");
        wypiszobj("C:\\Users\\W\\Documents\\GitHub\\Java-Projects\\Zaj5Zad3\\src\\zaj5zad3\\wyjsciowy.data");
    }

}
