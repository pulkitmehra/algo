package org.comp.algo.hashing;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;

public class MapsAPI {

    @Test
    public void freqMap() {
        List<String> lst = Arrays.asList("test", "me", "back");
        Map<Character, Long> freqMap = lst.stream().map(e -> e.chars()).flatMap(s -> s.mapToObj(i -> (char) i))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
    }

}


