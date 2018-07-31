package com.algo.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MergeIntervalSortedArray {



	
	public void awesomeSolutionButPerformance() {
		List<Interval> intervals = null; //input
		Interval newIn = null; //input;
		
		
		int i = 0;
		while(i < intervals.size() && intervals.get(i).start < newIn.start) {
			i++;
		}
		//bad solution because we are shifting the whole array
		intervals.add(i, newIn);
		Interval last =  null;
		List<Interval> l = new ArrayList<>();
		for(int j = 0; i<intervals.size(); j++) {
			if(last == null || intervals.get(j).start > last.end ) {
				last = intervals.get(j);
				l.add(last);
			}else {
				last.end = Math.max(last.end, intervals.get(j).end);
			}
		}		
	}
	
	public static class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
		 }
	
	class Solution {
	    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        int size = intervals.size();
	        for(int i=0; i<size; i++){
	            if(newInterval.start < intervals.get(i).start){
	                intervals.add(i, newInterval);
	                break;
	            }else if(newInterval.start == intervals.get(i).start){
	                if(newInterval.end < intervals.get(i).end){
	                    intervals.add(i, newInterval);
	                }else{
	                    intervals.add(i+1, newInterval);
	                }
	            }
	        }
	        if(size == intervals.size()){
	            intervals.add(newInterval);
	        }
	        
	        ListIterator<Interval> it = intervals.listIterator();
	        Interval p = it.next();
	        while(it.hasNext() && it.hasPrevious()){
	            
	           Interval c = peek(it);
	           if(!noOverlap(p,c)){
	               int r = p.start < c.start ? p.start : c.start;
	               int l = p.end  > c.end ? p.end : c.end;
	               c.start = r;
	               c.end = l;
	               it.previous();
	               it.remove();
	           } 
	           p = c;
	           it.next();
	        }
	        return intervals;
	    }
	    
	    private Interval peek(ListIterator<Interval> it){
	        Interval v = it.next();
	        it.previous();
	        return v;
	    }
	    
	    private boolean noOverlap(Interval p, Interval c){
	        return p.start < c.start && p.end < c.start;
	    }
	    
	    
	}

}
