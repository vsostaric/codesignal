package snippets;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class ForEachTry {

    public static void main(String[] args) {

        final Set<Integer> forEach = new HashSet<>();
        final Set<Integer> forEachStream = new HashSet<>();
        final Set<Integer> forEachParallel = new HashSet<>();

        final List<Integer> integers = new ArrayList<>();
        IntStream.range(0,50000).forEach(integers::add);

        for(int i = 0; i<50; i++) {
            Instant time = Instant.now();
            integers.forEach(System.out::println);
            int forEachTook = Instant.now().minusNanos(time.getNano()).getNano();
            forEach.add(forEachTook);

            time = Instant.now();
            integers.stream().forEach(System.out::println);
            int forEachStreamTook = Instant.now().minusNanos(time.getNano()).getNano();
            forEachStream.add(forEachStreamTook);

            time = Instant.now();
            integers.parallelStream().forEach(System.out::println);
            int forEachParallelStreamTook = Instant.now().minusNanos(time.getNano()).getNano();
            forEachParallel.add(forEachParallelStreamTook);

        }

        int a = forEach.stream().mapToInt(x -> x).sum() / forEach.size();

        System.out.println("For Each: " + forEach.stream().mapToInt(x -> x).sum() / ((float)forEach.size()) + " ns");
        System.out.println("For Each Stream: " + forEachStream.stream().mapToInt(x -> x).sum() / ((float)forEachStream.size()) + " ns");
        System.out.println("For Each Parallel Stream: " + forEachParallel.stream().mapToInt(x -> x).sum() / ((float)forEachParallel.size()) + " ns");

    }

}
