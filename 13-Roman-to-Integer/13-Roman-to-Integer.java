class Solution {
    HashMap<Character, Integer> hashmap = new HashMap<>();

    public void initHashMap() {
        hashmap.put('M', 1000);
        hashmap.put('D', 500);
        hashmap.put('C', 100);
        hashmap.put('L', 50);
        hashmap.put('X', 10);
        hashmap.put('V', 5);
        hashmap.put('I', 1);
    }

    public int romanToInt(String s) {
        initHashMap();
        
        int ret = 0;
        int current = 0;
        int previous = hashmap.get(s.charAt(0));
        ret += previous;
        
        for(int i = 1 ; i < s.length() ; ++i) {
            current = hashmap.get(s.charAt(i));
            if (current > previous) {
                ret = ret - 2 * previous + current;
            } else {
                ret += current;
            }
            previous = current;
        }
        
        return ret;
    }
}