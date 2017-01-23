package oo.ego8769.hue02.bsp01;

public class Caesar {
	  private int shift;
	  private String s ="";
	  
	    public Caesar(int shift){
	        while(shift < 0)
	            shift += 26;
	        this.shift = shift%26;
	    }

	    public String encode(String s){
	        return encode(s, shift);
	    }
	    
	    public String decode(String s){
	        return encode(s, 26-shift);
	    }
	    
	    private String encode(String s, int shift){
	        s = s.toLowerCase();
	        char[] chars = s.toCharArray();
	        for(int i = 0; i < s.length(); i++)
	            chars[i] = encode(chars[i], shift);
	        return String.valueOf(chars);
	    }

	    private char encode(char c, int shift){
	        if(c >= 'a' && c <= 'z')
	            return (char)((c-'a'+shift)%26 + 'a');
	        else
	            return c;
	    }
	    
}
