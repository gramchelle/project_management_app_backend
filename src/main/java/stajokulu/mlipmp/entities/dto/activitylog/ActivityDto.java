package stajokulu.mlipmp.entities.dto.activitylog;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDto {

    private String action;
    private LocalDateTime timestamp = LocalDateTime.now();
    private UUID userId;
    private UUID targetId;
    private String type; // e.g.: 'task', 'project', 'comment'
    
}
