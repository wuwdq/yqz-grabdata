package com.yqz.pojo;

import java.util.Date;

public class SubjectComment {
    private Long id;

    private Long subjectId;

    private String commentPeople;

    private String commentPeoplePicture;

    private Date commentTime;

    private Integer commentVote;

    private Integer commentStar;

    private Date createDate;

    private Date updateDate;

    private String commentInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getCommentPeople() {
        return commentPeople;
    }

    public void setCommentPeople(String commentPeople) {
        this.commentPeople = commentPeople == null ? null : commentPeople.trim();
    }

    public String getCommentPeoplePicture() {
        return commentPeoplePicture;
    }

    public void setCommentPeoplePicture(String commentPeoplePicture) {
        this.commentPeoplePicture = commentPeoplePicture == null ? null : commentPeoplePicture.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentVote() {
        return commentVote;
    }

    public void setCommentVote(Integer commentVote) {
        this.commentVote = commentVote;
    }

    public Integer getCommentStar() {
        return commentStar;
    }

    public void setCommentStar(Integer commentStar) {
        this.commentStar = commentStar;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo == null ? null : commentInfo.trim();
    }
}