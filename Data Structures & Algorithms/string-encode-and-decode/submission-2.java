class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();

        for(String str:strs){
            sb.append(str.length()).append("#").append(str);
        }
        String st=sb.toString();
        return st;
    }

    public List<String> decode(String str) {
        List<String> l=new ArrayList<>();
        int i=0;
        while(i<str.length()){
            int j=i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int length=Integer.parseInt(str.substring(i,j));
            String st=str.substring(j+1,j+1+length);
            l.add(st);
            i=j+1+length;
        }
        return l;
    }
}
