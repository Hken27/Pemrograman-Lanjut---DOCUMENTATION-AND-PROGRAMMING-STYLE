package Modul6;

import java.io.*;
import java.util.*;

/**
 *
 * @author Wahyu *
 *         Praktikum terakhir pemrograman lanjut, dengan ketentuan setiap value
 *         data dibedakan sesuai tipe nya
 */

public class Praktikum1 {

    public static void main(String[] args) {

        // Menyimpan hasil inputan array
        ArrayList<String> Nama = new ArrayList<String>();
        ArrayList<Integer> Nomor = new ArrayList<Integer>();

        // tempat penyimpanan data yang sudah disortir
        File file = new File("DatabaseInt.txt");
        File file2 = new File("DatabaseStr.txt");

        // Sebagai input data
        Scanner input = new Scanner(System.in);

        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.print("Masukan Jumlah Elemen Yang Di Inputan : ");
        int x = input.nextInt();

        // Deklarasi array
        String kata[] = new String[x];

        // Input data ke array
        try {

            for (int i = 0; i < kata.length; i++) {
                System.out.print("Kata ke " + (i + 1) + " : ");
                kata[i] = input.next();
                if (cekHasil(kata[i])) {

                    // add untuk menambahkan dalam index dan replace all digunakan untuk
                    // menghilangkan sesuai regex
                    Nomor.add(Integer.parseInt(kata[i].replaceAll("([a-z])", " ")));

                    // Write int digunakan untuk menuliskan hasil kedalam file
                    hasilNumber(file, Nomor);

                } else {

                    // add untuk menambahkan dalam index dan replace all digunakan untuk
                    // menghilangkan sesuai regex
                    Nama.add(kata[i].replaceAll("([0-9])", " "));

                    // Write int digunakan untuk menuliskan hasil kedalam file
                    hasilString(file2, Nama);

                }

            }

        } catch (Exception e) {

        }

        // Menampilkan data hasil
        System.out.println("\t\n.>>>>Kata-kata yang dimasukan.<<<<");
        System.out.println("-----------------------------------------");
        System.out.println("\tIn Numbers : " + Nomor + " ");
        System.out.println("\tIn String  : " + Nama + " ");
        System.out.println();
        System.out.println("\t<<<< Terima kasih >>>>");
        System.out.println("-----------------------------------------");

    }

    /**
     * Kumpulan fungsi
     * 
     * cek hasil dan cetak value
     */

    static void hasilNumber(File filename, ArrayList<Integer> x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        outputWriter.write(x + " ");
        outputWriter.flush();
        outputWriter.close();
    }

    static void hasilString(File filename, ArrayList<String> x) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter(filename));
        outputWriter.write(x + " ");
        outputWriter.flush();
        outputWriter.close();
    }

    static boolean cekHasil(String s) throws IOException {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) == false)
                return false;
        }
        
        return true;
        
    }

}
