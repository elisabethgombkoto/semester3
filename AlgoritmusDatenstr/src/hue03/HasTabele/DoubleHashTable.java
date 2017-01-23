package hue03.HasTabele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class DoubleHashTable<K, V> implements Map<K, V> {

	private ArrayList<V> _hashTable;
	// private DataItem _bufItem;
	private int _arraySize;
	private int _availableCount;

	public DoubleHashTable(int size) {
		_arraySize = size;
		_hashTable = new ArrayList<V>(_arraySize);
		// _bufItem = new DataItem(-1);

		for (int i = 0; i < _arraySize; i++) {
			_hashTable.add(null);
		}

		_availableCount = 0;
	}

	// public void insert(Object Key, DataItem dataItem) {
	// int tryInsertFailed = 0;
	// int hashKey = hash(Key, tryInsertFailed);
	// while (hashArray[hashKey] != null ||
	// hashArray[hashKey].getValue().equals(-1)) {
	// tryInsertFailed++;
	// hashKey = hash(Key, tryInsertFailed);
	//
	// }
	// hashArray[hashKey] = dataItem; // insert item
	// }
	//
	// public DataItem delete(Object Key) {
	// int tryInsertFailed = 0;
	// int hashKey = hash(Key, tryInsertFailed);
	//
	// while (hashArray[hashKey] != null) {
	// if (hashArray[hashKey].getKey() == Key) {
	// DataItem temp = hashArray[hashKey]; // save item
	// hashArray[hashKey] = bufItem; // delete item
	// return temp; // return item
	// }
	// tryInsertFailed++;
	// hashKey = hash(Key, tryInsertFailed);
	//
	// }
	// throw new OBJECT_NOT_EXIST("Object not found.");
	// }
	//
	// private int hash(Object Key, int tryInsertFaild) {
	// return hashFunction1(Key) + tryInsertFaild * (hashFunction2(Key) %
	// arraySize);
	//
	// }
	//
	// private int hashFunction2(Object Key) {
	// return 1 + Key.hashCode() % (arraySize - 1);
	//
	// }
	//
	// private int hashFunction1(Object Key) {
	// return Key.hashCode() % arraySize;
	//
	// }

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

		return _hashTable.get(hashVal) != null;
	}

	@Override
	public boolean containsValue(Object o) {
		V temp;

		for (int i = 0; i < _arraySize; i++) {
			temp = _hashTable.get(i);

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

		return _hashTable.get(hashVal);
	}

	@Override
	public V put(K k, V v) {
		// @TODO: key?
		int hashVal = getHashValue(k.hashCode(), false);

		if (hashVal == -1)
			return null;

		_hashTable.set(hashVal, v);

		_availableCount++;

		return _hashTable.get(hashVal);
	}

	@Override
	public V remove(Object key) {
		int hashVal = getHashValue(key.hashCode(), true);

		if (hashVal == -1)
			return null;

		V temp = _hashTable.get(hashVal);
		_hashTable.set(hashVal, temp);

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
			_hashTable.set(i, null);
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
		return Collections.unmodifiableCollection(_hashTable);
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

		while (hashVal < _arraySize && (_hashTable.get(hashVal) == null) == exists) {
			hashVal += stepSize;
			// @TODO: ??
			// hashVal %= _arraySize;
		}

		if (hashVal >= _arraySize)
			hashVal = -1;

		return hashVal;
	}
}
