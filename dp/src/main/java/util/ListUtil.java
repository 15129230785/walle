package util;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by hunk.qin on 2015/1/27.
 */
public class ListUtil {

    public static boolean isEmpty(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean isNotEmpty(List list) {
        return !isEmpty(list);
    }

    public static <T> List<List<T>> groupList(List<T> allList, int size) {
        if (isEmpty(allList)) {
            return null;
        }

        int totalCount = allList.size();
        int groupCount = totalCount / size;
        int last = totalCount % size;

        List<List<T>> results = new ArrayList<List<T>>();
        List<T> group;
        for (int i = 0; i < groupCount; i++) {
            group = allList.subList(i * size, (i + 1) * size);
            results.add(group);
        }

        //最后一批
        if (0 < last) {
            group = allList.subList(groupCount * size, groupCount * size + last);
            results.add(group);
        }

        return results;
    }

    /**
     * 删除ArrayList中重复元素，保持顺序
     * 如果用HashSet的话，如果是对象，则要将对象实现equals和hashCode方法
     *
     * @param list
     * @return
     */
    public static List removeDuplicateWithOrder(List list) {
        Set set = new HashSet();
        List newList = new ArrayList();
        for (Iterator iter = list.iterator(); iter.hasNext(); ) {
            Object element = iter.next();
            if (set.add(element))
                newList.add(element);
        }
        list.clear();
        list.addAll(newList);
        return list;
    }

    /**
     * 判断一个list是否包含另一个list的所有元素
     */
    public static boolean isContain(List<String> bigList, List<String> smallList) {
        boolean flag = false;
        Set set = new HashSet();
        if (isNotEmpty(bigList)) {
            for (String element : bigList) {
                set.add(element);
            }
            flag = set.containsAll(smallList);
        }
        return flag;
    }

    public static <T> Map<String,T> convertToMap(List<T> list,String propertyName){
        if(isEmpty(list)) return null;
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        Field field=null;
        for(Field f:fields){
            if(f.getName().equals(propertyName)){
                f.setAccessible(true);
                field=f;
            }

        }
         Map<String ,T> map=new HashMap<String, T>();
        for (T t : list) {
            String key="";
            try {
                if(field==null){
                    key=t.toString();
                }else{
                    Object o=field.get(t);
                    if(o==null){
                        key=t.toString();
                    }else{
                        key=String.valueOf(o);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            map.put(key,t);
        }
        return  map;
    }
}
