package redis_cache.rediscache;

import com.google.common.util.concurrent.Runnables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import redis_cache.rediscache.Services.CacheAnnotation;
import redis_cache.rediscache.Services.ControlledCacheService;

@SpringBootApplication
@EnableCaching
public class RediscacheApplication implements CommandLineRunner {

    @Autowired
    public CacheAnnotation cacheAnnotation;

    @Autowired
    ControlledCacheService controlledCacheService;

    public static void main(String[] args) {
        SpringApplication.run(RediscacheApplication.class, args);
    }

    private String getFromController(){
        String fromCache=controlledCacheService.getFromCache();
        if(fromCache==null) {
            System.out.println("cache is Empty");
            String newValue=controlledCacheService.populateCache();
            System.out.println("newValue = " + newValue);
            return newValue;
        }
        System.out.println("fromCache = " + fromCache);
        return fromCache;
    }

    @Override
    public void run(String... args) throws Exception {
        controlledCacheService.removeCache();
        System.out.println("this is first call");
        System.out.println(cacheAnnotation.cacheThis());
        System.out.println("this is Second call");
        System.out.println(cacheAnnotation.cacheThis());
        System.out.println("cache control ");
        System.out.println("getFromController() = " + getFromController());
    }
}
