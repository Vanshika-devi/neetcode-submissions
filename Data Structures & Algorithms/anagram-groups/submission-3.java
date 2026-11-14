class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> h=new HashMap<>();
        for(String str:strs){
            char [] value=str.toCharArray();
            Arrays.sort(value);
            String key=new String(value);
            if(!h.containsKey(key)){
                h.put(key,new ArrayList<>());
            }
        h.get(key).add(str);
        }
        return new ArrayList<>(h.values());
    }
}
