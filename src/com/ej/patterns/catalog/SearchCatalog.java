package com.ej.patterns.catalog;

import java.util.List;

public class SearchCatalog {

	static class Book {

	}

	enum SortType {
		BINARY, BUBBLE;
	}
	private final SortType type;

	public SearchCatalog(SortType type) {
		this.type = type;
	}

	public List<Book> search() {
		switch (type) {
		case BINARY:
			// ....
			// ....
			break;
		case BUBBLE:
			// ....
			// ....
			break;
		default:
			break;
		}
		return null;
	}

}
