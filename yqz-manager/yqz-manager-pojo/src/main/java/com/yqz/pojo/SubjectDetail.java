package com.yqz.pojo;

import java.util.Date;

public class SubjectDetail {
    private Long id;

    private Long subjectId;

    private String detailTitle;

    private String detailDirectors;

    private String detailWriters;

    private String detailActors;

    private String detailReleaseYear;

    private String detailDuration;

    private String detailRegion;

    private String detailLanguages;

    private String detailTypes;

    private Long detailCommentNum;

    private String detailAliasName;

    private Float detailStar;

    private String detailStarProportion;

    private String detailBetterThan;

    private Date createDate;

    private Date updateDate;

    private String detailIntroduce;

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

    public String getDetailTitle() {
        return detailTitle;
    }

    public void setDetailTitle(String detailTitle) {
        this.detailTitle = detailTitle == null ? null : detailTitle.trim();
    }

    public String getDetailDirectors() {
        return detailDirectors;
    }

    public void setDetailDirectors(String detailDirectors) {
        this.detailDirectors = detailDirectors == null ? null : detailDirectors.trim();
    }

    public String getDetailWriters() {
        return detailWriters;
    }

    public void setDetailWriters(String detailWriters) {
        this.detailWriters = detailWriters == null ? null : detailWriters.trim();
    }

    public String getDetailActors() {
        return detailActors;
    }

    public void setDetailActors(String detailActors) {
        this.detailActors = detailActors == null ? null : detailActors.trim();
    }

    public String getDetailReleaseYear() {
        return detailReleaseYear;
    }

    public void setDetailReleaseYear(String detailReleaseYear) {
        this.detailReleaseYear = detailReleaseYear == null ? null : detailReleaseYear.trim();
    }

    public String getDetailDuration() {
        return detailDuration;
    }

    public void setDetailDuration(String detailDuration) {
        this.detailDuration = detailDuration == null ? null : detailDuration.trim();
    }

    public String getDetailRegion() {
        return detailRegion;
    }

    public void setDetailRegion(String detailRegion) {
        this.detailRegion = detailRegion == null ? null : detailRegion.trim();
    }

    public String getDetailLanguages() {
        return detailLanguages;
    }

    public void setDetailLanguages(String detailLanguages) {
        this.detailLanguages = detailLanguages == null ? null : detailLanguages.trim();
    }

    public String getDetailTypes() {
        return detailTypes;
    }

    public void setDetailTypes(String detailTypes) {
        this.detailTypes = detailTypes == null ? null : detailTypes.trim();
    }

    public Long getDetailCommentNum() {
        return detailCommentNum;
    }

    public void setDetailCommentNum(Long detailCommentNum) {
        this.detailCommentNum = detailCommentNum;
    }

    public String getDetailAliasName() {
        return detailAliasName;
    }

    public void setDetailAliasName(String detailAliasName) {
        this.detailAliasName = detailAliasName == null ? null : detailAliasName.trim();
    }

    public Float getDetailStar() {
        return detailStar;
    }

    public void setDetailStar(Float detailStar) {
        this.detailStar = detailStar;
    }

    public String getDetailStarProportion() {
        return detailStarProportion;
    }

    public void setDetailStarProportion(String detailStarProportion) {
        this.detailStarProportion = detailStarProportion == null ? null : detailStarProportion.trim();
    }

    public String getDetailBetterThan() {
        return detailBetterThan;
    }

    public void setDetailBetterThan(String detailBetterThan) {
        this.detailBetterThan = detailBetterThan == null ? null : detailBetterThan.trim();
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

    public String getDetailIntroduce() {
        return detailIntroduce;
    }

    public void setDetailIntroduce(String detailIntroduce) {
        this.detailIntroduce = detailIntroduce == null ? null : detailIntroduce.trim();
    }
}