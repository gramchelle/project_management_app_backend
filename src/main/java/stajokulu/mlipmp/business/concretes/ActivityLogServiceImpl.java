package stajokulu.mlipmp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.ActivityLogService;
import stajokulu.mlipmp.entities.concretes.ActivityLog;
import stajokulu.mlipmp.entities.concretes.User;
import stajokulu.mlipmp.entities.dto.activitylog.ActivityDto;
import stajokulu.mlipmp.mappers.ActivityLogMapper;
import stajokulu.mlipmp.repository.ActivityLogRepository;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    @Override
    public void saveActivity(ActivityDto activityDto) {
        System.out.println("HATIRLATMA: ActivityLogServiceImpl works as intended.");
        ActivityLog activityLog = ActivityLogMapper.toEntity(activityDto);

        if (activityDto.getUserId() != null) {
            User user = new User();
            user.setId(activityDto.getUserId());  // DTO'dan gelen UUID ile set ediyoruz
            activityLog.setUser(user);
        }

        activityLogRepository.save(activityLog);
    }

    @Override
    public List<ActivityLog> getAllActivityLogs(){
        return activityLogRepository.findAll();
    }

    @Override
    public Optional<ActivityLog> getById(UUID id) {
        return activityLogRepository.findById(id);
    }

    @Override
    public List<ActivityLog> getActivityLogsByUserId(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivityLogsByUserId'");
    }

    @Override
    public List<ActivityLog> getActivityLogsByTargetId(UUID targetId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivityLogsByTargetId'");
    }

    @Override
    public List<ActivityLog> getActivityLogsByType(String type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActivityLogsByType'");
    }

}
