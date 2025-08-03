package stajokulu.mlipmp.entities.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;

    private String email;

    // optional, only update if provided
    private String password; // plain password, will be hashed in service layer

    private String role;

}
