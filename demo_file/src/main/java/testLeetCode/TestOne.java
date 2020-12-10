package testLeetCode;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TestOne {
	  public static void main(String[] args) {
	        Map<Timestamp, String> map = new TreeMap<>();
	        map.put(new Timestamp(1548928355000l), "ccccc");
	        map.put(new Timestamp(154892233l), "aaaaa");
	        map.put(new Timestamp(15489444l), "bbbbb");
	        map.put(new Timestamp(1548922130l), "ddddd");

	        Set<Timestamp> keySet = map.keySet();
	        Iterator<Timestamp> iter = keySet.iterator();
	        while (iter.hasNext()) {
	            Timestamp key = iter.next();
	            System.out.println(key + ":" + map.get(key));
	        }
	    }
}
