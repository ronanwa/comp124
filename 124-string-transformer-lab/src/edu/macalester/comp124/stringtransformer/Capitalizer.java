package edu.macalester.comp124.stringtransformer;

public class Capitalizer extends StringTransformer {

    @Override
    public String transform(String s) {
        String output;
        if (s=="")
            output=s;
        else
            output = s.substring(0,1).toUpperCase()+s.substring(1);
        return output;
    }
    @Override
    public String toString() {
        return "First letter of each word is capitalized";
    }
}
