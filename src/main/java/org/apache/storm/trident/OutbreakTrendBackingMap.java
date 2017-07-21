/**
 * 
 */
package org.apache.storm.trident;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import storm.trident.state.map.IBackingMap;

/** 
* @author 作者:ZC
* @author 作者 E-mail:alcret13@gmail.com
* @version 创建时间：2017年7月17日
* 类说明：
*/
public class OutbreakTrendBackingMap implements IBackingMap<Long> {
    private static final Logger LOG = LoggerFactory.getLogger(OutbreakTrendBackingMap.class);
    Map<String, Long> storage = new ConcurrentHashMap<String, Long>();

    public List<Long> multiGet(List<List<Object>> keys) {
        List<Long> values = new ArrayList<Long>();
        for (List<Object> key : keys) {
            Long value = storage.get(key.get(0));
            if (value == null) {
                values.add(new Long(0));
            } else {
                values.add(value);
            }
        }
        return values;
    }

    public void multiPut(List<List<Object>> keys, List<Long> vals) {
        for (int i = 0; i < keys.size(); i++) {
            LOG.info("Persisting [" + keys.get(i).get(0) + "] ==> [" + vals.get(i) + "]");
            storage.put((String) keys.get(i).get(0), vals.get(i));
        }
    }
}