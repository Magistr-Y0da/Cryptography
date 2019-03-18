/*
 * Copyright (c) TommyHard company.
 */

package com.TommyHard.CaesarCipher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CryptoAnalyzer
{
    private String cipherStr;
    private String[] alphabet;
    private String[] strForAnalyzer;
    private int key;

    public CryptoAnalyzer()
    {
        cipherStr = "";
        downloadAlphabet("RU.txt");
        locale("RU");
        analyzer();
    }

    public CryptoAnalyzer(String filepath, String local)
    {
        cipherStr = "";
        downloadAlphabet(filepath);
        locale(local);
    }

    private void locale(String local)
    {
        if(local.equalsIgnoreCase("RU"))
            key = 33;
        if(local.equalsIgnoreCase("USA"))
            key = 26;
    }

    public void textForAnalyzer(String str)
    {
        char[] bufferChar = str.toCharArray();
        String bufferString = "";
        for(int i = 0; i < bufferChar.length; ++i)
        {
            bufferString += bufferChar[i];
            bufferString += " ";
        }
        strForAnalyzer = bufferString.split(" ");
        analyzer();
    }


    private void downloadAlphabet(String filepath)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath)))
        {
            String buffer;
            String bufferReader = "";
            while ((buffer = reader.readLine()) != null)
            {
                bufferReader = bufferReader.concat(buffer);
            }
            alphabet = bufferReader.split(" ");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void analyzer()
    {
        for(int k = 1; k <= key; ++k)
        {
            for (int i = 0; i < strForAnalyzer.length; ++i)
            {
                for (int j = 0; j < alphabet.length; ++j)
                {
                    if (strForAnalyzer[i].equalsIgnoreCase(alphabet[j]))
                    {
                        j -= k;
                        if(j < 0)
                            j += key;
                        strForAnalyzer[i] = alphabet[j];
                        break;
                    }
                }
            }
            for(int i = 0; i < strForAnalyzer.length; ++i)
                cipherStr = cipherStr.concat(strForAnalyzer[i]);
            cipherStr = cipherStr.concat(" ");
        }
    }

    public void showText()
    {
        System.out.println("Your text: " + cipherStr);
    }
}
