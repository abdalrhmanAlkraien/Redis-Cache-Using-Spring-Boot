package redis_cache.rediscache.Services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheAnnotation {

    @Cacheable(cacheNames = "myMethod")
    public String cacheThis(){
        System.out.println("this is @Catchable invoke with this class");
        return "this is Cache";
    }
}
