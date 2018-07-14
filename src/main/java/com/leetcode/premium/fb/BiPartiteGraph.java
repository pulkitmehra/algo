package com.leetcode.premium.fb;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class BiPartiteGraph {
    int[][] graph = {
            {},
            {2, 4, 6},
            {1, 4, 8, 9},
            {7, 8},
            {1, 2, 8, 9},
            {6, 9},
            {1, 5, 7, 8, 9},
            {3, 6, 9},
            {2, 3, 4, 6, 9},
            {2, 4, 5, 6, 7, 8}
    };

    @Test
    public void bipartite(){
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0; i< graph.length; i++){
            if(!map.containsKey(i)){
                if(!isBipartite(graph, map, i)){
                    System.out.println("False");
                    break;
                }
            }
        }
        System.out.println("true");
    }

    public boolean isBipartite(int[][] graph,Map<Integer, Integer> map, int u) {

        if(graph==null || graph.length==0) return false;


        ArrayDeque<Integer> q=new ArrayDeque<>();
        q.offer(u);
        map.put(u,1);

        while(!q.isEmpty()){
            u = q.poll();
            int color = map.get(u);
            for(int v : graph[u]){
                if(!map.containsKey(v)){
                    q.offer(v);
                    map.put(v, color%2+1);
                }else if(map.get(v) != (color%2+1)){
                    return false;
                }
            }
        }
        return true;

    }
}
