package osl2.datastructures;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import osl2.Evanston;
import osl2.datastructures.nodey.VGraphNode;

public class LoadTest {
    private final static int NUMBER_OF_ITERATIONS_STARTUP_TEST = 15;
    private final static double MINIMAL_PERCENTAGE_GUARANTY = 0.95;
    private final static int NUMBER_OF_SECONDS_STARTUP_TEST = 15;

    public static void main(String[] args) throws InterruptedException {
        Evanston.startForTest(0);

        for(int i = 0; i < 5; i++) {
            System.out.println("huge connected graph test: " + firstLoadTest());
            System.out.println("linked list with graphs in it test: " + secondLoadTest());
            System.out.println("singly linked list with a lot of elements: " + thirdLoadTest());
            System.out.println("recursive load test: " + lastLoadTest());
        }

        System.out.println("Startup time test: " + testStartingTimeOfApplication(NUMBER_OF_ITERATIONS_STARTUP_TEST));
    }

    public static boolean testStartingTimeOfApplication(int numberOfIterations) throws InterruptedException {
        long[] resultsForEachIteration = new long[numberOfIterations];

        for(int i = 0; i < numberOfIterations; i++) {
            Instant start = Instant.now();
            Evanston.start();
            Instant end = Instant.now();
            resultsForEachIteration[i] = Duration.between(start, end).getNano();
            Evanston.closeVisualization();
        }

        long minimum = (int) Math.ceil(MINIMAL_PERCENTAGE_GUARANTY * numberOfIterations);

        for(long result: resultsForEachIteration) {
            if(result <= NUMBER_OF_SECONDS_STARTUP_TEST) {
                minimum--;
            }
        }

        if(minimum == 0) {
           return true;
        }
        return false;
    }

    public static long firstLoadTest() {
        VDirectedGraph<Integer> graph = new VDirectedGraph<>();
        int numberOfGraphElements = 60;

        Instant start = Instant.now();

        for(int i = 0; i < numberOfGraphElements; i++) {
            VGraphNode node = graph.addNode(i);
            VGraphNode node2 = graph.addNode(i + 1);

            node.connect(node2);
            node2.connect(node);
        }

        Instant end = Instant.now();
        return Duration.between(start, end).getNano();
    }

    public static long secondLoadTest() {
        VDirectedGraph<Integer> graph = new VDirectedGraph<>();
        VGraphNode node = graph.addNode(1);
        VGraphNode node2 = graph.addNode(2);

        node.connect(node2);
        node2.connect(node);

        List list = new VSinglyLinkedList<VGraph>();

        int numberOfListElements = 40;

        Instant start = Instant.now();

        for(int i = 0; i < numberOfListElements; i++) {
            list.add(graph);
        }
        Instant end = Instant.now();
        return Duration.between(start, end).getNano();
    }

    public static long thirdLoadTest() {
        List list = new VSinglyLinkedList<Integer>();
        int numberOfListElements = 1000;

        Instant start = Instant.now();
        for(int i = 0; i < numberOfListElements; i++) {
            list.add(1000);
        }
        Instant end = Instant.now();
        return Duration.between(start, end).getNano();
    }

    public static long lastLoadTest() {
        int numberOfRecursions = 4;

        List list = new VSinglyLinkedList<VGraph>();
        int numberOfListElements = 10;

        Instant start = Instant.now();

        for(int i = 0; i < numberOfListElements; i++) {
            for(int j = 0; j < numberOfRecursions; j++) {
                List list1 = new VSinglyLinkedList<Integer>();
                list.add(0);
                list.add(list1);
            }
        }
        Instant end = Instant.now();
        return Duration.between(start, end).getNano();
    }
}
