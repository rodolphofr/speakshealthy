package br.site.util;

public class StringUtil {
	
	public static boolean isEmpty(String str) {
		return str.isEmpty() || str == null;
	}
	
	public static String removeSpecialCharacters(String str) {
		return str.replaceAll(".-", "");
	}
	
	public static String removeBlankSpace(String str) {
		return str.replaceAll(" ", "").trim();
	}
	
	public static String addUnderline(String str) {
		return str.replaceAll(" ", "_").trim();
	}
}

