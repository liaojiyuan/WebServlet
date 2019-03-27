/**
 * 
 */
package bean;

/**
 * @author Administrator
 * @date 2019年3月13日 下午4:44:43
 * @description
 */
public class User {
	private String name;
	private String pwd;

	/**
	 * @param name
	 * @param pwd
	 */
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
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
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
