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


---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


class LRUCache {
    private Map<Integer, ListNode> hashTable = new HashMap<>();
    
    ListNode head;
    ListNode tail;
    
    int capacity;
    int totalItemsInCache;
    
    public LRUCache(int capacity) {
       this.capacity = capacity;
       totalItemsInCache = 0; 
        
        head = new ListNode();
        tail = new ListNode();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public class ListNode{
        int key;
        int value;
        
        ListNode prev;
        ListNode next;
    }
    
    public int get(int key) {
        ListNode node = hashTable.get(key);
        
        if(node == null) return -1;
        
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        ListNode node = hashTable.get(key);
        
        if(node == null){
            ListNode newNode = new ListNode();
            newNode.value = value;
            newNode.key = key;
            
            hashTable.put(key, newNode);
            addToFront(newNode);
            totalItemsInCache++;
            
            if(totalItemsInCache > capacity) removeLRUEntry();
        } else{
            node.value = value;
            moveToHead(node);
        }
    }
    
    private void removeLRUEntry(){
        ListNode tailItem = tail.prev;
        removeFromList(tailItem);
        
        hashTable.remove(tailItem.key);
        --totalItemsInCache;
    }
    
    private void removeFromList(ListNode node) {
        ListNode savedPrev = node.prev;
        ListNode savedNext = node.next;

        savedPrev.next = savedNext;
        savedNext.prev = savedPrev;
    }
    
    private void moveToHead(ListNode node) {
        removeFromList(node);
        addToFront(node);
    }
    
    private void addToFront(ListNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }
}
