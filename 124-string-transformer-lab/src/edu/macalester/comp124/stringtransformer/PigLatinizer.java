package edu.macalester.comp124.stringtransformer;

public class PigLatinizer extends StringTransformer{

    @Override
    public String transform(String s) {
        boolean vowels=false;

        // Handles empty strings
        if (s.equals("")) {
            return s;
        }

        // Checks for vowels
        for (int i=0; i<s.length(); i++) {
            if (s.substring(i,i+1).equals("a") || s.substring(i,i+1).equals("e") || s.substring(i,i+1).equals("i") || s.substring(i,i+1).equals("o") || s.substring(i,i+1).equals("u")){
                vowels = true;
                break;
            }
        }

        // If the word has no vowels (other than y) -- e.g., my, thy -- append yay to it -- i.e., myyay, thyyay.
        if (!vowels){
            return s+"yay";
        }

        // If the word begins with a vowel -- e.g., am, are, i -- append yay to the word -- i.e., amyay, areyay, iyay.
        else if (s.substring(0,1).equals("a") || s.substring(0,1).equals("e") || s.substring(0,1).equals("i") || s.substring(0,1).equals("o") || s.substring(0,1).equals("u")){
            return s+"yay";
        }

        // If the word begins with a consonant -- e.g., string, latin -- divide the word at the first vowel, swapping the front and back halves and append ay to the word -- i.e., ingstray, atinlay.
        else if (!s.substring(0,1).equals("a") || !s.substring(0,1).equals("e") || !s.substring(0,1).equals("i") || !s.substring(0,1).equals("o") || !s.substring(0,1).equals("u")) {
            int index=0;
            // Finds the separation point in the word
            for (int i = 0; i < s.length(); i++) {
                if (s.substring(i,i+1).equals("a") || s.substring(i,i+1).equals("e") || s.substring(i,i+1).equals("i") || s.substring(i,i+1).equals("o") || s.substring(i,i+1).equals("u")) {
                    index = i;
                    break;
                }
            }
            // Arranges word
            return s.substring(index)+s.substring(0,index)+"ay";
        }

        // If the program reaches this else statement, there is an error
        else {
            return "Error";
        }
    }

    @Override
    public String toString() {
        return "Pig Latin Translation";
    }

}
