package com.trzewik.algorithmic.exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();
        List<Interval> sortedIntervals = intervals.stream().sorted(Comparator.comparing(interval -> interval.start)).collect(Collectors.toList());
        Interval intervalToMerge = sortedIntervals.size() > 0 ? sortedIntervals.get(0) : null;
        for (int i = 0; i < sortedIntervals.size(); i++) {
            Interval currentInterval = sortedIntervals.get(i);
            Interval nextInterval = i + 1 < sortedIntervals.size() ? sortedIntervals.get(i + 1) : null;
            if (nextInterval != null) {
                if (intervalToMerge != null && intervalToMerge.end >= nextInterval.start) {
                    Interval nextSecInterval = i + 2 < sortedIntervals.size() ? sortedIntervals.get(i + 2) : null;
                    intervalToMerge.start = Math.min(intervalToMerge.start, nextInterval.start);
                    intervalToMerge.end = Math.max(intervalToMerge.end, nextInterval.end);
                    if (nextSecInterval == null || intervalToMerge.end < nextSecInterval.start) {
                        mergedIntervals.add(intervalToMerge);
                        intervalToMerge = nextSecInterval;
                        i++;
                    }
                } else {
                    intervalToMerge = nextInterval;
                    mergedIntervals.add(currentInterval);
                }
            } else {
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals;
    }

    public class Interval {
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
    }
}
