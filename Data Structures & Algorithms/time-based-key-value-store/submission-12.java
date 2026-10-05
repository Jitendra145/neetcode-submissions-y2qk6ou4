class T{
    String value;
    int timestamp;
    public T(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    Map<String,List<T>> cache;
    public TimeMap() {
        this.cache = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        cache.putIfAbsent(key,new ArrayList<>());
        cache.get(key).add(new T(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<T> list = cache.get(key);
        if(list==null || list.isEmpty()){
            return "";
        }
        int l=0, r=list.size()-1;
        String res="";
        while(l<=r){
            int mid = (l+r)/2;
            if(list.get(mid).timestamp <= timestamp){
                res = list.get(mid).value;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return res;
    }
}
