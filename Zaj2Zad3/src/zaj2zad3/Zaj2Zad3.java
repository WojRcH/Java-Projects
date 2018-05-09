/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zaj2zad3;

/**
 *
 * @author R
 */
//3. Napisać funkcję split2, która działa podobnie, jak funkcja split (pozwalającej na podzielenie łańcucha znaków na pod 
//łańcuchy (względem podanego znaku / ciągu znaków) i zwrócenie ich w postaci tablicy łańcuchów znaków), ale tym 
//razem podział łańcucha dokonywany może być względem wielu znaków / ciągów znaków (przekazanych w tablicy 
//znaków). Przykładowa deklaracja funkcji:
//String[] split2(String str, String[] tStr); 
public class Zaj2Zad3 {

    /**
     * @param str
     * @param tstr
     * @return
     */
    public static String[] split2(String str, String[] tstr) {
        int roz = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; i < tstr.length; j++) {
                if (str.charAt(i) == tstr[j].charAt(i)) {
                    roz++;
                }
            }

        }
        String[] tablicawypis = new String[roz + 1];
        for (int i = 0; i < tablicawypis.length; i++) {
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < tstr.length; k++) {
                    if (str.charAt(i) == tstr[j].charAt(i)) {
                        tablicawypis[i]+= str.charAt(i);
                    }
                }

            }

        }
      
       return tablicawypis;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        String[] splitznaki = {"a", "o"};
        String[]tablicawyjsc=new String[40];
        String lancuch = "Ala ma kota zato olaf po obiedzie gra w bierki";
        tablicawyjsc=split2(lancuch, splitznaki);
        
    }

}
