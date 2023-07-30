import java.util.*;

public class LFUCache {
    private int capacity;
    private Map<Integer, Integer> keyToValueMap;                     // HashMap to store key-value pairs
    private Map<Integer, Integer> keyToFrequencyMap;                 // HashMap to store key-frequency pairs
    private Map<Integer, LinkedHashSet<Integer>> frequencyToKeysMap; // HashMap to store frequency-LinkedHashSet pairs
    private int minFrequency;                                       // Variable to keep track of the minimum frequency

    public LFUCache(int capacity) {
        this.capacity = capacity;
        keyToValueMap = new HashMap<>();
        keyToFrequencyMap = new HashMap<>();
        frequencyToKeysMap = new HashMap<>();
        minFrequency = 0;
    }

    public int get(int key) {
        if (!keyToValueMap.containsKey(key)) {
            return -1; // Key not found
        }

        // Increment the frequency of the accessed key and move it to the appropriate LinkedHashSet
        int frequency = keyToFrequencyMap.get(key);
        keyToFrequencyMap.put(key, frequency + 1);
        frequencyToKeysMap.get(frequency).remove(key);

        if (frequencyToKeysMap.get(frequency).isEmpty()) {
            // If the previous frequency list becomes empty, update minFrequency
            frequencyToKeysMap.remove(frequency);
            if (minFrequency == frequency) {
                minFrequency++;
            }
        }

        frequencyToKeysMap.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);
        return keyToValueMap.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return; // Edge case: If capacity is zero or negative, do nothing
        }

        if (keyToValueMap.containsKey(key)) {
            // Update the existing key's value and call get to increase its frequency
            keyToValueMap.put(key, value);
            get(key);
            return;
        }

        if (keyToValueMap.size() >= capacity) {
            // Evict the least frequently used item from the cache to accommodate the new item
            LinkedHashSet<Integer> keysWithMinFrequency = frequencyToKeysMap.get(minFrequency);
            int keyToRemove = keysWithMinFrequency.iterator().next();
            keysWithMinFrequency.remove(keyToRemove);
            keyToValueMap.remove(keyToRemove);
            keyToFrequencyMap.remove(keyToRemove);
        }

        // Add the new key-value pair to the cache with frequency 1
        keyToValueMap.put(key, value);
        keyToFrequencyMap.put(key, 1);
        frequencyToKeysMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1; // Reset minFrequency to 1 since a new item is added
    }
}
