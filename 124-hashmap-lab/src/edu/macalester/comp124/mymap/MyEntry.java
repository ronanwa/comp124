package edu.macalester.comp124.mymap;

public class MyEntry<K, V> {
	private K key;
	private V value;
	
	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}
}
