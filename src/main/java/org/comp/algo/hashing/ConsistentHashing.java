package org.comp.algo.hashing;

import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class ConsistentHashing {

    private TreeMap<Long, Node> circle = new TreeMap<>();
    
    private TreeMap<Integer, Integer> circle2 = new TreeMap<>();
    
    @Test
    public void testTree() {
        circle2.put(1, 1);
        circle2.put(10, 10);
        circle2.put(20, 20);
        
        System.out.println(circle2.ceilingKey(2));
    }

    @Test
    public void main() {
        Node n1 = new Node("joseph");
        addNode(n1);
        Node n2 = new Node("tom");
        addNode(n2);
        Node n3 = new Node("sally");
        addNode(n3);
        Node n4 = new Node("harry");
        addNode(n4);
        
        Node node = getNode("assadsadasdsdsomeRandomString");
        
        System.out.println(node);
    }

    public void addNode(Node node) {
        Long nodeKey = md5(node.toString());
        circle.put(nodeKey, node);
    }

    public void removeNode(Node node) {
        Long nodeKey = md5(node.toString());
        circle.remove(nodeKey);
    }

    public Node getNode(String key) {
        Long keyMd5 = md5(key);
        Entry<Long, Node> higherEntry = circle.higherEntry(keyMd5);
        if (higherEntry == null) {
            return null;
        }
        System.out.println(key + "(" + keyMd5 + ") --->" + higherEntry.getValue() + "("
                + md5(higherEntry.getValue().toString()) + ")");
        return higherEntry.getValue();
    }

    private long md5(String key) {
        byte[] bKey = DigestUtils.md5(key.getBytes());
        long res = ((long) (bKey[3] & 0xFF) << 24) | ((long) (bKey[2] & 0xFF) << 16) | ((long) (bKey[1] & 0xFF) << 8)
                | bKey[0] & 0xFF;
        return res;
    }

    static class Node {
        private String name;

        public Node(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "The real node:" + name;
        }
    }

}


