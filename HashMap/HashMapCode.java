package HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    public static class HashMap<K, V>{
        private class Node{
            K key;
            V value;

            Node(K key, V value){
                this.key = key ;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> buckets[];

//        @SuppressWarnings("unchecked")
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for(int i = 0; i < 4 ; i++){
                buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key){
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length;
        }
        private int searchInLL(int bi, K key){
            LinkedList<Node> ll = buckets[bi];

            for(int i = 0; i < ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return i;
                }

            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBuckets[] = buckets;
            buckets = new LinkedList[N*2];
            N *= 2;
            for (int i = 0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>();
            }
            for(int i = 0; i < oldBuckets.length; i++){
                LinkedList<Node> ll = oldBuckets[i];
                for (int j = 0; j < ll.size(); j++){
                    Node node = ll.remove();
                    put(node.key, node.value);
                }
            }

        }

        public void put(K key , V value){
            // 1. get Bucket Index
            // 2. get Data Index
            // 3. Update or Add the key value index
            // 4. check if rehashing is needed

            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(bucketIndex, key);

            if(dataIndex != -1){
                buckets[bucketIndex].get(dataIndex).value = value;
                return;
            }
            buckets[bucketIndex].add(new Node(key, value));
            n++;

            double lambda = (double)n/N;
            if(lambda > 2.0){ // 2.0 => threshold value
                rehash();
            }
        }

        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(bucketIndex, key);
            if (dataIndex != 1){
                return buckets[bucketIndex].get(dataIndex).value;
            }
            return null;
        }

        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(bucketIndex, key);
            return dataIndex != -1;
        }

        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchInLL(bucketIndex, key);
            if(dataIndex != 1){ // if node exists...
                Node node = buckets[bucketIndex].remove(dataIndex);
                n--;
                return node.value;
            }else
                return null;
        }
        public ArrayList<K> keySet(){
            ArrayList<K> arr = new ArrayList<>();

            for (int i = 0; i < buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for (int j = 0; j < ll.size(); j++ ){
                    arr.add(ll.get(j).key);
                }
            }
            return arr;
        }
        public boolean isEmpty(){
            return n==0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 50);
        hm.put("Nepal", 5);
        ArrayList<String> keys = hm.keySet();
        for (String key: keys
             ) {
            System.out.print(key + " ");
        }
        System.out.println();
        System.out.println(hm.remove("China"));
        System.out.println(hm.remove(("India")));
        System.out.println(hm.containsKey("India"));
    }
}

