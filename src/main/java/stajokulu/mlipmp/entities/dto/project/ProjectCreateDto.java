package stajokulu.mlipmp.entities.dto.project;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProjectCreateDto {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID ownerId;
}