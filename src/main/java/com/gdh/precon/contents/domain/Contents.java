package com.gdh.precon.contents.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.gdh.precon.channel.domain.Channel;
import com.gdh.precon.comment.domain.Comment;
import com.gdh.precon.contentsCategory.domain.ContentsCategory;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contents {

    @Column(name = "contents_idx")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contentsIdx;

    @Column(name = "contents_title")
    private String contentsTitle;

    @Column(name = "contents_writer")
    private String contentsWriter;

    @Column(name = "contents_material")
    private String contentsMaterial;

    @Column(name = "contents_date")
    private LocalDateTime contentsDate;

    @Column(name = "contents_tag_list")
    private String contentsTagList;

    @Column(name = "contents_like")
    private String contentsLike;

    @Column(name = "contents_view_count")
    private int contentsViewCount;


    @OneToMany(mappedBy = "contents" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    private List<Comment> contentsCommentList  = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_idx")
    @JsonBackReference
    private Channel channel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contents_category_idx")
    @JsonBackReference
    private ContentsCategory contentsCategory;


    @Builder
    public Contents (String contentsTitle,String contentsWriter
        ,String contentsMaterial,List<Comment> contentsCommentList,String contentsTagList, Channel channel, ContentsCategory contentsCategory) {
        this.contentsTitle = contentsTitle;
        this.contentsWriter = contentsWriter;
        this.contentsMaterial = contentsMaterial;
        this.contentsDate = LocalDateTime.now();
        this.contentsViewCount = 0;
        this.contentsCommentList = contentsCommentList;
        this.contentsTagList = contentsTagList;
        this.channel = channel ;
        this.contentsCategory = contentsCategory;
    }
}