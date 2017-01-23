package hue03.task2.src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

//interface wurde implementiert
public class HashTable<K, V> implements Map<K, V> {
	private ArrayList<V> _list;
	private int _arraySize;
	private int _availableCount;

	public HashTable(int size) {
		_arraySize = size;
		// size cannot be a negative value
		_list = new ArrayList<>(_arraySize);

		for (int i = 0; i < _arraySize; i++) {
			_list.add(null);
		}

		_availableCount = 0;
	}

	@Override
	public int size() {
		return _arraySize;
	}

	@Override
	public boolean isEmpty() {
		return _availableCount == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		int hashVal = getHashValue(key.hashCode(), true);

		if (hashVal == -1)
			return false;

		return _list.get(hashVal) != null;
	}

	@Override
	public boolean containsValue(Object o) {
		V temp;

		for (int i = 0; i < _arraySize; i++) {
			temp = _list.get(i);

			if (temp != null && temp.equals(o)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public V get(Object key) {
		int hashVal = getHashValue(key.hashCode(), true);

		if (hashVal == -1)
			return null;

		return _list.get(hashVal);
	}

	@Override
	public V put(K k, V v) {
		// @TODO: key?
		int hashVal = getHashValue(k.hashCode(), false);

		if (hashVal == -1)
			return null;

		_list.set(hashVal, v);

		_availableCount++;

		return _list.get(hashVal);
	}

	@Override
	public V remove(Object key) {
		int hashVal = getHashValue(key.hashCode(), true);

		if (hashVal == -1)
			return null;

		V temp = _list.get(hashVal);
		_list.set(hashVal, temp);

		_availableCount--;

		return temp;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		for (Entry<? extends K, ? extends V> item : map.entrySet()) {
			put(item.getKey(), item.getValue());
		}
	}

	@Override
	public void clear() {
		for (int i = 0; i < _arraySize; i++) {
			_list.set(i, null);
		}

		_availableCount = 0;
	}

	@Override
	public Set keySet() {
		// @TODO
		return null;
	}

	@Override
	public Collection<V> values() {
		return Collections.unmodifiableCollection(_list);
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		// @TODO
		return null;
	}

	private int hash1(int key) {
		return key % _arraySize;
	}

	private int hash2(int key) {
		return 1 + key % (_arraySize - 1);
	}

	private int getHashValue(int key, boolean exists) {
		int hashVal = hash1(key);
		int stepSize = hash2(key);

		while (hashVal < _arraySize && (_list.get(hashVal) == null) == exists) {
			hashVal += stepSize;
			// @TODO: ??
			// hashVal %= _arraySize;
		}

		if (hashVal >= _arraySize)
			hashVal = -1;

		return hashVal;
	}
}
