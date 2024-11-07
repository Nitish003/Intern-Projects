import java.util.Scanner;
import java.util.concurrent.*;

public class MultiThreadedApplication {
    @SuppressWarnings("unused")
    private static final int NUM_THREADS = 5;
    @SuppressWarnings("unused")
    private static final int NUM_ITERATIONS = 10;

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of threads: ");
            int numThreads = sc.nextInt();
            sc.nextLine(); 

            System.out.print("Enter the number of iterations: ");
            int numIterations = sc.nextInt();
            sc.nextLine(); 

            ExecutorService executor = Executors.newFixedThreadPool(numThreads);

            for (int i = 0; i < numThreads; i++) {
                executor.submit(new Worker(numIterations));
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }

        System.out.println("Final counter value: " + counter);
    }

    private static class Worker implements Runnable {
        private static final Object lock = new Object();
        private int numIterations;

        public Worker(int numIterations) {
            this.numIterations = numIterations;
        }

        @Override
        public void run() {
            for (int i = 0; i < numIterations; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        }
    }
}