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
        if(list==null){
            return "";
        }
        int l=0;
        int r = list.size();

        while(l<r){
            int mid = l+(r-l)/2;
            if(timestamp < list.get(mid).timestamp){
                r = mid;
            }else{
                l=mid+1;
            }
        }

        return l==0?"":list.get(l-1).value;
    }
}
