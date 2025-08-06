package stajokulu.mlipmp.entities.dto.user;

import lombok.*;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {

    private String email;
    private String passwordHash;
    
}
