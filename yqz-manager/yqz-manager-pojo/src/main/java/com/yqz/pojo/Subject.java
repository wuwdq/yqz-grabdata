package com.yqz.pojo;

import java.util.Date;

public class Subject {
    private Long id;

    private String subjectTitle;

    private String subjectCover;

    private String subjectType;

    private String subjectTag;

    private String subjectRate;

    private Integer subjectIsNew;

    private Integer subjectPlayable;

    private Date createDate;

    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectTitle() {
        return subjectTitle;
    }

    public void setSubjectTitle(String subjectTitle) {
        this.subjectTitle = subjectTitle == null ? null : subjectTitle.trim();
    }

    public String getSubjectCover() {
        return subjectCover;
    }

    public void setSubjectCover(String subjectCover) {
        this.subjectCover = subjectCover == null ? null : subjectCover.trim();
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public String getSubjectTag() {
        return subjectTag;
    }

    public void setSubjectTag(String subjectTag) {
        this.subjectTag = subjectTag == null ? null : subjectTag.trim();
    }

    public String getSubjectRate() {
        return subjectRate;
    }

    public void setSubjectRate(String subjectRate) {
        this.subjectRate = subjectRate == null ? null : subjectRate.trim();
    }

    public Integer getSubjectIsNew() {
        return subjectIsNew;
    }

    public void setSubjectIsNew(Integer subjectIsNew) {
        this.subjectIsNew = subjectIsNew;
    }

    public Integer getSubjectPlayable() {
        return subjectPlayable;
    }

    public void setSubjectPlayable(Integer subjectPlayable) {
        this.subjectPlayable = subjectPlayable;
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
}