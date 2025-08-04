package stajokulu.mlipmp.entities.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUserDto {

    private UUID id;
    private String name;
    private String email;
    private String role;

}
