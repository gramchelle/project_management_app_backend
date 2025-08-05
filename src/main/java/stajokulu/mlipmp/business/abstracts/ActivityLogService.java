package stajokulu.mlipmp.business.abstracts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import stajokulu.mlipmp.entities.concretes.ActivityLog;
import stajokulu.mlipmp.entities.dto.activitylog.ActivityDto;

public interface ActivityLogService {

    void saveActivity(ActivityDto activityDto);
    List<ActivityLog> getAllActivityLogs();
    List<ActivityLog> getActivityLogsByUserId(UUID userId);
    List<ActivityLog> getActivityLogsByTargetId(UUID targetId);
    List<ActivityLog> getActivityLogsByType(String type);
    Optional<ActivityLog> getById(UUID id);


}
