class Solution {
    public String foreignDictionary(String[] words) {
      int ind[]=new int[26];
        Arrays.fill(ind,-1);
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<26;i++){
            ArrayList<Integer> ans=new ArrayList<>();
            al.add(ans);
        }
        int tc=0;
        for(String ab:words){
            for(char ch:ab.toCharArray()){
                if(ind[ch-'a']==-1){
                ind[ch-'a']=0;
                tc++;
                }
            }
        }
        for(int i=0;i<words.length-1;i++){
            String a=words[i];
            String b=words[i+1];
            if(a.length()>b.length() && a.startsWith(b))
            return "";
            int min=Math.min(a.length(),b.length());
            for(int x=0;x<min;x++){
                if(a.charAt(x)!=b.charAt(x)){
                    int xv=a.charAt(x)-'a';
                    int yv=b.charAt(x)-'a';
                    al.get(xv).add(yv);
                    ind[yv]+=1;
                    break;
                }
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(ind[i]==0)
            q.offer(i);
        }
        StringBuilder sb=new StringBuilder("");
        while(!q.isEmpty()){
            int x=q.poll();
            sb.append((char)(x+'a'));
            for(int i:al.get(x)){
                ind[i]-=1;
                if(ind[i]==0)
                q.offer(i);
            }
        }
        if(sb.length()!=tc)
        return "";
        return sb.toString();
    }
}
