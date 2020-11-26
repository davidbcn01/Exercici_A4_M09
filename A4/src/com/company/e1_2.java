package com.company;

import javax.crypto.SecretKey;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class e1_2 {
    public static void main(String[] args) throws IOException {
        System.out.println("Xifrar i desxifrar un text en clar amb una clau generada amb el codi 1.1.1");
        System.out.println("Prova alguns dels mètodes que proporciona la classe SecretKey");
        System.out.println("");


        String msg = "hola mundo";
        SecretKey sk = e1.keygenKeyGeneration(256);
        byte[] msgXifrat = e1.encryptData(sk, msg.getBytes());
        byte[] msgDesxifrat = e1.decryptData(sk, msgXifrat);
        String Desxifrat = new String(msgDesxifrat);
        System.out.println(Desxifrat);
        //1.7
        System.out.println(Arrays.toString(sk.getEncoded()));
        System.out.println(sk.getFormat());


        System.out.println("");
        System.out.println("Xifrar i desxifrar un text en clar amb una clau (codi 1.1.2) generada a partir de la paraula de pas");
        System.out.println("");

        String msg2 = "Hello World";
        String passwd = "elpepe";
        SecretKey sk2 = e1.passwordKeyGeneration(passwd, 256);
        byte[] msgXifrat2 = e1.encryptData(sk2, msg2.getBytes());
        byte[] msgDesxifrat2 = e1.decryptData(sk2, msgXifrat2);
        String Desxifrat2 = new String(msgDesxifrat2);
        System.out.println(Desxifrat2);


        System.out.println("");
        System.out.println("Desxifra el text del punt 6 i comprova que donant una paraula de pas incorrecte salta l'excepció BadPaddingException");
        System.out.println("");

        String passwd2 = "etesech";
        SecretKey sk3 = e1.passwordKeyGeneration(passwd2, 256);
        try {
            byte[] msgDesxifrat3 = e1.decryptData(sk3, msgXifrat2);
            String Desxifrat3 = new String(msgDesxifrat3);
            System.out.println(Desxifrat3);
        } catch (Exception e) {
            System.out.println(e);
        }


        System.out.println("");
        System.out.println("Donat un text xifrat (textamagat) amb algoritme estàndard AES i clau simètrica generada amb el mètode SHA-256 a partir d’una contrasenya, i donat un fitxer (clausA4.txt) on hi ha possibles contrasenyes correctes, fes un programa per trobar la bona i desxifrar el missatge.");
        System.out.println("");

        String home = System.getProperty("user.home");
        File file = new File(home + "/" + "clausA4.txt");
        FileReader Fr = new FileReader(file);
        BufferedReader Br = new BufferedReader(Fr);
        String linia = Br.readLine();
        Path path = Paths.get(home + "/" + "textamagat");
        byte[] textEnBytes = Files.readAllBytes(path);
        boolean a =false;
        while (!a) {
            try {
                SecretKey password = e1.passwordKeyGeneration(linia, 128);
                byte[] textDesamagat = e1.decryptData(password, textEnBytes);
                String MensajeD = new String(textDesamagat);
                System.out.println(MensajeD);
                System.out.println("La contraseña es: "+linia);
                a=true;
                break;
            } catch (Exception e) {
                System.out.println("La contraseña no es: " + linia + "  " + e);
                linia = Br.readLine();
            }


        }
    }
}
