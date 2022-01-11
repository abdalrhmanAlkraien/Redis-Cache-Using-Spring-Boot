package redis_cache.rediscache.Services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ControlledCacheService {
    @Cacheable(cacheNames = "myControlledCache")
    public String getFromCache() {
        return null;
    }

    @CachePut(cacheNames = "myControlledCache")
    public String populateCache() {
        return "this is it again!";
    }

    @CacheEvict(cacheNames = "myMethod")
    public void removeCache()
    {
        System.out.println("remove Cache here !");
    }
}
