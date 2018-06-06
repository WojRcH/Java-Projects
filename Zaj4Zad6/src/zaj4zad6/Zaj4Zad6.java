/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj4zad6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author W
 *
 * 6. Napisać funkcję, której zadaniem jest odczytanie danych tabelarycznych z
 * pliku tekstowego, a następnie zapisanie ich do nowego pliku w postaci kodu
 * HTML. Przykład: Wejście: "Waga" "Wzrost" "BMI" "Nadwaga" 70 1,8 21,6 "NIE" 67
 * 1,77 21,39 "NIE" 85 1,7 29,41 "TAK" 100 1,92 27,13 "TAK" Wynik:
 * <html><body>
 * <table>
 * <tr><td>"Waga"</td><td>"Wzrost"</td><td>"BMI"</td><td>"Nadwaga"
 * </td></tr>
 * <tr><td>70</td><td>1,8</td><td>21,6</td><td>"NIE"
 * </td></tr>
 * <tr><td>67</td><td>1,77</td><td>21,39</td><td>"NIE"
 * </td></tr>
 * <tr><td>85</td><td>1,7</td><td>29,41</td><td>"TAK"
 * </td></tr>
 * <tr><td>100</td><td>1,92</td><td>27,13</td><td>"TAK"</td></tr>
 * </table>
 * </body></html>
 */
public class Zaj4Zad6 {

    /**
     * @param args the command line arguments
     */
    public static void tohtml(String nazwaPliku) throws FileNotFoundException, IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String linia = "", html = "";
        String[] spl = null;
        try {
            br = new BufferedReader(new FileReader(nazwaPliku));
            bw = new BufferedWriter(new FileWriter("C:\\Users\\R\\Documents\\GitHub\\Java-Projects\\Zaj4Zad6\\src\\zaj4zad6\\tohtml.html"));
            html += "<html><body><table>";
            while ((linia = br.readLine()) != null) {
                html += "<tr>";
                spl = linia.split(" ");
                for (int i = 0; i < spl.length; i++) {
                    html += "<td>" + spl[i] + "</td>";
                }
                html += "</tr>";
            }
            html += "</table></body></html>";
            bw.write(html);
        } finally {
            if (bw != null) {
                bw.close();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        tohtml("C:\\Users\\R\\Documents\\GitHub\\Java-Projects\\Zaj4Zad6\\src\\zaj4zad6\\dane.txt");
    }

}
