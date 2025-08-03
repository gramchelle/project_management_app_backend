package stajokulu.mlipmp.entities.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDto {

    private String name;
    private String email;
    private String role;

}
