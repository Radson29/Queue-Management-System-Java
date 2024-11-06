package Project;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CustomQueue<T> {
    private final Deque<T> queue;
    private final Deque<T> queueVip;
    private final Map<String, Integer> counterMap = new HashMap<>();

    public CustomQueue(Deque<T> queue, Deque<T> queueVip) {
        this.queue = queue;
        this.queueVip = queueVip;
    }

    public void welcomeVip(T item) {
        boolean isAdded = queueVip.offer(item);
        System.out.printf("%s came to the vip queue: %s%n", item, isAdded);
        printTotalQueue();
    }

    public void welcome(T item) {
        boolean isAdded = queue.offer(item);
        System.out.printf("%s came to the queue: %s%n", item, isAdded);
        printTotalQueue();
    }

    public Integer getAndIncrementCounter(String key) {
        Integer tempCounter = counterMap.getOrDefault(key, 0);
        counterMap.put(key, ++tempCounter);
        return tempCounter;
    }

    public void enter() {
        if (queueVip.isEmpty()) {
            System.out.println("No items in the VIP queue.");
        } else {
            handleEnterByQueue(queueVip);
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("No items in the queue.");
            System.out.println();
            return;
        }
        handleEnterByQueue(queue);
    }

    private void handleEnterByQueue(Deque<T> queue) {
        T itemEntered = queue.poll();
        System.out.printf("Processing queue: %s arrived at the store.%n", itemEntered);
        printTotalQueue();
    }

    public void leave(T item) {
        if (queueVip.contains(item)) {
            queueVip.remove(item);
            System.out.printf("Leaving vip queue: %s%n", item);
            printTotalQueue();
        } else if (queue.contains(item)) {
            queue.remove(item);
            System.out.printf("Leaving queue: %s%n", item);
            printTotalQueue();
        } else {
            System.out.println(item + " currently is not in the queue.\n");
        }
    }

    private void printTotalQueue() {
        ArrayList<T> totalList = new ArrayList<>(queueVip);
        totalList.addAll(queue);
        System.out.println(totalList);
        System.out.println();
    }
}
