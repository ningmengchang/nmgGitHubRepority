package guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
/**
 * ¹È¸è»º´æ
 * @author ningm
 *
 */

import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;
import sun.security.action.PutAllAction;

/**
 * Ê¹ÓÃ¹È¸èguavaµÄ»º´æ
 * @author ningm
 *
 */
public class LocalCacheTest {
	public static Cache<Object, Object> cache;
	static {
		CacheBuilder<Object, Object> testCache= CacheBuilder.newBuilder();
		LocalCacheTest.cache= testCache.build();
		System.out.println("³õÊ¼»¯Íê±Ï");
	}
	public static void main(String[] args) {
		LocalCacheTest.cache.put("a", "b");
		System.out.println(LocalCacheTest.get("a"))	;
	}
	public static void put(Object k, Object V) {
		cache.put(k,V);
	}
	public static Object get(Object k) {
		return cache.getIfPresent("a");
	}
}
