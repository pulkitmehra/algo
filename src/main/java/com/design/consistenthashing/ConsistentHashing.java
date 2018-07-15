package com.design.consistenthashing;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConsistentHashing {

    private Function<String, Long> hashFunction;
    private SortedMap<Long, ServerNode> circle = new TreeMap<>();
    int replicas;

    public ConsistentHashing(Function<String, Long> hashFunction, int replicas, Collection<ServerNode> nodes) {
        this.hashFunction = hashFunction;
        this.replicas = replicas;
        for (ServerNode n : nodes) {
            add(n);
        }
    }

    public void add(ServerNode n) {
        for (int i = 0; i < replicas; i++) {
            circle.put(hashFunction.apply(n.getName()+i), n);
        }
    }
    //hashFunction.hashString(n.getName()+i,Charset.defaultCharset()

    public void remove(ServerNode n) {
        for (int i = 0; i < replicas; i++) {
            circle.remove(hashFunction.apply(n.getName()+i));
        }
    }

    public ServerNode getServerNode(String key){
        if(circle.isEmpty()){
            return null;
        }
        Long hashCode = hashFunction.apply(key);

        if(!circle.containsKey(hashCode)){
            SortedMap<Long, ServerNode> tailMap = circle.tailMap(hashCode);
            hashCode = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hashCode);
    }

    public static class ServerNode {

        String name;

        public ServerNode(String name){
            this.name =  name;
        }
        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "{"+ name +"}";
        }
    }

}
