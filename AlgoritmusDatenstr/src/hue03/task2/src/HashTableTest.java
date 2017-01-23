package hue03.task2.src;

import static org.junit.Assert.assertEquals;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HashTableTest {
	@org.junit.Test
	public void size() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(size, table.size());
	}

	@org.junit.Test
	public void isEmpty1() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		table.put(5, "hello");
		assertEquals(false, table.isEmpty());
	}

	@org.junit.Test
	public void isEmpty2() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(true, table.isEmpty());
	}

	// one element available
	@org.junit.Test
	public void putGet1() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		String value = "hello";
		int key = 5;

		assertEquals(value, table.put(key, value));
		assertEquals(table.get(key), value);
	}

	// one element available
	@org.junit.Test
	public void putGet2() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		int key = 5;

		assertEquals(table.get(key), null);
	}

	// more than element available
	@org.junit.Test
	public void putGet3() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		String value = "hello";
		String value2 = "other";
		int key = 5;
		int key2 = 2;

		assertEquals(value, table.put(key, value));
		assertEquals(value2, table.put(key2, value2));

		assertEquals(table.get(key), value);
		assertEquals(table.get(key2), value2);
	}

	// only one element
	@org.junit.Test
	public void containsKey1() throws Exception {
		int size = 50;
		int key = 5;
		String val = "hello";
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(val, table.put(key, val));
		assertEquals(true, table.containsKey(key));
	}

	// elements available
	@org.junit.Test
	public void containsKey2() throws Exception {
		int size = 50;
		int key = 5;
		int key2 = 6;
		String val = "hello";
		String val2 = "other";
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(val, table.put(key, val));
		assertEquals(val2, table.put(key2, val2));
		assertEquals(true, table.containsKey(key));
		assertEquals(true, table.containsKey(key2));
	}

	// no elements available
	@org.junit.Test
	public void containsKey3() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(false, table.containsKey(5));
	}

	// elements available but one key not available
	@org.junit.Test
	public void containsKey4() throws Exception {
		int size = 50;
		int key = 5;
		int key2 = 6;
		String val = "hello";
		String val2 = "other";
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(val, table.put(key, val));
		assertEquals(val2, table.put(key2, val2));
		assertEquals(true, table.containsKey(key));
		assertEquals(true, table.containsKey(key2));
		assertEquals(false, table.containsKey(10));
	}

	// elements available but on value not available
	@org.junit.Test
	public void containsValue1() throws Exception {
		int size = 50;
		String value = "hello";
		String value2 = "other";
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(value, table.put(1, value));
		assertEquals(value2, table.put(6, value2));
		assertEquals(true, table.containsValue(value));
		assertEquals(true, table.containsValue(value2));
		assertEquals(false, table.containsValue("h"));
	}

	// no elements available
	@org.junit.Test
	public void containsValue2() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(false, table.containsValue("h"));
	}

	// some elements in map
	@org.junit.Test
	public void remove1() throws Exception {
		int size = 50;
		int key = 5;
		int key2 = 6;
		String val = "hello";
		String val2 = "other";
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(val, table.put(key, val));
		assertEquals(val2, table.put(key2, val2));
		assertEquals(val, table.remove(key));
		assertEquals(val2, table.remove(key2));
		assertEquals(false, table.containsKey(key));
		assertEquals(false, table.containsKey(key2));
	}

	@org.junit.Test
	public void remove2() throws Exception {
		int size = 50;
		int key = 5;
		int key2 = 6;
		HashTable<Integer, String> table = new HashTable<>(size);
		assertEquals(null, table.remove(key));
		assertEquals(false, table.containsKey(key));
		assertEquals(false, table.containsKey(key2));
	}

	@org.junit.Test
	public void putAll1() throws Exception {
		int size = 50;
		int key = 5;
		int key2 = 6;
		String val = "hello";
		String val2 = "other";
		HashTable<Integer, String> table = new HashTable<>(size);
		Map<Integer, String> map = new TreeMap<>();
		map.put(key, val);
		map.put(key2, val2);

		table.putAll(map);
		assertEquals(val, table.get(key));
		assertEquals(val2, table.get(key2));
	}

	// no entries in map
	@org.junit.Test
	public void putAll2() throws Exception {
		int size = 50;
		HashTable<Integer, String> table = new HashTable<>(size);
		Map<Integer, String> map = new TreeMap<>();

		table.putAll(map);
	}

	@org.junit.Test
	public void clear() throws Exception {
		int size = 50;
		int key = 5;
		int key2 = 6;
		String val = "hello";
		String val2 = "other";
		HashTable<Integer, String> table = new HashTable<>(size);
		table.put(key, val);
		table.put(key2, val2);

		table.clear();

		assertEquals(true, table.isEmpty());
	}

	@org.junit.Test
	public void keySet() throws Exception {
		// @TODO
	}

	@org.junit.Test
	public void values() throws Exception {
		HashTable<Integer, String> table = new HashTable<>(50);

		Map.Entry<Integer, String>[] prev = new AbstractMap.SimpleEntry[] { new AbstractMap.SimpleEntry<>(1, "hello"),
				new AbstractMap.SimpleEntry<>(9, "other") };

		for (int i = 0; i < prev.length; i++) {
			table.put(prev[i].getKey(), prev[i].getValue());
		}

		Collection<String> coll = table.values();
		int n = 0;

		Iterator<String> iter;
		String temp;

		for (iter = coll.iterator(); iter.hasNext();) {
			temp = iter.next();

			if (temp != null) {
				for (int i = 0; i < prev.length; i++) {
					if (prev[i].getKey() == n) {
						assertEquals(prev[i].getValue(), temp);
						break;
					}
				}
			}

			n++;
		}
	}

	@org.junit.Test
	public void entrySet() throws Exception {
		// @TODO
	}

}