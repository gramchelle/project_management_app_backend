package stajokulu.mlipmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.user.GetUserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    Optional<User> findById(UUID id);
    List<GetUserDto> findAllByEmail(String email);

}
