package edu.macalester.comp124.stringtransformer;

public class IdentityTransformer extends StringTransformer {

    @Override
    public String transform(String s) {
        return s;
    }

    @Override
    public String toString() {
        return "--(unmodified)--";
    }

}
