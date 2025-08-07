package stajokulu.mlipmp.api.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import lombok.RequiredArgsConstructor;
import stajokulu.mlipmp.business.abstracts.ActivityLogService;
import stajokulu.mlipmp.entities.concretes.ActivityLog;
import stajokulu.mlipmp.entities.dto.activitylog.ActivityDto;
import stajokulu.mlipmp.mappers.ActivityLogMapper;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/activitylogs")
public class ActivityLogController {
    
    //@Autowired
    private final ActivityLogService activityLogService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ActivityDto>> getAllActivityLogs() {
        List<ActivityLog> activityLogs = activityLogService.getAllActivityLogs();
        List<ActivityDto> activityDtos = activityLogs.stream()
                .map(ActivityLogMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(activityDtos, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveActivity(@RequestBody ActivityDto activityDto){
        try {
            activityLogService.saveActivity(activityDto);
            return new ResponseEntity<>("Activity log saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println("HATA: ActivityLogController - SaveActivity: " + e.getMessage());
            throw new RuntimeException("Failed to save activity log", e);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ActivityDto> getActivityLogById(@PathVariable UUID id) {
        Optional<ActivityLog> activityLog = activityLogService.getById(id);
        return activityLog.map(log -> new ResponseEntity<>(ActivityLogMapper.toDto(log), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


}