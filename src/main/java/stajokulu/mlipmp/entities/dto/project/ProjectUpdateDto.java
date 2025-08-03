package stajokulu.mlipmp.entities.dto.project;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;

@Data
public class ProjectUpdateDto {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private UUID ownerId;
}
