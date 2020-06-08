package name.dengchao.leetcode.bytedance.arrayandsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() < 2) return intervals;
        intervals.sort(Comparator.comparingInt(v -> v.start));
        List<Interval> results = new ArrayList<>();
        Interval merged = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (hasIntersection(merged, curr)) {
                merged = new Interval(Math.min(merged.start, curr.start), Math.max(merged.end, curr.end));
            } else {
                results.add(merged);
                merged = curr;
            }
        }
        results.add(merged);
        return results;
    }

    private boolean hasIntersection(Interval var1, Interval var2) {
        return in(var1.start, var2) || in(var1.end, var2) || in(var2.start, var1) || in(var2.end, var1);
    }

    private boolean in(int val, Interval interval) {
        return val >= interval.start && val <= interval.end;
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        MergeIntervals test = new MergeIntervals();
        System.out.println(test.merge(intervals));
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}
