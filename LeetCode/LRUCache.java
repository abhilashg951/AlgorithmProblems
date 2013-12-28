/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, 
 *            otherwise return -1.
 *
 * set(key, value) - Set or insert the value if the key is not already present. 
 *                   When the cache reached its capacity, it should 
 *                   invalidate the least recently used item before inserting a new item.
 */

import java.util.*;

public class LRUCache {
    
    private Map<Integer, Integer> items = new LinkedHashMap<Integer, Integer>();
    private int maxCapacity;

    public LRUCache(int capacity) {
        maxCapacity = capacity;
    }
    
    public int get(int key) {
        int value = -1;
        if (items.containsKey(key)) {
            value = items.get(key);
            items.remove(key);
            items.put(key, value);
        }
        return value;
    }
    
    public void set(int key, int value) {
        items.remove(key);
        items.put(key, value);
        
        while (items.size() > maxCapacity) {
            // Remove LRU
            items.remove(items.entrySet().iterator().next().getKey());
        }
    }
}
