import java.util.*;


public class Test {
    public static void main(String[] args) {
        System.out.println("test");
        //---------------------------------------------------------ARRAYLIST
        System.out.println("ArrayList : ------------------- |");

        ArrayList arrayList1 = new ArrayList(); // bad practice (but can save any type)
        ArrayList<String> arraylist2 = new ArrayList<>(); // wrapper class name inside generic <>

        // Add
        arrayList1.add(0);
        arrayList1.add("one");

        arraylist2.add("zero");
        arraylist2.add("one");

        // Show
        for (Object obj : arrayList1) { System.out.print(obj + " , "); }
        System.out.println();

        for (String s : arraylist2) {
            // Update
            if (s.equals("one")) s = "two"; // editing 'one' index to 'two'

            System.out.println(s);
        }

        // Remove
        arrayList1.remove(0);
        arraylist2.remove("two");

        // Update existing element (update the first element)
        if (!arraylist2.isEmpty()) {
            arraylist2.set(0, "updated zero");
        }
        System.out.println("Updated ArrayList: " + arraylist2);


        //---------------------------------------------------------LINKEDLIST
        System.out.println("\n" + "LinkedList : ------------------- |");

        LinkedList<String> linkedList = new LinkedList<>();

        // Add
        linkedList.add("zero"); // default index 0
        linkedList.add(0, "one"); // sets on index 0 (shifts the prev index)

        // Show
        System.out.println("Index 0 = " + linkedList.get(0));
        System.out.println("Index 1 = " + linkedList.get(1));

        // Update
        linkedList.set(1, "updated zero");
        System.out.println("Updated Index 1: " + linkedList.get(1));

        // Remove
        linkedList.remove(0);
        System.out.println("After removal: " + linkedList);


        //---------------------------------------------------------HASHSET
        /* No Duplicates, Unordered, Fast */

        System.out.println("\n" + "HashSet : ------------------- |");

        HashSet<String> hashSet = new HashSet<>();

        // Add
        hashSet.add("one");
        hashSet.add("two"); // add a new element

        // Show
        for (String x : hashSet){
            System.out.println(x);
        }

        // Update
        if (hashSet.contains("one")) {
            hashSet.remove("one");
            hashSet.add("updated one");
        }
        System.out.println("Updated HashSet: " + hashSet);

        // Remove
        hashSet.remove("two");
        System.out.println("After removal: " + hashSet);


        //---------------------------------------------------------TREESET
        /* No Duplicates, Ordered (ASC), Slower than hashset */

        System.out.println("\n" + "TreeSet : ------------------- |");

        TreeSet<Integer> treeSet = new TreeSet<>();

        // Add
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(8);
        treeSet.add(3);  // automatically sorted

        // Show
        System.out.println(treeSet.higher(5));
        System.out.println(treeSet.lower(3));

        for (Integer i : treeSet){
            System.out.print(i + " ");
        }

        System.out.println();

        // Update (remove and re-add)
        if (treeSet.contains(3)) {
            treeSet.remove(3);
            treeSet.add(4);
        }
        System.out.println("Updated TreeSet: " + treeSet);

        // Remove
        treeSet.remove(8);
        System.out.println("After removal: " + treeSet);


        //---------------------------------------------------------HASHMAP
        /* key (unique) -> value  , unordered, */

        System.out.println("\n" + "HashMap : ------------------- |");

        HashMap<String, Integer> hashMap = new HashMap<>();

        // Add
        hashMap.put("Apple", 10);
        hashMap.put("Banana", 20);
        hashMap.put("Orange", 30);

        // Show
        for (String key : hashMap.keySet()) {
            System.out.println(key + " -> " + hashMap.get(key));
        }

        // Update
        hashMap.put("Apple", 15); // updating value for key "Apple"
        System.out.println("Updated HashMap: " + hashMap);

        // Remove
        hashMap.remove("Banana");
        System.out.println("After removal: " + hashMap);


        //---------------------------------------------------------HASHTABLE
        /* key (unique) -> value  , unordered, */

        System.out.println("\n" + "HashTable : ------------------- |");

        Hashtable<String, Integer> hashTable = new Hashtable<>();

        // Add
        hashTable.put("Apple", 10);
        hashTable.put("Banana", 20);
        hashTable.put("Orange", 30);

        // Show
        for (String key : hashTable.keySet()) {
            System.out.println(key + " -> " + hashTable.get(key));
        }

        // Update
        hashTable.put("Banana", 25); // updating value for key "Banana"
        System.out.println("Updated HashTable: " + hashTable);

        // Remove
        hashTable.remove("Orange");
        System.out.println("After removal: " + hashTable);


        //---------------------------------------------------------TREEMAP
        /* */

        System.out.println("\n" + "TreeMap : ------------------- |");

        TreeMap<String, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder()); // reverse order

        // Add
        treeMap.put("Apple", 50);
        treeMap.put("Banana", 20);
        treeMap.put("Mango", 30);
        treeMap.put("Orange", 40);

        // Show
        System.out.println("Mango Price: " + treeMap.get("Mango"));

        System.out.println("First Key: " + treeMap.firstKey());
        System.out.println("Last Key: " + treeMap.lastKey());

        // Update
        treeMap.put("Mango", 35); // updating value for key "Mango"
        System.out.println("Updated TreeMap: " + treeMap);

        // Remove
        treeMap.remove("Banana");
        System.out.println("After removal: " + treeMap);


        //---------------------------------------------------------STACK
        /* last in , first out */

        System.out.println("\n" + "Stack : ------------------- |");

        Stack<Integer> stack = new Stack<>();

        // Add
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Show
        System.out.println("Top element: " + stack.peek());

        // Update (pop and push new element)
        stack.pop();
        stack.push(35);
        System.out.println("Updated Stack: " + stack);

        // Remove
        System.out.println("Popped element: " + stack.pop());


        //---------------------------------------------------------QUEUE
        /* first in , first out */

        System.out.println("\n" + "Queue : ------------------- |");

        Queue<String> queue = new LinkedList<>();

        // Add
        queue.offer("Junaid");
        queue.offer("Ali");
        queue.offer("Ahmed");

        // Show
        System.out.println("Front element: " + queue.peek());

        // Update
        queue.poll();
        queue.offer("Updated Junaid");
        System.out.println("Updated Queue: " + queue);

        // Remove
        System.out.println("Removed: " + queue.poll());


        //---------------------------------------------------------VECTOR
        /* like araylist */

        System.out.println("\n" + "Vector : ------------------- |");

        Vector<String> vector = new Vector<>();

        // Add
        vector.add("Apple");
        vector.add("Banana");
        vector.add("Cherry");

        // Show
        System.out.println("Vector: " + vector);

        // Update
        vector.set(1, "Updated Banana");
        System.out.println("Updated Vector: " + vector);

        // Remove
        vector.remove(2);
        System.out.println("After removal: " + vector);


        //---------------------------------------------------------PRIORITYQUEUE
        /*  */

        System.out.println("\n" + "PriorityQueue : ------------------- |");

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add
        priorityQueue.offer(15);
        priorityQueue.offer(10);
        priorityQueue.offer(30);
        priorityQueue.offer(5);

        // Show
        System.out.println("Peek: " + priorityQueue.peek());

        // Update (remove and re-add)
        priorityQueue.remove(10);
        priorityQueue.offer(20);
        System.out.println("Updated PriorityQueue: " + priorityQueue);

        // Remove
        System.out.println("Poll: " + priorityQueue.poll());


        //---------------------------------------------------------SET
        /*  */

        System.out.println("\n" + "Set : ------------------- |");

        Set<Integer> set = new HashSet<>();

        // Add
        set.add(10);
        set.add(20);
        set.add(30);

        // Show
        System.out.println("HashSet: " + set);

        // Update (remove and re-add)
        if (set.contains(20)) {
            set.remove(20);
            set.add(25);
        }
        System.out.println("Updated HashSet: " + set);

        // Clear the HashSet
        set.clear();
        System.out.println("Is the HashSet empty? " + set.isEmpty());
    }
}