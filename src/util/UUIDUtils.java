/**
 * 
 */
package util;

import java.util.UUID;

/**
 * @author Administrator
 * @date 2019年3月6日 下午10:13:51
 * @description
 */
public class UUIDUtils {
	/**
	 * 
	 * @description 获取32位的uuid作为表记录主键
	 * @param @return
	 * @return String
	 */
	public static final String getUUID() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

}
