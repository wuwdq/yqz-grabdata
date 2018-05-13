package com.yqz.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectCommentExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNull() {
            addCriterion("subject_id is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIsNotNull() {
            addCriterion("subject_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIdEqualTo(Long value) {
            addCriterion("subject_id =", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotEqualTo(Long value) {
            addCriterion("subject_id <>", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThan(Long value) {
            addCriterion("subject_id >", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("subject_id >=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThan(Long value) {
            addCriterion("subject_id <", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdLessThanOrEqualTo(Long value) {
            addCriterion("subject_id <=", value, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdIn(List<Long> values) {
            addCriterion("subject_id in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotIn(List<Long> values) {
            addCriterion("subject_id not in", values, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdBetween(Long value1, Long value2) {
            addCriterion("subject_id between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andSubjectIdNotBetween(Long value1, Long value2) {
            addCriterion("subject_id not between", value1, value2, "subjectId");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleIsNull() {
            addCriterion("comment_people is null");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleIsNotNull() {
            addCriterion("comment_people is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleEqualTo(String value) {
            addCriterion("comment_people =", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleNotEqualTo(String value) {
            addCriterion("comment_people <>", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleGreaterThan(String value) {
            addCriterion("comment_people >", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("comment_people >=", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleLessThan(String value) {
            addCriterion("comment_people <", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleLessThanOrEqualTo(String value) {
            addCriterion("comment_people <=", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleLike(String value) {
            addCriterion("comment_people like", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleNotLike(String value) {
            addCriterion("comment_people not like", value, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleIn(List<String> values) {
            addCriterion("comment_people in", values, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleNotIn(List<String> values) {
            addCriterion("comment_people not in", values, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleBetween(String value1, String value2) {
            addCriterion("comment_people between", value1, value2, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeopleNotBetween(String value1, String value2) {
            addCriterion("comment_people not between", value1, value2, "commentPeople");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureIsNull() {
            addCriterion("comment_people_picture is null");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureIsNotNull() {
            addCriterion("comment_people_picture is not null");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureEqualTo(String value) {
            addCriterion("comment_people_picture =", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureNotEqualTo(String value) {
            addCriterion("comment_people_picture <>", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureGreaterThan(String value) {
            addCriterion("comment_people_picture >", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureGreaterThanOrEqualTo(String value) {
            addCriterion("comment_people_picture >=", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureLessThan(String value) {
            addCriterion("comment_people_picture <", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureLessThanOrEqualTo(String value) {
            addCriterion("comment_people_picture <=", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureLike(String value) {
            addCriterion("comment_people_picture like", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureNotLike(String value) {
            addCriterion("comment_people_picture not like", value, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureIn(List<String> values) {
            addCriterion("comment_people_picture in", values, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureNotIn(List<String> values) {
            addCriterion("comment_people_picture not in", values, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureBetween(String value1, String value2) {
            addCriterion("comment_people_picture between", value1, value2, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentPeoplePictureNotBetween(String value1, String value2) {
            addCriterion("comment_people_picture not between", value1, value2, "commentPeoplePicture");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentVoteIsNull() {
            addCriterion("comment_vote is null");
            return (Criteria) this;
        }

        public Criteria andCommentVoteIsNotNull() {
            addCriterion("comment_vote is not null");
            return (Criteria) this;
        }

        public Criteria andCommentVoteEqualTo(Integer value) {
            addCriterion("comment_vote =", value, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteNotEqualTo(Integer value) {
            addCriterion("comment_vote <>", value, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteGreaterThan(Integer value) {
            addCriterion("comment_vote >", value, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_vote >=", value, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteLessThan(Integer value) {
            addCriterion("comment_vote <", value, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteLessThanOrEqualTo(Integer value) {
            addCriterion("comment_vote <=", value, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteIn(List<Integer> values) {
            addCriterion("comment_vote in", values, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteNotIn(List<Integer> values) {
            addCriterion("comment_vote not in", values, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteBetween(Integer value1, Integer value2) {
            addCriterion("comment_vote between", value1, value2, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentVoteNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_vote not between", value1, value2, "commentVote");
            return (Criteria) this;
        }

        public Criteria andCommentStarIsNull() {
            addCriterion("comment_star is null");
            return (Criteria) this;
        }

        public Criteria andCommentStarIsNotNull() {
            addCriterion("comment_star is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStarEqualTo(Integer value) {
            addCriterion("comment_star =", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotEqualTo(Integer value) {
            addCriterion("comment_star <>", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarGreaterThan(Integer value) {
            addCriterion("comment_star >", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_star >=", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarLessThan(Integer value) {
            addCriterion("comment_star <", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarLessThanOrEqualTo(Integer value) {
            addCriterion("comment_star <=", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarIn(List<Integer> values) {
            addCriterion("comment_star in", values, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotIn(List<Integer> values) {
            addCriterion("comment_star not in", values, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarBetween(Integer value1, Integer value2) {
            addCriterion("comment_star between", value1, value2, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_star not between", value1, value2, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}