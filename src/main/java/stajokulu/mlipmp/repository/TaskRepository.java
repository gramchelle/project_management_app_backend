package stajokulu.mlipmp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stajokulu.mlipmp.entities.concretes.Task;

import java.util.Optional;
import java.util.UUID;
import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    Optional<Task> findFirstByProjectId(UUID projectId);
    List<Task> findByProjectId(UUID projectId);
}
