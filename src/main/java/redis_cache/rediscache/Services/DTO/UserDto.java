package redis_cache.rediscache.Services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import redis_cache.rediscache.Model.RedisModel.User;

import java.io.Serializable;


public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String emailId;
    private String password;

    public UserDto(String emailId, String password) {
        this.emailId=emailId;
        this.password=password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toEntity(){
        User user=new User();
        user.setEmailId(getEmailId());
        user.setPassword(getPassword());
        return user;
    }

}
