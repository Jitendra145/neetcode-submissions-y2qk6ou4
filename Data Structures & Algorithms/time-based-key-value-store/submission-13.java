class T{
    String key;
    int timestamp;

    T(String key,int t){
        this.key= key;
        this.timestamp = t;
    }
}
class TimeMap {
    Map<String,List<T>> cache;
    public TimeMap() {
        cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        cache.putIfAbsent(key,new ArrayList<>());
        cache.get(key).add(new T(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<T> node = cache.get(key);
        if(node==null || cache.isEmpty()){
            return "";
        }
        int l=0,r=node.size()-1;
        String res = "";
        while(l<=r){
            int mid = l+(r-l)/2;
            if(node.get(mid).timestamp <= timestamp){                
                res = node.get(mid).key;
                l= mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}
