/*
 * Copyright (c) TommyHard company.
 * This is class implements cipher Caesar.
 */

package com.TommyHard.CaesarCipher;

import java.io.*;
import java.util.Random;

public class CaesarCipher
{
    private String textStr;
    private String encryptedStr;
    private int encryptionKey;


    public void text(String str)
    {
        String buf = "";
        char[] textByChar = str.toCharArray();
        for(int i = 0; i < textByChar.length; ++i) {
            buf += textByChar[i];
            buf += " ";
        }
        textStr = buf;
    }


    public void downloadAlphabet(String filepath, String local)
    {
        int localParam = 0;
        if(local.equalsIgnoreCase("RU"))
        {
            localParam = 33;
            keyGenerator(localParam);
        }
        if(local.equalsIgnoreCase("USA"))
        {
            localParam = 26;
            keyGenerator(localParam);
        }

        try(BufferedReader reader = new BufferedReader(new FileReader(filepath)))
        {
            String buff;
            String readBuffStr = "";
            while ((buff = reader.readLine()) != null)
            {
                readBuffStr = readBuffStr.concat(buff);
            }
            reader.close();

            String[] bufferAlphabet = readBuffStr.split(" ");
            String[] bufferTextStr = textStr.split(" ");


            for(int i = 0; i < bufferTextStr.length; ++i)
            {

                for(int j = 0; j < bufferAlphabet.length; ++j)
                {
                    if(bufferTextStr[i].equalsIgnoreCase(bufferAlphabet[j]))
                    {
                        j += encryptionKey;
                        if(j >= localParam)
                            j -= localParam;
                        bufferTextStr[i] = bufferAlphabet[j];
                        break;
                    }
                }
            }

            String result = "";

            for(int i = 0; i < bufferTextStr.length; ++i)
            {
                result = result.concat(bufferTextStr[i]);
            }
            encryptedStr = result;

        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }


    private void keyGenerator(int param)
    {
        int min = 1;
        Random rand =  new Random();
        encryptionKey = rand.nextInt((param - min) + 1) + min;
    }

    public void showEncryptedString()
    {
        System.out.println(encryptedStr + " Your key: " + encryptionKey);
    }

}
