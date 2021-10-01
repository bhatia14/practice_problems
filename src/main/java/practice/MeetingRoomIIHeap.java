package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomIIHeap {

    private static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        List<Interval> intervalList = Arrays.asList(
                new Interval(0, 30),
                new Interval(5, 10),
                new Interval(15, 20));
        minMeetingRooms(intervalList);

    }

    private static int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        intervals.sort(Comparator.comparing(interval -> interval.start));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        intervals.forEach(interval -> {
            if (priorityQueue.size() > 0) {
                int x = priorityQueue.poll();
                if (x > interval.start) {
                    priorityQueue.add(x);
                }
            }
            priorityQueue.add(interval.end);
        });

        return priorityQueue.size();
    }
}
