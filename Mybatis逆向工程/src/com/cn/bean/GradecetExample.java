package com.cn.bean;

import java.util.ArrayList;
import java.util.List;

public class GradecetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GradecetExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNull() {
            addCriterion("studentid is null");
            return (Criteria) this;
        }

        public Criteria andStudentidIsNotNull() {
            addCriterion("studentid is not null");
            return (Criteria) this;
        }

        public Criteria andStudentidEqualTo(Integer value) {
            addCriterion("studentid =", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotEqualTo(Integer value) {
            addCriterion("studentid <>", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThan(Integer value) {
            addCriterion("studentid >", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("studentid >=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThan(Integer value) {
            addCriterion("studentid <", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidLessThanOrEqualTo(Integer value) {
            addCriterion("studentid <=", value, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidIn(List<Integer> values) {
            addCriterion("studentid in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotIn(List<Integer> values) {
            addCriterion("studentid not in", values, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidBetween(Integer value1, Integer value2) {
            addCriterion("studentid between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andStudentidNotBetween(Integer value1, Integer value2) {
            addCriterion("studentid not between", value1, value2, "studentid");
            return (Criteria) this;
        }

        public Criteria andCetidIsNull() {
            addCriterion("cetid is null");
            return (Criteria) this;
        }

        public Criteria andCetidIsNotNull() {
            addCriterion("cetid is not null");
            return (Criteria) this;
        }

        public Criteria andCetidEqualTo(Integer value) {
            addCriterion("cetid =", value, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidNotEqualTo(Integer value) {
            addCriterion("cetid <>", value, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidGreaterThan(Integer value) {
            addCriterion("cetid >", value, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cetid >=", value, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidLessThan(Integer value) {
            addCriterion("cetid <", value, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidLessThanOrEqualTo(Integer value) {
            addCriterion("cetid <=", value, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidIn(List<Integer> values) {
            addCriterion("cetid in", values, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidNotIn(List<Integer> values) {
            addCriterion("cetid not in", values, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidBetween(Integer value1, Integer value2) {
            addCriterion("cetid between", value1, value2, "cetid");
            return (Criteria) this;
        }

        public Criteria andCetidNotBetween(Integer value1, Integer value2) {
            addCriterion("cetid not between", value1, value2, "cetid");
            return (Criteria) this;
        }

        public Criteria andCettimeIsNull() {
            addCriterion("cettime is null");
            return (Criteria) this;
        }

        public Criteria andCettimeIsNotNull() {
            addCriterion("cettime is not null");
            return (Criteria) this;
        }

        public Criteria andCettimeEqualTo(String value) {
            addCriterion("cettime =", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeNotEqualTo(String value) {
            addCriterion("cettime <>", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeGreaterThan(String value) {
            addCriterion("cettime >", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeGreaterThanOrEqualTo(String value) {
            addCriterion("cettime >=", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeLessThan(String value) {
            addCriterion("cettime <", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeLessThanOrEqualTo(String value) {
            addCriterion("cettime <=", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeLike(String value) {
            addCriterion("cettime like", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeNotLike(String value) {
            addCriterion("cettime not like", value, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeIn(List<String> values) {
            addCriterion("cettime in", values, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeNotIn(List<String> values) {
            addCriterion("cettime not in", values, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeBetween(String value1, String value2) {
            addCriterion("cettime between", value1, value2, "cettime");
            return (Criteria) this;
        }

        public Criteria andCettimeNotBetween(String value1, String value2) {
            addCriterion("cettime not between", value1, value2, "cettime");
            return (Criteria) this;
        }

        public Criteria andCetscoreIsNull() {
            addCriterion("cetscore is null");
            return (Criteria) this;
        }

        public Criteria andCetscoreIsNotNull() {
            addCriterion("cetscore is not null");
            return (Criteria) this;
        }

        public Criteria andCetscoreEqualTo(Integer value) {
            addCriterion("cetscore =", value, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreNotEqualTo(Integer value) {
            addCriterion("cetscore <>", value, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreGreaterThan(Integer value) {
            addCriterion("cetscore >", value, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("cetscore >=", value, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreLessThan(Integer value) {
            addCriterion("cetscore <", value, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreLessThanOrEqualTo(Integer value) {
            addCriterion("cetscore <=", value, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreIn(List<Integer> values) {
            addCriterion("cetscore in", values, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreNotIn(List<Integer> values) {
            addCriterion("cetscore not in", values, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreBetween(Integer value1, Integer value2) {
            addCriterion("cetscore between", value1, value2, "cetscore");
            return (Criteria) this;
        }

        public Criteria andCetscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("cetscore not between", value1, value2, "cetscore");
            return (Criteria) this;
        }

        public Criteria andClassroomidIsNull() {
            addCriterion("classroomid is null");
            return (Criteria) this;
        }

        public Criteria andClassroomidIsNotNull() {
            addCriterion("classroomid is not null");
            return (Criteria) this;
        }

        public Criteria andClassroomidEqualTo(Integer value) {
            addCriterion("classroomid =", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidNotEqualTo(Integer value) {
            addCriterion("classroomid <>", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidGreaterThan(Integer value) {
            addCriterion("classroomid >", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classroomid >=", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidLessThan(Integer value) {
            addCriterion("classroomid <", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidLessThanOrEqualTo(Integer value) {
            addCriterion("classroomid <=", value, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidIn(List<Integer> values) {
            addCriterion("classroomid in", values, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidNotIn(List<Integer> values) {
            addCriterion("classroomid not in", values, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidBetween(Integer value1, Integer value2) {
            addCriterion("classroomid between", value1, value2, "classroomid");
            return (Criteria) this;
        }

        public Criteria andClassroomidNotBetween(Integer value1, Integer value2) {
            addCriterion("classroomid not between", value1, value2, "classroomid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNull() {
            addCriterion("teacherid is null");
            return (Criteria) this;
        }

        public Criteria andTeacheridIsNotNull() {
            addCriterion("teacherid is not null");
            return (Criteria) this;
        }

        public Criteria andTeacheridEqualTo(Integer value) {
            addCriterion("teacherid =", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotEqualTo(Integer value) {
            addCriterion("teacherid <>", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThan(Integer value) {
            addCriterion("teacherid >", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacherid >=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThan(Integer value) {
            addCriterion("teacherid <", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridLessThanOrEqualTo(Integer value) {
            addCriterion("teacherid <=", value, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridIn(List<Integer> values) {
            addCriterion("teacherid in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotIn(List<Integer> values) {
            addCriterion("teacherid not in", values, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridBetween(Integer value1, Integer value2) {
            addCriterion("teacherid between", value1, value2, "teacherid");
            return (Criteria) this;
        }

        public Criteria andTeacheridNotBetween(Integer value1, Integer value2) {
            addCriterion("teacherid not between", value1, value2, "teacherid");
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