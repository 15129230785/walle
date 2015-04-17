package dp.dubbo.redis.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONArray;
import dp.dubbo.redis.service.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by evan on 2015/1/27.
 */
@Service
public class RedisClientImpl implements RedisClient {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    //    @Override
//    public Boolean zadd(String key, Double score, RedisParams req) {
//        return redisTemplate.opsForZSet().add(key, req, score);
//    }

    @Override
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public Set<Object> zrange(String key, Long start, Long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    @Override
    public Long removeRangeByScore(String key, Double min, Double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    @Override
    public void set(String key, Object o) {
        redisTemplate.opsForValue().set(key, o);
    }

    @Override
    public Boolean expire(String key, Integer timeout, String timeUnit) {
        TimeUnit unit = TimeUnit.valueOf(timeUnit);
        if (unit == null) {
            logger.error("timeUnit is null return.");
            return false;
        }
        return redisTemplate.expire(key,timeout,unit);
    }

    @Override
    public Double incr(String key) {
        return redisTemplate.opsForValue().increment(key, 1D);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object obj, long time, String timeUnit) {

        TimeUnit unit = TimeUnit.valueOf(timeUnit);
        if (unit == null) {
            logger.error("timeUnit is null return.");
            return;
        }
        redisTemplate.opsForValue().set(key, obj, time, unit);
    }

    @Override
    public Long getSetSize(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    @Override
    public Long getListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    @Override
    public Set<Object> zPopByScore(String key, Double min, Double max, Long offset, Long count) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    @Override
    public Long listLeftPush(String key, Object val) {
        return redisTemplate.opsForList().leftPush(key, val);
    }

    @Override
    public List listRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }
}
