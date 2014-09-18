package com.ej.keys;

import java.util.HashMap;
import java.util.Map;

public class Mapping {

	private final Map<String, Object> map = new HashMap<String, Object>();
	private final Map<Key, Object> map2 = new HashMap<Key, Object>();

	public Mapping() {
	}

	static class Key {

	}

	public Key getKey() {
		return new Key();
	}

	public void put1(String key, Object value) {
		map.put(key, value);
	}

	public void put2(Key key, Object value) {
		map2.put(key, value);
	}

	public Object get1(String key) {
		return map.get(key);
	}

	public Object get2(Key key) {
		return map2.get(key);
	}

	public static void main(String[] args) {
		Mapping mapping = new Mapping();
		Key key = mapping.getKey();
		mapping.put2(key, "");
		Object get2 = mapping.get2(key);
	}

}
