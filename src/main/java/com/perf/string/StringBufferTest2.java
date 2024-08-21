package com.perf.string;

public class StringBufferTest2 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("ABCDE");
        sb.append("FGHIJ");
        sb.append("KLMNO");

        sb.append("ABCDE")
        .append("FGHIJ")
        .append("KLMNO");

        sb.append("ABCDE" + " = " + "FGHIJ");
        sb.insert(99, "123");
        System.out.println(sb);
    }
}