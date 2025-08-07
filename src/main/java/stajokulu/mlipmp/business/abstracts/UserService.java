package stajokulu.mlipmp.business.abstracts;

import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.user.UserDto;
import stajokulu.mlipmp.entities.dto.user.GetUserDto;
import stajokulu.mlipmp.entities.dto.user.LoginDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {

    List<GetUserDto> getAll(); //DONE
    List<GetUserDto> getById(UUID id); //DONE
    User saveUser(UserDto userSaveDto); //DONE
    boolean deleteUser(UUID id); // DONE
    void updateUser(GetUserDto getUserDto); //DONE
    List<LoginDto> getUserByEmail(LoginDto loginDto); //TODO: Implement this method to fetch user by email and password
}
// bir projeye ait tüm taskleri çeken fonksiyonu yaz
// hepsine cors ekle