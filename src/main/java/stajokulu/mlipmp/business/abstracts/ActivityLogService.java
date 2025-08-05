package stajokulu.mlipmp.business.abstracts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import stajokulu.mlipmp.entities.concretes.ActivityLog;
import stajokulu.mlipmp.entities.dto.activitylog.ActivityDto;

public interface ActivityLogService {

    void saveActivity(ActivityDto activityDto); //DONE
    List<ActivityLog> getAllActivityLogs(); //DONE
    List<ActivityLog> getActivityLogsByUserId(UUID userId); //TODO: Implement this method
    List<ActivityLog> getActivityLogsByTargetId(UUID targetId); //TODO: Implement this method
    List<ActivityLog> getActivityLogsByType(String type); //TODO: Implement this method
    Optional<ActivityLog> getById(UUID id); //DONE


}
