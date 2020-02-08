import java.security.*;
import java.util.Scanner;
import javax.crypto.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anne
 */

public class JEncrypDES {
    
    public static void main(String[] args) throws Exception{
        System.out.println("Enter the message: No body can see me" );
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        
        //Create a KeyGenerator object
        KeyGenerator DESkey = KeyGenerator.getInstance("DES");
        
        //Create a SecureRandom object
        SecureRandom secRandom = new SecureRandom(); // generate a strong random number
        
        //Initializing the DES KeyGenerator
        DESkey.init(secRandom);
        
        //Creating/Generating a key
        Key key = DESkey.generateKey();
        
        System.out.println("Key: " + key);
        Cipher EncodeCipher = Cipher.getInstance("DES");
        EncodeCipher.init(EncodeCipher.ENCRYPT_MODE,key);
        byte[] encodedText = EncodeCipher.doFinal(userInput.getBytes());
        String encryptedText = new String(encodedText);
        System.out.println("Encoded Text: " + encryptedText);
        
        Cipher DecodeCipher = Cipher.getInstance("DES");
        DecodeCipher.init(DecodeCipher.DECRYPT_MODE, key);
        byte[] decodedText = DecodeCipher.doFinal(encodedText);
        String decryptedText = new String(decodedText);
        //Print out the decrypted text
        System.out.println("Decoded Text: " + decryptedText);
    }
}
