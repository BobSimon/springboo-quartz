package com.example.demo.util;

import java.util.HashMap;

/**
 * 仅仅用于解决MyBatis配置returnType="map"时，返回的map的key区分大小写，导致xxmap.get(XXX)或xxxmap.get(xxx)获取不到正确数据的问题。<br>
 * 请用returnType="dbResultMap" 替换 returnType="map"
 * <br><b>请不要用于其它用途！</b><br>
 * DbMap对于所有的Key都只认小写的，如果全用或部分用大写的字母作为Key，也全部转为小写的Key使用。
* @Author  Bob Simon
* @Date 2017-12-09 14:42
**/
public class DbResultMap extends HashMap<String,Object> {

   /**
    * get形式的key值转化为小写
    * @param key
    * @return
    */
   @Override
   public Object get(Object key) {
      return super.get(String.valueOf(key).toLowerCase());
   }

   /**
    * put形式也是把key值转化小写
    * @param key
    * @param value
    * @return
    */
   @Override
   public Object put(String key, Object value) {
      // TODO Auto-generated method stub
      return super.put(String.valueOf(key).toLowerCase(), value);
   }

}
