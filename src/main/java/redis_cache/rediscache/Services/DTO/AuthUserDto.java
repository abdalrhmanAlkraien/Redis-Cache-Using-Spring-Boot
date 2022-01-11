package redis_cache.rediscache.Services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;


public class AuthUserDto extends UserDto {
    public AuthUserDto(String emailId, String password) {
        super(emailId, password);
    }
}
