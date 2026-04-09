class T{
    String value;
    int timestamp;
    public T(String value,int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}
class TimeMap {
    private Map<String,List<T>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new T(value,timestamp));
    }
    
   public String get(String key, int timestamp) {
    List<T> list = map.get(key);
    if (list == null) return "";

    int l = 0;
    int r = list.size() - 1;
    String res = "";

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (list.get(mid).timestamp <= timestamp) {
            res = list.get(mid).value; // possible answer
            l = mid + 1;               // try to find better (right side)
        } else {
            r = mid - 1;               // discard right
        }
    }

    return res;
}
}
