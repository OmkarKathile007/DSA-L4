
class TrieNode{
        TrieNode[] tri=new TrieNode[26];
        boolean EoW=false;
    }
class Trie {

    TrieNode root;

    public Trie() {
        
       this.root=new TrieNode();
        
    }
    
    public void insert(String word) {
        
        TrieNode node=root;
        for(char c:word.toCharArray()){
            
            int indx=c-'a';
            if(node.tri[indx]==null){
                node.tri[indx]=new TrieNode();
            }
            node=node.tri[indx];
        }
        node.EoW=true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.tri[index] == null) return false;
            node = node.tri[index];
        }
        return node.EoW;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.tri[index] == null) return false;
            node = node.tri[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
