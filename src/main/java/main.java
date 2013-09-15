import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
	public static List<?> method(Object... things) {
		System.out.println("method(Object...)");
		return null;
	}
	
	public static <T> List<T> method(Class<T> type, Object... things) {
		System.out.println("method(Class, Object...)");
		Object thing = things[0];
		Iterable<?> iterableThing = (Iterable<?>) thing;
		List<T> list = new ArrayList<T>();
		for (Object thingThing : iterableThing) {
			// This doesn't compile
			list.addAll(method(type, thingThing));
			// or this
			// list.addAll(method((Class<T>)type, thingThing));

			// these compile:
			// list.addAll(method((Class)type, thingThing));
			// list.addAll(anotherNameForMethod(type, thingThing));
			// List<T> list2 = method(type, thingThing);
			// list.addAll(list2);

		}

		return null;
	}

	public static <T> List<T> anotherNameForMethod(Class<T> type, Object... things) {
		return null;
	}

}
