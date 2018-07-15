package com.design.consistenthashing;

import com.ds.HashFunctions;
import com.google.common.hash.Hashing;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

public class ConsistentHashingTest {

    @Test
    public void consistentHashTest() {
        List<ConsistentHashing.ServerNode> nodes = Arrays.asList(new ConsistentHashing.ServerNode("sam"),
                new ConsistentHashing.ServerNode("tom"),
                new ConsistentHashing.ServerNode("harry"));

        ConsistentHashing partitioner = new ConsistentHashing(
                (key) -> Hashing.md5().hashString(key, Charset.defaultCharset()).asLong(),
                4,
                nodes);

        System.out.println(partitioner.getServerNode("for some random"));

        System.out.println(partitioner.getServerNode("sdasdsd dasDSDD for some random"));

        System.out.println(partitioner.getServerNode("for some randomSDSDS FASDFASF"));
    }

    @Test
    public void consistentHashTestCustomFunction() {
        List<ConsistentHashing.ServerNode> nodes = Arrays.asList(new ConsistentHashing.ServerNode("sam"),
                new ConsistentHashing.ServerNode("tom"),
                new ConsistentHashing.ServerNode("harry"));

        ConsistentHashing partitioner = new ConsistentHashing(
                (key) -> HashFunctions.md5To64Bit(key),
                4,
                nodes);

        System.out.println(partitioner.getServerNode("for some random"));

        System.out.println(partitioner.getServerNode("sdasdsd dasDSDD for some random"));

        System.out.println(partitioner.getServerNode("for some randomSDSDS FASDFASF"));
    }
}
