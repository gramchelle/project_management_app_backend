package stajokulu.mlipmp.entities.dto.comment;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentSaveDto {

    String content;
    UUID taskId;
    UUID authorId;

}
