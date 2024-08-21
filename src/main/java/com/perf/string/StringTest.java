package com.perf.string;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class StringTest {

    private static final String A_VALUE = "abcde";

    @Benchmark
    public String testString() {
        String a = "";
        for (int loop = 0; loop < 10000; loop++) {
            a += A_VALUE;
        }
        return a;
    }

    @Benchmark
    public StringBuffer testStringBuffer() {
        StringBuffer b = new StringBuffer();
        for (int loop = 0; loop < 10000; loop++) {
            b.append(A_VALUE);
        }
        return b;
    }

    @Benchmark
    public StringBuilder testStringBuilder() {
        StringBuilder c = new StringBuilder();
        for (int loop = 0; loop < 10000; loop++) {
            c.append(A_VALUE);
        }
        return c;
    }
}