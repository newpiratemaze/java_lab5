package org.example.processor;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor
{
    public Map<String, String> MORSE_MAP = new HashMap<>();


    public String getMorseCode(String str)
    {
        // английские заглавные (у тебя уже есть)
        MORSE_MAP.put("A", ".-");
        MORSE_MAP.put("B", "-...");
        MORSE_MAP.put("C", "-.-.");
        MORSE_MAP.put("D", "-..");
        MORSE_MAP.put("E", ".");
        MORSE_MAP.put("F", "..-.");
        MORSE_MAP.put("G", "--.");
        MORSE_MAP.put("H", "....");
        MORSE_MAP.put("I", "..");
        MORSE_MAP.put("J", ".---");
        MORSE_MAP.put("K", "-.-");
        MORSE_MAP.put("L", ".-..");
        MORSE_MAP.put("M", "--");
        MORSE_MAP.put("N", "-.");
        MORSE_MAP.put("O", "---");
        MORSE_MAP.put("P", ".--.");
        MORSE_MAP.put("Q", "--.-");
        MORSE_MAP.put("R", ".-.");
        MORSE_MAP.put("S", "...");
        MORSE_MAP.put("T", "-");
        MORSE_MAP.put("U", "..-");
        MORSE_MAP.put("V", "...-");
        MORSE_MAP.put("W", ".--");
        MORSE_MAP.put("X", "-..-");
        MORSE_MAP.put("Y", "-.--");
        MORSE_MAP.put("Z", "--..");

// английские маленькие
        MORSE_MAP.put("a", ".-");
        MORSE_MAP.put("b", "-...");
        MORSE_MAP.put("c", "-.-.");
        MORSE_MAP.put("d", "-..");
        MORSE_MAP.put("e", ".");
        MORSE_MAP.put("f", "..-.");
        MORSE_MAP.put("g", "--.");
        MORSE_MAP.put("h", "....");
        MORSE_MAP.put("i", "..");
        MORSE_MAP.put("j", ".---");
        MORSE_MAP.put("k", "-.-");
        MORSE_MAP.put("l", ".-..");
        MORSE_MAP.put("m", "--");
        MORSE_MAP.put("n", "-.");
        MORSE_MAP.put("o", "---");
        MORSE_MAP.put("p", ".--.");
        MORSE_MAP.put("q", "--.-");
        MORSE_MAP.put("r", ".-.");
        MORSE_MAP.put("s", "...");
        MORSE_MAP.put("t", "-");
        MORSE_MAP.put("u", "..-");
        MORSE_MAP.put("v", "...-");
        MORSE_MAP.put("w", ".--");
        MORSE_MAP.put("x", "-..-");
        MORSE_MAP.put("y", "-.--");
        MORSE_MAP.put("z", "--..");

// русский алфавит
        MORSE_MAP.put("А", ".-");
        MORSE_MAP.put("Б", "-...");
        MORSE_MAP.put("В", ".--");
        MORSE_MAP.put("Г", "--.");
        MORSE_MAP.put("Д", "-..");
        MORSE_MAP.put("Е", ".");
        MORSE_MAP.put("Ё", ".");
        MORSE_MAP.put("Ж", "...-");
        MORSE_MAP.put("З", "--..");
        MORSE_MAP.put("И", "..");
        MORSE_MAP.put("Й", ".---");
        MORSE_MAP.put("К", "-.-");
        MORSE_MAP.put("Л", ".-..");
        MORSE_MAP.put("М", "--");
        MORSE_MAP.put("Н", "-.");
        MORSE_MAP.put("О", "---");
        MORSE_MAP.put("П", ".--.");
        MORSE_MAP.put("Р", ".-.");
        MORSE_MAP.put("С", "...");
        MORSE_MAP.put("Т", "-");
        MORSE_MAP.put("У", "..-");
        MORSE_MAP.put("Ф", "..-.");
        MORSE_MAP.put("Х", "....");
        MORSE_MAP.put("Ц", "-.-.");
        MORSE_MAP.put("Ч", "---.");
        MORSE_MAP.put("Ш", "----");
        MORSE_MAP.put("Щ", "--.-");
        MORSE_MAP.put("Ъ", "--.--");
        MORSE_MAP.put("Ы", "-.--");
        MORSE_MAP.put("Ь", "-..-");
        MORSE_MAP.put("Э", "..-..");
        MORSE_MAP.put("Ю", "..--");
        MORSE_MAP.put("Я", ".-.-");

// русский маленькие
        MORSE_MAP.put("а", ".-");
        MORSE_MAP.put("б", "-...");
        MORSE_MAP.put("в", ".--");
        MORSE_MAP.put("г", "--.");
        MORSE_MAP.put("д", "-..");
        MORSE_MAP.put("е", ".");
        MORSE_MAP.put("ё", ".");
        MORSE_MAP.put("ж", "...-");
        MORSE_MAP.put("з", "--..");
        MORSE_MAP.put("и", "..");
        MORSE_MAP.put("й", ".---");
        MORSE_MAP.put("к", "-.-");
        MORSE_MAP.put("л", ".-..");
        MORSE_MAP.put("м", "--");
        MORSE_MAP.put("н", "-.");
        MORSE_MAP.put("о", "---");
        MORSE_MAP.put("п", ".--.");
        MORSE_MAP.put("р", ".-.");
        MORSE_MAP.put("с", "...");
        MORSE_MAP.put("т", "-");
        MORSE_MAP.put("у", "..-");
        MORSE_MAP.put("ф", "..-.");
        MORSE_MAP.put("х", "....");
        MORSE_MAP.put("ц", "-.-.");
        MORSE_MAP.put("ч", "---.");
        MORSE_MAP.put("ш", "----");
        MORSE_MAP.put("щ", "--.-");
        MORSE_MAP.put("ъ", "--.--");
        MORSE_MAP.put("ы", "-.--");
        MORSE_MAP.put("ь", "-..-");
        MORSE_MAP.put("э", "..-..");
        MORSE_MAP.put("ю", "..--");
        MORSE_MAP.put("я", ".-.-");

// цифры и пробел
        MORSE_MAP.put(" ", " ");
        MORSE_MAP.put("0", "-----");
        MORSE_MAP.put("1", ".----");
        MORSE_MAP.put("2", "..---");
        MORSE_MAP.put("3", "...--");
        MORSE_MAP.put("4", "....-");
        MORSE_MAP.put("5", ".....");
        MORSE_MAP.put("6", "-....");
        MORSE_MAP.put("7", "--...");
        MORSE_MAP.put("8", "---..");
        MORSE_MAP.put("9", "----.");

        String result = "";

        String[] str_arr = str.split("");

        for(int i=0;i<str_arr.length;i++)
        {

//            if(str_arr[i] ==" ")
//            {
//                result+=" ";
//                continue;
//            }

            str_arr[i] = MORSE_MAP.get(str_arr[i]);

            result+=str_arr[i]+" ";
        }


        return result;
    }
}
