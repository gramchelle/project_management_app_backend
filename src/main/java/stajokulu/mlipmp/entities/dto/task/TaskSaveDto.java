package stajokulu.mlipmp.entities.dto.task;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class TaskSaveDto {

    private String title;
    private String description;
    private LocalDate deadline;
    private String status = "CREATED";

    private UUID assigneeId; //User entity should be defined in the same package or imported
    private UUID projectId; //Project entity should be defined in the same package or imported
}
