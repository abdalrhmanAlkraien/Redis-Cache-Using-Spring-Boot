package redis_cache.rediscache.Services;

import org.springframework.stereotype.Service;
import redis_cache.rediscache.Model.RedisModel.User;
import redis_cache.rediscache.Services.DTO.UserDto;
import redis_cache.rediscache.data.UserRepo;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UserService {

    private final UserRepo userRepo;


    private  final RedisUtility redisUtility;

    public UserService(UserRepo userRepo, RedisUtility redisUtility)
    {
        this.userRepo=userRepo;
        this.redisUtility=redisUtility;


    }

    public GenericResponse addUser(UserDto userDto)
    {
        User user=new User();
        user.setEmailId(userDto.getEmailId());
        user.setPassword(userDto.getPassword());
        userRepo.save(user);
        return new GenericResponse("User successfully register ",user);
    }

    public GenericResponse getUser(Long id){
        AtomicReference<GenericResponse> genericResponse=new AtomicReference<>();
        Optional<UserDto> userDto=redisUtility.getValue(id);
        if(!userDto.isPresent()){
            userRepo.findById(id).ifPresentOrElse(user -> {
                redisUtility.setValue(id,user.toDto());
                genericResponse.set(new GenericResponse("the user has id ".concat(id.toString()),user.toDto()));

            },() -> {
                genericResponse.set(new GenericResponse("cannot find User","this id".concat(id.toString()).concat("is invalid")));
            });
        }else
        genericResponse.set(new GenericResponse("the user has id ".concat(id.toString()),userDto));
        return genericResponse.get();
    }

}
