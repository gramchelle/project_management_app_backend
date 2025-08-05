package stajokulu.mlipmp.mappers;

import stajokulu.mlipmp.entities.concretes.*;
import stajokulu.mlipmp.entities.dto.comment.*;

public class CommentMapper {

    public static Comment toEntity(CommentSaveDto dto, Task task, User author) {
        Comment comment = new Comment();
        comment.setContent(dto.getContent());
        comment.setTask(task);
        comment.setAuthor(author);
        return comment;
    }


    public static CommentSaveDto toDto(Comment comment) {
        CommentSaveDto commentSaveDto = new CommentSaveDto();
        commentSaveDto.setContent(comment.getContent());
        commentSaveDto.setTaskId(comment.getTask().getId());
        commentSaveDto.setAuthorId(comment.getAuthor().getId());

        return commentSaveDto;
    }

}
