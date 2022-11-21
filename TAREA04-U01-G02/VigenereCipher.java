import java.util.Scanner;

import javax.sound.sampled.LineListener;

public class VigenereCipher
{
    public static String encrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static String decrypt(String text, final String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);  
        System.out.println("Ingrese el mensaje");
        String message = sc.next();
        System.out.println("Ingrese la clave (MAYUSCULAS)");
        String key = sc.next();
        String encryptedMsg = encrypt(message, key);
        System.out.println("Mensaje: " + message);
        System.out.println("Clave: " + key);
        System.out.println("Mensaje encriptado: " + encryptedMsg);
        System.out.println("Mensaje desencriptado " + decrypt(encryptedMsg, key));

    }


}