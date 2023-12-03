package se.distansakademin;

import java.util.stream.*;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Function<String, Stream<Character>> toCharStream = s -> s.chars().mapToObj(c -> (char) c);
        BiFunction<Stream<Character>, Integer, Stream<Character>> rotN =
                (stream, n) -> stream.map(c -> (char) ((c >= 'a' && c <= 'z') ? (c - 'a' + n) % 26 + 'a' : c));


        String[] messages = {"Guvf vf n grfg.", "Cebtenzzvat va Wnin vf sha!"};
        int shift = -13;

        Stream.of(messages)
                .map(toCharStream)
                .map(stream -> rotN.apply(stream, shift))
                .map(stream -> stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString())
                .forEach(System.out::println);
    }
}

