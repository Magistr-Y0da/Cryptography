package Main;

import com.Magistr_Y0da.CaesarCipher.CaesarCipher;
import com.Magistr_Y0da.CaesarCipher.CryptoAnalyzer;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Input string for encrypted: ");
        String strText = input.nextLine();


        CaesarCipher s = new CaesarCipher();
        s.text(strText);
        s.downloadAlphabet("RU","ru");
        s.showEncryptedString();

        System.out.println("Input string for decipher: ");
        String strText2 = input.nextLine();
        CryptoAnalyzer sa = new CryptoAnalyzer("RU", "ru");
        sa.textForAnalyzer(strText2);
        sa.showText();
    }
}

