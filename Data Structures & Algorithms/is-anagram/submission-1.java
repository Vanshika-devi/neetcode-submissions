class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer>h1=new HashMap<>();
        HashMap<Character,Integer>h2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(h1.containsKey(s.charAt(i))){
                h1.put(s.charAt(i),h1.get(s.charAt(i))+1);
            }
            else{
                h1.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(h2.containsKey(t.charAt(i))){
                h2.put(t.charAt(i),h2.get(t.charAt(i))+1);
            }
            else{
                h2.put(t.charAt(i),1);
            }
        }
        return h1.equals(h2);
    }
}
