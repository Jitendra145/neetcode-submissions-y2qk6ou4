class LRUCache {
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
