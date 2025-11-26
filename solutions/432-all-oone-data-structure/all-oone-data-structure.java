class AllOne {

    private static class CountNode{
        int count;
        Set<String> keys;
        CountNode prev;
        CountNode next; 

        CountNode(int count){
            this.count = count;
            this.keys = new HashSet();
        }
    }

    private CountNode head;
    private CountNode tail;

    private Map<String, CountNode> keyNode;

    public AllOne() {
        head = new CountNode(Integer.MIN_VALUE);
        tail = new CountNode(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        keyNode = new HashMap();
    }
    
    public void inc(String key) {
        if(!keyNode.containsKey(key)){
            CountNode next = head.next;
            if(next != tail && next.count == 1){
                next.keys.add(key);
                keyNode.put(key, next);
            }else{
                CountNode node = new CountNode(1);
                node.keys.add(key);
                insertAfter(head, node);
                keyNode.put(key, node);
            }
        }else{
            CountNode cur = keyNode.get(key);
            CountNode next = cur.next;
            if(next != tail && next.count == cur.count +1){
                next.keys.add(key);
                keyNode.put(key, next);
            }else{
                CountNode node = new CountNode(cur.count + 1);
                node.keys.add(key);
                insertAfter(cur, node);
                keyNode.put(key, node);
            }
            cur.keys.remove(key);
            if(cur.keys.isEmpty()){
                removeNode(cur);
            }
        }
    }

    private void insertAfter(CountNode prevNode, CountNode newNode){
        CountNode nextNode = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    private void removeNode(CountNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    
    public void dec(String key) {
        CountNode cur = keyNode.get(key);
        if(cur == null) return;
        if(cur.count == 1){
            cur.keys.remove(key);
            keyNode.remove(key);
            if(cur.keys.isEmpty()){
                removeNode(cur);
            }
        }else{
            CountNode prev = cur.prev;
            if(prev != head && prev.count == cur.count -1){
                prev.keys.add(key);
                keyNode.put(key, prev);
            }else{
                CountNode node = new CountNode(cur.count -1);
                node.keys.add(key);
                insertAfter(cur.prev, node);
                keyNode.put(key, node);

            }
            cur.keys.remove(key);
            if(cur.keys.isEmpty()){
                removeNode(cur);
            }
            
        }
    }
    
    public String getMaxKey() {
        if(tail.prev == head) return "";
        Iterator<String> it = tail.prev.keys.iterator();
        return it.hasNext() ? it.next() : "";
    }
    
    public String getMinKey() {
        if(head.next == tail) return "";
        Iterator<String> it = head.next.keys.iterator();
        return it.hasNext() ? it.next() : "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */