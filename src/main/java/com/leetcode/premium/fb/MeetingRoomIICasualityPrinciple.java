package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MeetingRoomIICasualityPrinciple {
/*

    To understand why it works, first let’s define two events:
    Meeting Starts
    Meeting Ends

    Next, we acknowledge three facts:
    The numbers of the intervals give chronological orders
    When an ending event occurs, there must be a starting event has happened before that, where “happen before” is
    defined by the chronological orders given by the intervals
    Meetings that started which haven’t ended yet have to be put into different meeting rooms, and the number
    of rooms needed is the number of such meetings

    So, what this algorithm works as follows:

    for example, we have meetings that span along time as follows:

    |_____|
          |______|
    |________|
            |_______|
    Then, the start time array and end time array after sorting appear like follows:

    ||    ||
         |   |   |  |
    Initially, endsItr points to the first end event, and we move i which is the start event pointer. As we examine
    the start events, we’ll find the first two start events happen before the end event that endsItr points to,
     so we need two rooms (we magically created two rooms), as shown by the variable rooms.

    Then, as i points to the third start event, we’ll find that this event happens after the end event pointed by endsItr,
    then we increment endsItr so that it points to the next end event.
    What happens here can be thought of as one of the two previous meetings ended,
    and we moved the newly started meeting into that vacant room, thus we don’t need to increment rooms at this time
    and move both of the pointers forward.
    Next, because endsItr moves to the next end event, we’ll find that the start event pointed by i
    happens before the end event pointed by endsItr. Thus, now we have 4 meetings started but only one ended,
    so we need one more room. And it goes on as this.
*/


    int[][] intervals = {
            {1,3}, {2,3},{3,5},{5,6},
            {4,7},{8,9},{8,10}
    };

    @Test
    public void maxRooms(){
        System.out.println(minMeetingRooms2(intervals));
    }

    public int minMeetingRooms2(int[][] intervals){

        List<Point> pts = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++){
            pts.add(Point.get(intervals[i][0], true));
            pts.add(Point.get(intervals[i][1], false));
        }

        Collections.sort(pts, (a, b)->{
            if(a.pt != b.pt){
                return Integer.compare(a.pt, b.pt);
            }
            return a.isStart && !b.isStart ? -1 : !a.isStart && b.isStart ? 1 : 0;
        });
        //System.out.println(pts);

        int maxRooms = 0;

        int i =0;
        for (Point pt : pts) {
            if(pt.isStart){
                i++;
                maxRooms = Math.max(maxRooms, i);
            }else if(i!=0){
                i--;
            }
        }
        return maxRooms;
    }

    public int minMeetingRooms1(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }


    public static class Interval {
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

    public static class Point {
        int pt;
        boolean isStart;

        static Point get(int pt, boolean isStart){
            Point p =new Point();
            p.pt = pt;
            p.isStart=isStart;
            return p;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "pt=" + pt +
                    ", isStart=" + isStart +
                    '}';
        }
    }

}
