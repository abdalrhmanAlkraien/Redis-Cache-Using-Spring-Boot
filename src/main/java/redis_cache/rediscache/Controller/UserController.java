package redis_cache.rediscache.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis_cache.rediscache.Services.DTO.AuthUserDto;
import redis_cache.rediscache.Services.DTO.UserDto;
import redis_cache.rediscache.Services.GenericResponse;
import redis_cache.rediscache.Services.UserService;

@RestController
@RequestMapping("api/redis")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService)
    {
        this.userService=userService;
    }
    @PostMapping("/add")
    public GenericResponse addUser(@RequestBody UserDto userDto)
    {
        return userService.addUser(userDto);
    }

    @GetMapping("/user/{id}")
    public GenericResponse getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
}
