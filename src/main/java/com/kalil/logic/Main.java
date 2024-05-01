package com.kalil.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 4, 5, 8, 9 , 0 ,4};
        int[] sortedArray = mergeSort(array);
        for (int number : sortedArray) {
            System.out.println(number);
        }
    }

//    Rekursi Pengurutan Gabungan Bilangan dari Kecil ke Besar
    static int[] mergeSort(int[] array) {
        int start = 0;
        int end = array.length - 1;

//      Jika panjang array yang ditinjau lebih dari satu, pecah lagi menjadi dua subarray
        if (start < end) {
            int mid = (start + end)/2;
            int leftSize = mid - start + 1;
            int rightSize = end - mid;

            int[] leftArray = new int[leftSize];
            int[] rightArray = new int[rightSize];

            for (int i = 0; i < leftSize; i++) {
                leftArray[i] = array[i];
            }
            for (int i = 0; i < rightSize; i++) {
                rightArray[i] = array[mid + i + 1];
            }

//          Menerima kedua subarray yang sudah diurutkan menggunakan rekursi
            leftArray = mergeSort(leftArray);
            rightArray = mergeSort(rightArray);

//          Menggabungkan subarray kanan dan kiri
            int leftIdx = 0;
            int rightIdx = 0;
            for (int i = 0; i < array.length; i++) {
                if (leftIdx < leftSize && rightIdx < rightSize) {
                    if (leftArray[leftIdx] <= rightArray[rightIdx]) {
                        array[i] = leftArray[leftIdx];
                        leftIdx++;
                        continue;
                    } else {
                        array[i] = rightArray[rightIdx];
                        rightIdx++;
                        continue;
                    }
                } else if (leftIdx < leftSize) {
                    array[i] = leftArray[leftIdx];
                    if (leftIdx < leftSize - 1){
                        leftIdx++;
                    }} else {
                        array[i] = rightArray[rightIdx];
                        if (rightIdx < rightSize - 1) {
                            rightIdx++;
                        }
                    }
            }
//          Mengembalikan array terurut yang dihasilkan
            return array;
        } else {
//          Jika array input memiliki panjang satu, yang dikembalikan adalah array tersebut sendiri
            return  array;
        }
    }

    static void sortHashMap(HashMap<String, String> map) {
//        Mengurutkan nilai/value yang ada dari hash map
        List<String> sortedValues = map.values().stream().sorted((String v1, String v2) -> v1.compareTo(v2)).toList();
        int idx = 1;
//        Untuk tiap value dari list value yang sudah terurut, cetak key/kunci yang bersangkutan
        for (String value : sortedValues) {
            String key = map.keySet().stream().filter(k -> map.get(k).equals(value)).findFirst().get();
            System.out.println(idx + ". " + key + " : " + value);
            idx++;
        }
    }

    static void findStringInText(String searchWord, String textFilePath) {
//        Mengambil file dari path yang diberikan
        File file = new File(textFilePath);

        try {
//            Membaca isi file teks menggunakan buffered reader
            BufferedReader br = new BufferedReader(new FileReader(file));
            String text;
//            Membaca teks per baris untuk mencari string yang ditentukan
            while ((text = br.readLine()) != null) {
//                Jika string ditemukan, pengulangan berhenti
                if (text.toLowerCase().contains(searchWord.toLowerCase())) {
                    System.out.println("String ditemukan dalam teks");
                    return;
                }
            }
            System.out.println("String tidak ditemukan dalma teks");
        } catch (Exception e) {
            System.out.println("Gagal membaca file");
        }
    }


    static int arraySum(Integer[] array) {
       return Arrays.stream(array).reduce(0, Integer::sum);
    }

    static void printPyramid(char c, int size) {
//        Mencetak karakter sebanyak i kali pada baris ke-i
//        Sampai baris sebanyak size (Bagian pertama piramida)
        for (int i = 0; i < size; i++) {
            System.out.print(String.valueOf(c).repeat(i + 1));
            System.out.println();
//            Mencetak karakter sebanyak i kali pada baris ke size + i
            if (i == size - 1) {
                for (int k = i; k > 0 ; k--) {
                    System.out.print(String.valueOf(c).repeat(k));
                    System.out.println();
                }
            }
        }
    }

}