package com.cn.bean;

import java.util.ArrayList;
import java.util.List;

public class CetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CetExample() {
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

        public Criteria andCetnameIsNull() {
            addCriterion("cetname is null");
            return (Criteria) this;
        }

        public Criteria andCetnameIsNotNull() {
            addCriterion("cetname is not null");
            return (Criteria) this;
        }

        public Criteria andCetnameEqualTo(String value) {
            addCriterion("cetname =", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameNotEqualTo(String value) {
            addCriterion("cetname <>", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameGreaterThan(String value) {
            addCriterion("cetname >", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameGreaterThanOrEqualTo(String value) {
            addCriterion("cetname >=", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameLessThan(String value) {
            addCriterion("cetname <", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameLessThanOrEqualTo(String value) {
            addCriterion("cetname <=", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameLike(String value) {
            addCriterion("cetname like", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameNotLike(String value) {
            addCriterion("cetname not like", value, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameIn(List<String> values) {
            addCriterion("cetname in", values, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameNotIn(List<String> values) {
            addCriterion("cetname not in", values, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameBetween(String value1, String value2) {
            addCriterion("cetname between", value1, value2, "cetname");
            return (Criteria) this;
        }

        public Criteria andCetnameNotBetween(String value1, String value2) {
            addCriterion("cetname not between", value1, value2, "cetname");
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

        public Criteria andTermidIsNull() {
            addCriterion("termid is null");
            return (Criteria) this;
        }

        public Criteria andTermidIsNotNull() {
            addCriterion("termid is not null");
            return (Criteria) this;
        }

        public Criteria andTermidEqualTo(Integer value) {
            addCriterion("termid =", value, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidNotEqualTo(Integer value) {
            addCriterion("termid <>", value, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidGreaterThan(Integer value) {
            addCriterion("termid >", value, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidGreaterThanOrEqualTo(Integer value) {
            addCriterion("termid >=", value, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidLessThan(Integer value) {
            addCriterion("termid <", value, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidLessThanOrEqualTo(Integer value) {
            addCriterion("termid <=", value, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidIn(List<Integer> values) {
            addCriterion("termid in", values, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidNotIn(List<Integer> values) {
            addCriterion("termid not in", values, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidBetween(Integer value1, Integer value2) {
            addCriterion("termid between", value1, value2, "termid");
            return (Criteria) this;
        }

        public Criteria andTermidNotBetween(Integer value1, Integer value2) {
            addCriterion("termid not between", value1, value2, "termid");
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