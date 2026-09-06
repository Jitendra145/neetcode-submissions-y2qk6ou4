class KthLargest {
    private List<Integer> list;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }    
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        return list.get(list.size()-k);
    }
}
