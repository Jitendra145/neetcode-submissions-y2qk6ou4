class Node{
    int key;
    int value;
    long expiryTime;
    Node next;
    Node prev;
    public Node(int key, int value,long expiryTime){
        this.key = key;
        this.value = value;
        this.expiryTime = expiryTime;
    }
}
class LRUCache {
    Map<Integer,Node> cache;
    final long ttlinMillis;
    int capacity;
    Node left;
    Node right;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0,0,0);
        this.right = new Node(0,0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
        this.ttlinMillis = 10l;
    }
    
    public void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    public void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }
    public boolean isExpired(Node node){
        return System.currentTimeMillis() > node.expiryTime;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            if(isExpired(node)){
                cache.remove(key);
                remove(node);
                return -1;
            }
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        long tt = System.currentTimeMillis()+ttlinMillis;
        Node nNode = new Node(key,value,tt);
        cache.put(key,nNode);
        insert(nNode);
        if(cache.size() > capacity){
            Node ttl = this.left.next;
            cache.remove(ttl.key);
            remove(ttl);
        }
    }
}
