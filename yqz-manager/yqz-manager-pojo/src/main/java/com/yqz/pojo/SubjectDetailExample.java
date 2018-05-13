package com.yqz.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubjectDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SubjectDetailExample() {
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

        public Criteria andDetailTitleIsNull() {
            addCriterion("detail_title is null");
            return (Criteria) this;
        }

        public Criteria andDetailTitleIsNotNull() {
            addCriterion("detail_title is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTitleEqualTo(String value) {
            addCriterion("detail_title =", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotEqualTo(String value) {
            addCriterion("detail_title <>", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleGreaterThan(String value) {
            addCriterion("detail_title >", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleGreaterThanOrEqualTo(String value) {
            addCriterion("detail_title >=", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleLessThan(String value) {
            addCriterion("detail_title <", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleLessThanOrEqualTo(String value) {
            addCriterion("detail_title <=", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleLike(String value) {
            addCriterion("detail_title like", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotLike(String value) {
            addCriterion("detail_title not like", value, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleIn(List<String> values) {
            addCriterion("detail_title in", values, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotIn(List<String> values) {
            addCriterion("detail_title not in", values, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleBetween(String value1, String value2) {
            addCriterion("detail_title between", value1, value2, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailTitleNotBetween(String value1, String value2) {
            addCriterion("detail_title not between", value1, value2, "detailTitle");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsIsNull() {
            addCriterion("detail_directors is null");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsIsNotNull() {
            addCriterion("detail_directors is not null");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsEqualTo(String value) {
            addCriterion("detail_directors =", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsNotEqualTo(String value) {
            addCriterion("detail_directors <>", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsGreaterThan(String value) {
            addCriterion("detail_directors >", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsGreaterThanOrEqualTo(String value) {
            addCriterion("detail_directors >=", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsLessThan(String value) {
            addCriterion("detail_directors <", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsLessThanOrEqualTo(String value) {
            addCriterion("detail_directors <=", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsLike(String value) {
            addCriterion("detail_directors like", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsNotLike(String value) {
            addCriterion("detail_directors not like", value, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsIn(List<String> values) {
            addCriterion("detail_directors in", values, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsNotIn(List<String> values) {
            addCriterion("detail_directors not in", values, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsBetween(String value1, String value2) {
            addCriterion("detail_directors between", value1, value2, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailDirectorsNotBetween(String value1, String value2) {
            addCriterion("detail_directors not between", value1, value2, "detailDirectors");
            return (Criteria) this;
        }

        public Criteria andDetailWritersIsNull() {
            addCriterion("detail_writers is null");
            return (Criteria) this;
        }

        public Criteria andDetailWritersIsNotNull() {
            addCriterion("detail_writers is not null");
            return (Criteria) this;
        }

        public Criteria andDetailWritersEqualTo(String value) {
            addCriterion("detail_writers =", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersNotEqualTo(String value) {
            addCriterion("detail_writers <>", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersGreaterThan(String value) {
            addCriterion("detail_writers >", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersGreaterThanOrEqualTo(String value) {
            addCriterion("detail_writers >=", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersLessThan(String value) {
            addCriterion("detail_writers <", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersLessThanOrEqualTo(String value) {
            addCriterion("detail_writers <=", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersLike(String value) {
            addCriterion("detail_writers like", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersNotLike(String value) {
            addCriterion("detail_writers not like", value, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersIn(List<String> values) {
            addCriterion("detail_writers in", values, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersNotIn(List<String> values) {
            addCriterion("detail_writers not in", values, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersBetween(String value1, String value2) {
            addCriterion("detail_writers between", value1, value2, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailWritersNotBetween(String value1, String value2) {
            addCriterion("detail_writers not between", value1, value2, "detailWriters");
            return (Criteria) this;
        }

        public Criteria andDetailActorsIsNull() {
            addCriterion("detail_actors is null");
            return (Criteria) this;
        }

        public Criteria andDetailActorsIsNotNull() {
            addCriterion("detail_actors is not null");
            return (Criteria) this;
        }

        public Criteria andDetailActorsEqualTo(String value) {
            addCriterion("detail_actors =", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsNotEqualTo(String value) {
            addCriterion("detail_actors <>", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsGreaterThan(String value) {
            addCriterion("detail_actors >", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsGreaterThanOrEqualTo(String value) {
            addCriterion("detail_actors >=", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsLessThan(String value) {
            addCriterion("detail_actors <", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsLessThanOrEqualTo(String value) {
            addCriterion("detail_actors <=", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsLike(String value) {
            addCriterion("detail_actors like", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsNotLike(String value) {
            addCriterion("detail_actors not like", value, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsIn(List<String> values) {
            addCriterion("detail_actors in", values, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsNotIn(List<String> values) {
            addCriterion("detail_actors not in", values, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsBetween(String value1, String value2) {
            addCriterion("detail_actors between", value1, value2, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailActorsNotBetween(String value1, String value2) {
            addCriterion("detail_actors not between", value1, value2, "detailActors");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearIsNull() {
            addCriterion("detail_release_year is null");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearIsNotNull() {
            addCriterion("detail_release_year is not null");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearEqualTo(String value) {
            addCriterion("detail_release_year =", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearNotEqualTo(String value) {
            addCriterion("detail_release_year <>", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearGreaterThan(String value) {
            addCriterion("detail_release_year >", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearGreaterThanOrEqualTo(String value) {
            addCriterion("detail_release_year >=", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearLessThan(String value) {
            addCriterion("detail_release_year <", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearLessThanOrEqualTo(String value) {
            addCriterion("detail_release_year <=", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearLike(String value) {
            addCriterion("detail_release_year like", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearNotLike(String value) {
            addCriterion("detail_release_year not like", value, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearIn(List<String> values) {
            addCriterion("detail_release_year in", values, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearNotIn(List<String> values) {
            addCriterion("detail_release_year not in", values, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearBetween(String value1, String value2) {
            addCriterion("detail_release_year between", value1, value2, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailReleaseYearNotBetween(String value1, String value2) {
            addCriterion("detail_release_year not between", value1, value2, "detailReleaseYear");
            return (Criteria) this;
        }

        public Criteria andDetailDurationIsNull() {
            addCriterion("detail_duration is null");
            return (Criteria) this;
        }

        public Criteria andDetailDurationIsNotNull() {
            addCriterion("detail_duration is not null");
            return (Criteria) this;
        }

        public Criteria andDetailDurationEqualTo(String value) {
            addCriterion("detail_duration =", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationNotEqualTo(String value) {
            addCriterion("detail_duration <>", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationGreaterThan(String value) {
            addCriterion("detail_duration >", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationGreaterThanOrEqualTo(String value) {
            addCriterion("detail_duration >=", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationLessThan(String value) {
            addCriterion("detail_duration <", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationLessThanOrEqualTo(String value) {
            addCriterion("detail_duration <=", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationLike(String value) {
            addCriterion("detail_duration like", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationNotLike(String value) {
            addCriterion("detail_duration not like", value, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationIn(List<String> values) {
            addCriterion("detail_duration in", values, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationNotIn(List<String> values) {
            addCriterion("detail_duration not in", values, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationBetween(String value1, String value2) {
            addCriterion("detail_duration between", value1, value2, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailDurationNotBetween(String value1, String value2) {
            addCriterion("detail_duration not between", value1, value2, "detailDuration");
            return (Criteria) this;
        }

        public Criteria andDetailRegionIsNull() {
            addCriterion("detail_region is null");
            return (Criteria) this;
        }

        public Criteria andDetailRegionIsNotNull() {
            addCriterion("detail_region is not null");
            return (Criteria) this;
        }

        public Criteria andDetailRegionEqualTo(String value) {
            addCriterion("detail_region =", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionNotEqualTo(String value) {
            addCriterion("detail_region <>", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionGreaterThan(String value) {
            addCriterion("detail_region >", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionGreaterThanOrEqualTo(String value) {
            addCriterion("detail_region >=", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionLessThan(String value) {
            addCriterion("detail_region <", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionLessThanOrEqualTo(String value) {
            addCriterion("detail_region <=", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionLike(String value) {
            addCriterion("detail_region like", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionNotLike(String value) {
            addCriterion("detail_region not like", value, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionIn(List<String> values) {
            addCriterion("detail_region in", values, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionNotIn(List<String> values) {
            addCriterion("detail_region not in", values, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionBetween(String value1, String value2) {
            addCriterion("detail_region between", value1, value2, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailRegionNotBetween(String value1, String value2) {
            addCriterion("detail_region not between", value1, value2, "detailRegion");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesIsNull() {
            addCriterion("detail_languages is null");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesIsNotNull() {
            addCriterion("detail_languages is not null");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesEqualTo(String value) {
            addCriterion("detail_languages =", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesNotEqualTo(String value) {
            addCriterion("detail_languages <>", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesGreaterThan(String value) {
            addCriterion("detail_languages >", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesGreaterThanOrEqualTo(String value) {
            addCriterion("detail_languages >=", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesLessThan(String value) {
            addCriterion("detail_languages <", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesLessThanOrEqualTo(String value) {
            addCriterion("detail_languages <=", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesLike(String value) {
            addCriterion("detail_languages like", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesNotLike(String value) {
            addCriterion("detail_languages not like", value, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesIn(List<String> values) {
            addCriterion("detail_languages in", values, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesNotIn(List<String> values) {
            addCriterion("detail_languages not in", values, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesBetween(String value1, String value2) {
            addCriterion("detail_languages between", value1, value2, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailLanguagesNotBetween(String value1, String value2) {
            addCriterion("detail_languages not between", value1, value2, "detailLanguages");
            return (Criteria) this;
        }

        public Criteria andDetailTypesIsNull() {
            addCriterion("detail_types is null");
            return (Criteria) this;
        }

        public Criteria andDetailTypesIsNotNull() {
            addCriterion("detail_types is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTypesEqualTo(String value) {
            addCriterion("detail_types =", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesNotEqualTo(String value) {
            addCriterion("detail_types <>", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesGreaterThan(String value) {
            addCriterion("detail_types >", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesGreaterThanOrEqualTo(String value) {
            addCriterion("detail_types >=", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesLessThan(String value) {
            addCriterion("detail_types <", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesLessThanOrEqualTo(String value) {
            addCriterion("detail_types <=", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesLike(String value) {
            addCriterion("detail_types like", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesNotLike(String value) {
            addCriterion("detail_types not like", value, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesIn(List<String> values) {
            addCriterion("detail_types in", values, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesNotIn(List<String> values) {
            addCriterion("detail_types not in", values, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesBetween(String value1, String value2) {
            addCriterion("detail_types between", value1, value2, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailTypesNotBetween(String value1, String value2) {
            addCriterion("detail_types not between", value1, value2, "detailTypes");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumIsNull() {
            addCriterion("detail_comment_num is null");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumIsNotNull() {
            addCriterion("detail_comment_num is not null");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumEqualTo(Long value) {
            addCriterion("detail_comment_num =", value, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumNotEqualTo(Long value) {
            addCriterion("detail_comment_num <>", value, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumGreaterThan(Long value) {
            addCriterion("detail_comment_num >", value, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_comment_num >=", value, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumLessThan(Long value) {
            addCriterion("detail_comment_num <", value, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumLessThanOrEqualTo(Long value) {
            addCriterion("detail_comment_num <=", value, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumIn(List<Long> values) {
            addCriterion("detail_comment_num in", values, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumNotIn(List<Long> values) {
            addCriterion("detail_comment_num not in", values, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumBetween(Long value1, Long value2) {
            addCriterion("detail_comment_num between", value1, value2, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailCommentNumNotBetween(Long value1, Long value2) {
            addCriterion("detail_comment_num not between", value1, value2, "detailCommentNum");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameIsNull() {
            addCriterion("detail_alias_name is null");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameIsNotNull() {
            addCriterion("detail_alias_name is not null");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameEqualTo(String value) {
            addCriterion("detail_alias_name =", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameNotEqualTo(String value) {
            addCriterion("detail_alias_name <>", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameGreaterThan(String value) {
            addCriterion("detail_alias_name >", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameGreaterThanOrEqualTo(String value) {
            addCriterion("detail_alias_name >=", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameLessThan(String value) {
            addCriterion("detail_alias_name <", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameLessThanOrEqualTo(String value) {
            addCriterion("detail_alias_name <=", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameLike(String value) {
            addCriterion("detail_alias_name like", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameNotLike(String value) {
            addCriterion("detail_alias_name not like", value, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameIn(List<String> values) {
            addCriterion("detail_alias_name in", values, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameNotIn(List<String> values) {
            addCriterion("detail_alias_name not in", values, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameBetween(String value1, String value2) {
            addCriterion("detail_alias_name between", value1, value2, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailAliasNameNotBetween(String value1, String value2) {
            addCriterion("detail_alias_name not between", value1, value2, "detailAliasName");
            return (Criteria) this;
        }

        public Criteria andDetailStarIsNull() {
            addCriterion("detail_star is null");
            return (Criteria) this;
        }

        public Criteria andDetailStarIsNotNull() {
            addCriterion("detail_star is not null");
            return (Criteria) this;
        }

        public Criteria andDetailStarEqualTo(Float value) {
            addCriterion("detail_star =", value, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarNotEqualTo(Float value) {
            addCriterion("detail_star <>", value, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarGreaterThan(Float value) {
            addCriterion("detail_star >", value, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarGreaterThanOrEqualTo(Float value) {
            addCriterion("detail_star >=", value, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarLessThan(Float value) {
            addCriterion("detail_star <", value, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarLessThanOrEqualTo(Float value) {
            addCriterion("detail_star <=", value, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarIn(List<Float> values) {
            addCriterion("detail_star in", values, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarNotIn(List<Float> values) {
            addCriterion("detail_star not in", values, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarBetween(Float value1, Float value2) {
            addCriterion("detail_star between", value1, value2, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarNotBetween(Float value1, Float value2) {
            addCriterion("detail_star not between", value1, value2, "detailStar");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionIsNull() {
            addCriterion("detail_star_proportion is null");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionIsNotNull() {
            addCriterion("detail_star_proportion is not null");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionEqualTo(String value) {
            addCriterion("detail_star_proportion =", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionNotEqualTo(String value) {
            addCriterion("detail_star_proportion <>", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionGreaterThan(String value) {
            addCriterion("detail_star_proportion >", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionGreaterThanOrEqualTo(String value) {
            addCriterion("detail_star_proportion >=", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionLessThan(String value) {
            addCriterion("detail_star_proportion <", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionLessThanOrEqualTo(String value) {
            addCriterion("detail_star_proportion <=", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionLike(String value) {
            addCriterion("detail_star_proportion like", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionNotLike(String value) {
            addCriterion("detail_star_proportion not like", value, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionIn(List<String> values) {
            addCriterion("detail_star_proportion in", values, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionNotIn(List<String> values) {
            addCriterion("detail_star_proportion not in", values, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionBetween(String value1, String value2) {
            addCriterion("detail_star_proportion between", value1, value2, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailStarProportionNotBetween(String value1, String value2) {
            addCriterion("detail_star_proportion not between", value1, value2, "detailStarProportion");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanIsNull() {
            addCriterion("detail_better_than is null");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanIsNotNull() {
            addCriterion("detail_better_than is not null");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanEqualTo(String value) {
            addCriterion("detail_better_than =", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanNotEqualTo(String value) {
            addCriterion("detail_better_than <>", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanGreaterThan(String value) {
            addCriterion("detail_better_than >", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanGreaterThanOrEqualTo(String value) {
            addCriterion("detail_better_than >=", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanLessThan(String value) {
            addCriterion("detail_better_than <", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanLessThanOrEqualTo(String value) {
            addCriterion("detail_better_than <=", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanLike(String value) {
            addCriterion("detail_better_than like", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanNotLike(String value) {
            addCriterion("detail_better_than not like", value, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanIn(List<String> values) {
            addCriterion("detail_better_than in", values, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanNotIn(List<String> values) {
            addCriterion("detail_better_than not in", values, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanBetween(String value1, String value2) {
            addCriterion("detail_better_than between", value1, value2, "detailBetterThan");
            return (Criteria) this;
        }

        public Criteria andDetailBetterThanNotBetween(String value1, String value2) {
            addCriterion("detail_better_than not between", value1, value2, "detailBetterThan");
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