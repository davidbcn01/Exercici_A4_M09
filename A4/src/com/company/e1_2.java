package com.company;

import javax.crypto.SecretKey;

public class e1_2 {
    public static void main(String[] args) {

        String msg = "hola mundo";
SecretKey sk = e1.keygenKeyGeneration(256);
 byte [] msgXifrat = e1.encryptData(sk, msg.getBytes());
 byte[] msgDesxifrat = e1.decryptData(sk,msgXifrat);
 String Desxifrat = new String(msgDesxifrat);
        System.out.println(Desxifrat);
    }
}
