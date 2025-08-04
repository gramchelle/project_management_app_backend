package stajokulu.mlipmp.business.concretes;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stajokulu.mlipmp.business.abstracts.UserService;
import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.user.UserDto;
import stajokulu.mlipmp.entities.dto.user.GetUserDto;
import stajokulu.mlipmp.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GetUserDto> getAll() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            System.out.println("HATA: UserServiceImpl -> GetAllUsers");
            throw new IllegalArgumentException("No users are found.");
        }else{
            return users.stream()
                    .map(user -> new GetUserDto(user.getId(), user.getName(), user.getEmail(), user.getRole()))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public List<GetUserDto> getById(UUID id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User foundUser = user.get();
            return List.of(new GetUserDto(foundUser.getId(), foundUser.getName(), foundUser.getEmail(), foundUser.getRole()));
        } else {
            System.out.println("HATA: UserServiceImpl -> GetById");
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    @Override
    public User saveUser(UserDto userSaveDto) {
        if(userRepository.findByEmail(userSaveDto.getEmail()).isPresent()){
            System.out.println("HATA: UserServiceImpl -> SaveUser");
            throw new IllegalArgumentException("User with this email already exists.");
        } else if (userRepository.findByName(userSaveDto.getName()).isPresent()){
            throw new IllegalArgumentException("User with this name already exists.");
        }

        if (userSaveDto.getEmail() == null || userSaveDto.getName() == null || userSaveDto.getRole() == null) {
            System.out.println("HATA: UserServiceImpl -> SaveUser");
            throw new IllegalArgumentException("User details cannot be null.");
        } else {
            User user = new User();
            user.setName(userSaveDto.getName());
            user.setEmail(userSaveDto.getEmail());
            user.setPassword_hash(userSaveDto.getPassword());
            user.setRole(userSaveDto.getRole());

            return userRepository.save(user);
        }
    }

    @Override
    public boolean deleteUser(UUID id) {
        try {
            User user = userRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
            userRepository.delete(user);
            return true;
        } catch (Exception e) {
            System.out.println("HATA: UserServiceImpl -> DeleteUser");
            throw new IllegalArgumentException("Error occurred while deleting user with id: " + id);
        }
    }

    @Override
    public void updateUser(GetUserDto getUserDto) {
        if (getUserDto.getId() == null) {
            System.out.println("HATA: UserServiceImpl -> UpdateUser");
            throw new IllegalArgumentException("User ID cannot be null.");
        }

        User user = userRepository.findById(getUserDto.getId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + getUserDto.getId()));

        if (getUserDto.getName() != null) {
            user.setName(getUserDto.getName());
        }
        if (getUserDto.getEmail() != null) {
            user.setEmail(getUserDto.getEmail());
        }
        if (getUserDto.getRole() != null) {
            user.setRole(getUserDto.getRole());
        }

        userRepository.save(user);
    }
}
