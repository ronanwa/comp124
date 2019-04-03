package edu.macalester.comp124.stringtransformer;

public class Yeller extends StringTransformer {

    @Override
    public String transform(String s) {
        return s.toUpperCase();
     }
    
    @Override
    public String toString() {
        return "All capitalized";
    }
}
