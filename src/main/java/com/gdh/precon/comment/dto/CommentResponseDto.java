package com.gdh.precon.comment.dto;

import com.gdh.precon.childComment.domain.ChildComment;
import com.gdh.precon.comment.domain.Comment;
import com.gdh.precon.contents.domain.Contents;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@RequiredArgsConstructor
public class CommentResponseDto {

    private int commentIdx;
    private int commentWriterIdx;
    private String commentMaterial;
    private String commentLike;
    private List<ChildComment> childCommentList;
    private int contentsIdx;

    public CommentResponseDto(Comment comment){
        this.commentIdx = comment.getCommentIdx();
        this.commentWriterIdx = comment.getCommentWriterIdx();
        this.commentMaterial = comment.getCommentMaterial();
        this.commentLike = comment.getCommentLike();
        this.childCommentList = comment.getChildCommentList();
        if (comment.getContents()!=null) {
            this.contentsIdx = comment.getContents().getContentsIdx();
        }
        else{
            this.contentsIdx = 0;
        }
    }
}
