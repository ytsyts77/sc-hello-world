package com.samsungcard.helloworld.global.utils;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamUtil {
    public static <T> Stream<T> asStream(Iterable<T> i) {
        return asStream(i.iterator(), false);
    }
    public static <T> Stream<T> asStream(Iterator<T> i) {
        return asStream(i, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> i, boolean parallel) {
        Iterable<T> iterable = () -> i;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }
}
