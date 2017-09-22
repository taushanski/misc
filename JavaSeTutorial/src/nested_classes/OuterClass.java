package nested_classes;

public class OuterClass {
	static String test = "";

	static class StaticNestedClass {
		static String testNested = test;
	}
}
