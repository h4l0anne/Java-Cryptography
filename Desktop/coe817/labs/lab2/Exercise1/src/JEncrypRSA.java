
import java.security.*;
import java.util.Scanner;
import javax.crypto.Cipher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anne
 */
public class JEncrypRSA {
            
            
    public static void main(String[] args) throws Exception{
        PublicKey publicKey;
        PrivateKey privateKey;
        
        System.out.println("Enter the message: No body can see me" );
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        
        //Create a KeyPairGenerator object
        KeyPairGenerator RSAkeyGen = KeyPairGenerator.getInstance("RSA");
        
        //initialize the keyPairGenerator
        RSAkeyGen.initialize(2048);
        //Generate the key pair
        KeyPair key = RSAkeyGen.generateKeyPair();
        
        privateKey = key.getPrivate();
        publicKey = key.getPublic();
        
        //Create a SecureRandom object
        SecureRandom secRandom = new SecureRandom(); // generate a strong random number
        
        System.out.println("Private Key: " + privateKey);
        System.out.println("Public Key: " + publicKey);
        
        Cipher EncodeCipher = Cipher.getInstance("RSA");
        EncodeCipher.init(EncodeCipher.ENCRYPT_MODE,publicKey);
        byte[] encodedText = EncodeCipher.doFinal(userInput.getBytes());
        String encryptedText = new String(encodedText); 
        System.out.println("Encoded Text: " + encodedText);
        
        Cipher DecodeCipher = Cipher.getInstance("RSA");
        DecodeCipher.init(DecodeCipher.DECRYPT_MODE, privateKey);
        byte[] decodedText = DecodeCipher.doFinal(encodedText);
        String decryptedText = new String(decodedText);
        //Print out the decrypted text
        System.out.println("Decoded Text: " + decryptedText);
    }
    
}
