class LRUCache {
    
    private int capacity;
    private HashMap<Integer, Integer> map;
    
    public LRUCache(int capacity) {
       this.capacity = capacity;
       map = new LinkedHashMap();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
           int value = map.get(key); 
           map.remove(key);
           map.put(key, value);
           return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key, value);
        } else if(map.size() < capacity){
            map.put(key, value);
        } else{
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> entry = iterator.next();
            int stale_key = entry.getKey();
            map.remove(stale_key);
            map.put(key, value);
        }
    }
}
