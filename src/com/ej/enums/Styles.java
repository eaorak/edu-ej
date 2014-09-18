package com.ej.enums;

public class Styles {

	public static int STYLE_BOLD = 1 << 0; // 1
	public static int STYLE_UNDERLINE = 1 << 1; // 2
	public static int STYLE_BORDER = 1 << 2; // 4
	public static int STYLE_WIDE = 1 << 3; // 8

	public static void apply(int styles) {
		if ((styles & STYLE_BOLD) == STYLE_BOLD) {

		}
	}

	public static void main(String[] args) {
		apply(STYLE_BOLD | STYLE_UNDERLINE | STYLE_WIDE);
		apply(123123);
	}

}
