/**
 * 
 */
package service;

import java.util.LinkedHashMap;

import bean.Book;

/**
 * @author Administrator
 * @date 2019年3月11日 上午11:27:10
 * @description
 */
public class BookService {
	public static LinkedHashMap<String, Book> linkedHashMap = new LinkedHashMap<>();
	static {
		linkedHashMap.put("1", new Book("1", "Java开发", "Sam"));
		linkedHashMap.put("2", new Book("2", "C语言开发", "Sam"));
		linkedHashMap.put("3", new Book("3", "c++开发", "Sam"));
		linkedHashMap.put("4", new Book("4", "C#开发", "Sam"));
		linkedHashMap.put("5", new Book("5", "Python开发", "Sam"));
		linkedHashMap.put("6", new Book("6", "JavaScript开发", "Sam"));
	}

	public static LinkedHashMap<String, Book> getAll() {
		return linkedHashMap;
	}

}
