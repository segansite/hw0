package uchidb;
import java.util.*;

/**
 * @author aelmore
 */
public class HW0Runner {
	//hashset, hashmap, array list
	private static class Single implements Containers<Integer, String> {
		private static Map<String, Integer> m = null;
		
		public Set<Integer> initSet(Integer[] tArray) {
			HashSet<Integer> hs = new HashSet<Integer>(Arrays.asList(tArray));
			return hs;
		}
		
		
		public List<Integer> initList(Integer[] tArray) {
			ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(tArray));
			return l;
		}
		
		public Map<String,Integer> initEmptyMap() {
			return new HashMap<String, Integer>();
		}
		
		
		public void storeMap(Map<String,Integer> mapToStoreInClass) {
			m = mapToStoreInClass;
		}
		
		public boolean addToMap(String key, Integer value, boolean overwriteExistingKey) {
			if (m.containsKey(key)) {
				if (overwriteExistingKey) {
					m.put(key, value);
					return true; 
				}
				return false;
			} else {
				m.put(key, value);
				return true;
			}
		}
		
		
		public Integer getValueFromMap(String key) {
			return m.get(key);
		}
		
		public Integer getValueFromMap(String key, Integer defaultValue) {
			Integer ret = m.get(key);
			if(ret != null) {
				return ret;
			}
			return defaultValue;
		}
		
	}
	private static Single container = new Single();

	//TODO you likely will need to add member variable
	
	// This class is a factory for a singleton containers class.
	// https://www.tutorialspoint.com/java/java_using_singleton.htm
	public static Containers<Integer, String> getContainers() {
		return container;
	}


	public static void main(String[] args){
		getContainers();
	}
}
