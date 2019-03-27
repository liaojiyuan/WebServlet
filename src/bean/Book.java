/**
 * 
 */
package bean;

/**
 * @author Administrator
 * @date 2019年3月11日 上午11:25:07
 * @description
 */
public class Book {
	private String Id;
	private String name;
	private String author;

	/**
	 * @param id
	 * @param name
	 * @param author
	 */
	public Book(String id, String name, String author) {
		super();
		Id = id;
		this.name = name;
		this.author = author;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		Id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

}
