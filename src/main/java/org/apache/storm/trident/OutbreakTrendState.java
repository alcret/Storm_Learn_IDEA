package org.apache.storm.trident;

import storm.trident.state.map.NonTransactionalMap;
import trident.state.OutbreakTrendBackingMap;

/** 
* @author 作者:ZC
* @author 作者 E-mail:alcret13@gmail.com
* @version 创建时间：2017年7月17日
* 类说明：
*/
public class OutbreakTrendState extends NonTransactionalMap<Long> {
    public OutbreakTrendState(OutbreakTrendBackingMap outbreakBackingMap) {
        super(outbreakBackingMap);
    }
}
