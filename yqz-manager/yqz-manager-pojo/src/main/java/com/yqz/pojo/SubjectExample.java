package com.yqz.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectExample() {
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

        public Criteria andSubjectTitleIsNull() {
            addCriterion("subject_title is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleIsNotNull() {
            addCriterion("subject_title is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleEqualTo(String value) {
            addCriterion("subject_title =", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleNotEqualTo(String value) {
            addCriterion("subject_title <>", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleGreaterThan(String value) {
            addCriterion("subject_title >", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleGreaterThanOrEqualTo(String value) {
            addCriterion("subject_title >=", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleLessThan(String value) {
            addCriterion("subject_title <", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleLessThanOrEqualTo(String value) {
            addCriterion("subject_title <=", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleLike(String value) {
            addCriterion("subject_title like", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleNotLike(String value) {
            addCriterion("subject_title not like", value, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleIn(List<String> values) {
            addCriterion("subject_title in", values, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleNotIn(List<String> values) {
            addCriterion("subject_title not in", values, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleBetween(String value1, String value2) {
            addCriterion("subject_title between", value1, value2, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectTitleNotBetween(String value1, String value2) {
            addCriterion("subject_title not between", value1, value2, "subjectTitle");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverIsNull() {
            addCriterion("subject_cover is null");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverIsNotNull() {
            addCriterion("subject_cover is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverEqualTo(String value) {
            addCriterion("subject_cover =", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverNotEqualTo(String value) {
            addCriterion("subject_cover <>", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverGreaterThan(String value) {
            addCriterion("subject_cover >", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverGreaterThanOrEqualTo(String value) {
            addCriterion("subject_cover >=", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverLessThan(String value) {
            addCriterion("subject_cover <", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverLessThanOrEqualTo(String value) {
            addCriterion("subject_cover <=", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverLike(String value) {
            addCriterion("subject_cover like", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverNotLike(String value) {
            addCriterion("subject_cover not like", value, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverIn(List<String> values) {
            addCriterion("subject_cover in", values, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverNotIn(List<String> values) {
            addCriterion("subject_cover not in", values, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverBetween(String value1, String value2) {
            addCriterion("subject_cover between", value1, value2, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectCoverNotBetween(String value1, String value2) {
            addCriterion("subject_cover not between", value1, value2, "subjectCover");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("subject_type is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("subject_type is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(String value) {
            addCriterion("subject_type =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(String value) {
            addCriterion("subject_type <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(String value) {
            addCriterion("subject_type >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("subject_type >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(String value) {
            addCriterion("subject_type <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(String value) {
            addCriterion("subject_type <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLike(String value) {
            addCriterion("subject_type like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotLike(String value) {
            addCriterion("subject_type not like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<String> values) {
            addCriterion("subject_type in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<String> values) {
            addCriterion("subject_type not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(String value1, String value2) {
            addCriterion("subject_type between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(String value1, String value2) {
            addCriterion("subject_type not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTagIsNull() {
            addCriterion("subject_tag is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTagIsNotNull() {
            addCriterion("subject_tag is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTagEqualTo(String value) {
            addCriterion("subject_tag =", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagNotEqualTo(String value) {
            addCriterion("subject_tag <>", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagGreaterThan(String value) {
            addCriterion("subject_tag >", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagGreaterThanOrEqualTo(String value) {
            addCriterion("subject_tag >=", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagLessThan(String value) {
            addCriterion("subject_tag <", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagLessThanOrEqualTo(String value) {
            addCriterion("subject_tag <=", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagLike(String value) {
            addCriterion("subject_tag like", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagNotLike(String value) {
            addCriterion("subject_tag not like", value, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagIn(List<String> values) {
            addCriterion("subject_tag in", values, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagNotIn(List<String> values) {
            addCriterion("subject_tag not in", values, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagBetween(String value1, String value2) {
            addCriterion("subject_tag between", value1, value2, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectTagNotBetween(String value1, String value2) {
            addCriterion("subject_tag not between", value1, value2, "subjectTag");
            return (Criteria) this;
        }

        public Criteria andSubjectRateIsNull() {
            addCriterion("subject_rate is null");
            return (Criteria) this;
        }

        public Criteria andSubjectRateIsNotNull() {
            addCriterion("subject_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectRateEqualTo(String value) {
            addCriterion("subject_rate =", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateNotEqualTo(String value) {
            addCriterion("subject_rate <>", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateGreaterThan(String value) {
            addCriterion("subject_rate >", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateGreaterThanOrEqualTo(String value) {
            addCriterion("subject_rate >=", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateLessThan(String value) {
            addCriterion("subject_rate <", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateLessThanOrEqualTo(String value) {
            addCriterion("subject_rate <=", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateLike(String value) {
            addCriterion("subject_rate like", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateNotLike(String value) {
            addCriterion("subject_rate not like", value, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateIn(List<String> values) {
            addCriterion("subject_rate in", values, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateNotIn(List<String> values) {
            addCriterion("subject_rate not in", values, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateBetween(String value1, String value2) {
            addCriterion("subject_rate between", value1, value2, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectRateNotBetween(String value1, String value2) {
            addCriterion("subject_rate not between", value1, value2, "subjectRate");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewIsNull() {
            addCriterion("subject_is_new is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewIsNotNull() {
            addCriterion("subject_is_new is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewEqualTo(Integer value) {
            addCriterion("subject_is_new =", value, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewNotEqualTo(Integer value) {
            addCriterion("subject_is_new <>", value, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewGreaterThan(Integer value) {
            addCriterion("subject_is_new >", value, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_is_new >=", value, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewLessThan(Integer value) {
            addCriterion("subject_is_new <", value, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewLessThanOrEqualTo(Integer value) {
            addCriterion("subject_is_new <=", value, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewIn(List<Integer> values) {
            addCriterion("subject_is_new in", values, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewNotIn(List<Integer> values) {
            addCriterion("subject_is_new not in", values, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewBetween(Integer value1, Integer value2) {
            addCriterion("subject_is_new between", value1, value2, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNewNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_is_new not between", value1, value2, "subjectIsNew");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableIsNull() {
            addCriterion("subject_playable is null");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableIsNotNull() {
            addCriterion("subject_playable is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableEqualTo(Integer value) {
            addCriterion("subject_playable =", value, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableNotEqualTo(Integer value) {
            addCriterion("subject_playable <>", value, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableGreaterThan(Integer value) {
            addCriterion("subject_playable >", value, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableGreaterThanOrEqualTo(Integer value) {
            addCriterion("subject_playable >=", value, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableLessThan(Integer value) {
            addCriterion("subject_playable <", value, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableLessThanOrEqualTo(Integer value) {
            addCriterion("subject_playable <=", value, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableIn(List<Integer> values) {
            addCriterion("subject_playable in", values, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableNotIn(List<Integer> values) {
            addCriterion("subject_playable not in", values, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableBetween(Integer value1, Integer value2) {
            addCriterion("subject_playable between", value1, value2, "subjectPlayable");
            return (Criteria) this;
        }

        public Criteria andSubjectPlayableNotBetween(Integer value1, Integer value2) {
            addCriterion("subject_playable not between", value1, value2, "subjectPlayable");
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