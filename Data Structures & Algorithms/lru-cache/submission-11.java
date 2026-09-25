/*
To enable access order in a Java LinkedHashMap, you must use a specific 3-argument constructor and set the final boolean parameter (accessOrder) to true.By default, a LinkedHashMap maintains insertion order (the order keys were added). Turning on access order alters this behavior so that every time you read or modify an entry (using methods like get(), put(), or replace()), that entry is automatically moved to the tail (end) of the map's internal doubly-linked list.This behavior means the head of the map always holds the least recently used (LRU) entry, making it the perfect foundation for building an LRU Cache
*/
class LRUCache {
    //Final: get = O(1) average, put = O(1) average, space = O(capacity).
    private LinkedHashMap<Integer,Integer> map;
    private int capacity;
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity,0.75f,true){
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > LRUCache.this.capacity;
            }
        };
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        map.put(key,value);
    }
}
