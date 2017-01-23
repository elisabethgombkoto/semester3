package hue01.CompressText.ego8769;

public class Main {

	public static void main(String[] args) throws InvalidStringException {
		CoDeCompress k = new CoDeCompress();
		String strDK = "abbcccccddddeefggg";
		String strK = "abbc5d4eefg3";
		System.out.println("compressed:   " + strDK + " -> " + k.compress(strDK));
		System.out.println("decompressed: " + strK + " -> " + k.decompress(strK));

	}

}
