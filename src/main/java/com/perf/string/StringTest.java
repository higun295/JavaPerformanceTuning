package com.perf.string;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.StackProfiler;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Fork(value = 1)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
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
