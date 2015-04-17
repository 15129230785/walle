package dp.dubbo.redis.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by infi on 2015/1/22.
 */
public interface RedisClient {
   // public Boolean zadd(String key, Double score, RedisParams req);

    public Boolean hasKey(String key);

    public Set<Object> zrange(String key, Long start, Long end);

    public Long removeRangeByScore(String key, Double min, Double max);

    public Boolean expire(String key, Integer timeout, String timeUnit);

    public Double incr(String key);

    public void delete(String key);

    public void delete(Collection key);

    public Object get(String key);

    public void set(String key, Object o);

    /**
     * set 有实效性的数据，超过该时间数据过期，不在内存中，dump到 swap 中
     *
     * @param key
     * @param obj
     * @param time 有效时长
     */
    public void set(String key, Object obj, long time, String timeUnit);

    Long getSetSize(String key);

    Long getListSize(String key);

    /**
     * 获取给定分数区间内的多个元素
     *
     * @param key
     * @param min
     * @param max
     * @param offset
     * @param count
     * @return
     */
    public Set<Object> zPopByScore(String key, Double min, Double max, Long offset, Long count);

    /**
     * list压栈
     *
     * @param key
     * @param val
     * @return
     */
    Long listLeftPush(String key, Object val);

    /**
     * list 出栈
     * @param key
     * @param start
     * @param end
     * @return
     */
    List listRange(String key, long start, long end);


}
