package redis_cache.rediscache.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import redis_cache.rediscache.Model.RedisModel.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
