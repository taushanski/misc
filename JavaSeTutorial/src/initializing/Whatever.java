package initializing;

public class Whatever {

	static {
		System.out.println("Static block 1 was invoked");
	}

	public static String TEST = initializeTest();

	private static String initializeTest() {

		String result = "BlqBlq";
		System.out.println("initializeTest() was invoked!");
		return result;
	}
}
