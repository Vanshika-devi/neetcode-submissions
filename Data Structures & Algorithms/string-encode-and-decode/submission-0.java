class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();

        for(String s:strs){
            sb.append(s.length()).append("#").append(s);
        }
        String str=sb.toString();
        return str;
    }

    public List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int i = 0;
    
    while (i < str.length()) {
        // Step 1: Find the position of the '#' delimiter
        int j = i;
        while (str.charAt(j) != '#') {
            j++;
        }
        
        // Step 2: Parse the length number from before the '#'
        int length = Integer.parseInt(str.substring(i, j));
        
        // Step 3: Extract the substring using the length
        // The word starts right after '#' (j + 1) and goes for 'length' characters
        String s = str.substring(j + 1, j + 1 + length);
        result.add(s);
        
        // Step 4: Move 'i' past the current word to the next length marker
        i = j + 1 + length;
    }
    
    return result;
}
}
