package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MeetingRooms2 {
    public static void main(String[] args) {
        Interval i1 = new Interval(0,30);
        Interval i2 = new Interval(5,10);
        Interval i3 = new Interval(15,20);
        Interval i4 = new Interval(5,8);
        Interval i5 = new Interval(6,8);
        Interval i6 = new Interval(4,16);
        Interval i7 = new Interval(5,17);
        Interval i8 = new Interval(4,17);
        Interval i9 = new Interval(12,17);
        List<Interval> list = Arrays.asList(i6, i7, i8);
        System.out.println(minMeetingRooms(list));
    }

    private static int minMeetingRooms(List<Interval> intervals) {
        // Write your code here

        intervals = intervals.stream().sorted(Comparator.comparing(interval -> interval.start)).collect(Collectors.toList());
        int counter = 1;
        if(intervals.size() > 2) {
            for (int j = 0; j < intervals.size()-1; j++) {
                for (int i = j + 1; i < intervals.size(); i++) {
                    if (intervals.get(i).start - intervals.get(j).end < 0) {
                        intervals.remove(j);
                        counter++;
                    }
                }
            }
        }
        if(intervals.size() == 2){
            if (intervals.get(intervals.size()-1).start - intervals.get(intervals.size()-2).end < 0) {
                counter++;
            }
        }
        return counter;
    }

    private static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
}
