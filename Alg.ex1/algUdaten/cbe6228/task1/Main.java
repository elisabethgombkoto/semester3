package algUdaten.cbe6228.task1;

public class Main {
public static void main(String[] args) {
	GrobAnalyse g = new GrobAnalyse();
	String str ="xdsafsgdfzfjkdsgjkarfme,awmdrfmntvjwnetclvhtcjea";
	Character ch = 'd';
	System.out.println("String length: " + str.length());
	System.out.println(ch + " was found on position " + g.findCharLeft(str, ch)+"\n");	
	System.out.println(ch + " was found on position " + g.findCharRight(str, ch)+"\n");	
	System.out.println(ch + " was found on position " + g.findCharRandom(str, ch)+"\n");	
}
}
