package stajokulu.mlipmp.mappers;

import stajokulu.mlipmp.entities.concretes.ActivityLog;
import stajokulu.mlipmp.entities.dto.activitylog.ActivityDto;

public class ActivityLogMapper {

    public static ActivityLog toEntity(ActivityDto activityDto) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setType(activityDto.getType());
        activityLog.setAction(activityDto.getAction());
        activityLog.setTimestamp(activityDto.getTimestamp());

        // userId ile eşleşen User nesnesini burada set etmiyoruz çünkü User objesi dışarıdan veriliyor
        return activityLog;
    }

    public static ActivityDto toDto(ActivityLog activityLog) {
        ActivityDto activityDto = new ActivityDto();
        activityDto.setType(activityLog.getType());
        activityDto.setAction(activityLog.getAction());
        activityDto.setTimestamp(activityLog.getTimestamp());

        if (activityLog.getUser() != null) {
            activityDto.setUserId(activityLog.getUser().getId());
        }

        return activityDto;
    }
}
