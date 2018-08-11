package org.comp.java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Test;

public class MapTest {

    static class Account{}
    
    /*
     * 
     * List<ReferenceDataEntity<String>> entities =
                    // Sort the rows by entity name.
                    refDataRows.stream().collect(Collectors.groupingBy(ReferenceDataRow::getEntityName))
                            // Then convert it into an array of entities
                            .entrySet().stream()
                            .map(entry -> new ReferenceDataEntity<>(entry.getKey(),
                                    entry.getValue().stream()
                                            .collect(Collectors.toMap(ReferenceDataRow::getAttributeName,
                                                    ReferenceDataRow::getAttributeValue))))
                            .collect(Collectors.toList());
            entities.stream().sorted(Comparator.comparing(ReferenceDataEntity::getEntityName));

            category = new ReferenceDataCategory<>(refDataRows.get(0).getCategoryName(),
                    refDataRows.get(0).getCategoryVersion(), entities);
     * 
     */
    /*@Test
    public void test() {
        Map<String, List<Account>> map=new HashMap<>();
        
        map.entrySet().stream().sorted((e1, e2) -> e1.compareTo(e2)).collect(Collectors.toMap(Map.Entry::getKey, valueMapper));
    }*/
}

