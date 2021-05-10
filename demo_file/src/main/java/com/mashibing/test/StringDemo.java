package com.mashibing.test;

/**
 * @author Thin'k'pa'd
 */
public final  class StringDemo implements java.io.Serializable, Comparable<String>, CharSequence{
    public char[] value;

    public StringDemo(char[] value) {
        this.value = value;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return null;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
