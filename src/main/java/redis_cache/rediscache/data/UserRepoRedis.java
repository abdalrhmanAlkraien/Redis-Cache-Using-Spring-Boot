package redis_cache.rediscache.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import redis_cache.rediscache.Model.RedisModel.User;
import redis_cache.rediscache.Model.RedisModel.UserRedis;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepoRedis extends CrudRepository<UserRedis, Long> {
    Optional<User> findByEmailIdAndPassword(String emailId, String password);
}
