package redis_cache.rediscache.Services;

import com.google.gson.Gson;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis_cache.rediscache.Services.DTO.UserDto;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtility {


    private final RedisTemplate<String,String> redisTemplate;

    private final Gson gson;

    public RedisUtility(RedisTemplate<String,String> redisTemplate,Gson gson)
    {
        this.redisTemplate=redisTemplate;
        this.gson=gson;
    }


    public void setValue(final  Long key, UserDto userDto)
    {
        redisTemplate.opsForValue().set(key.toString(),gson.toJson(userDto));
        redisTemplate.expire(key.toString(),10, TimeUnit.MINUTES);
    }

    public Optional<UserDto> getValue(final Long key)
    {
        UserDto userDto=gson.fromJson(redisTemplate.opsForValue().get(key.toString()),UserDto.class);
        if(userDto==null)
            return Optional.empty();
        return Optional.of(userDto);

    }

    public void deleteKeyFormed(String key)
    {
        redisTemplate.delete(key);
    }
}
