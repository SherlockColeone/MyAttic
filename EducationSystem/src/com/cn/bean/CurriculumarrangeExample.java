package com.cn.bean;

import java.util.ArrayList;
import java.util.List;

public class CurriculumarrangeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CurriculumarrangeExample() {
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

        public Criteria andCoursesidIsNull() {
            addCriterion("coursesid is null");
            return (Criteria) this;
        }

        public Criteria andCoursesidIsNotNull() {
            addCriterion("coursesid is not null");
            return (Criteria) this;
        }

        public Criteria andCoursesidEqualTo(Integer value) {
            addCriterion("coursesid =", value, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidNotEqualTo(Integer value) {
            addCriterion("coursesid <>", value, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidGreaterThan(Integer value) {
            addCriterion("coursesid >", value, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("coursesid >=", value, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidLessThan(Integer value) {
            addCriterion("coursesid <", value, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidLessThanOrEqualTo(Integer value) {
            addCriterion("coursesid <=", value, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidIn(List<Integer> values) {
            addCriterion("coursesid in", values, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidNotIn(List<Integer> values) {
            addCriterion("coursesid not in", values, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidBetween(Integer value1, Integer value2) {
            addCriterion("coursesid between", value1, value2, "coursesid");
            return (Criteria) this;
        }

        public Criteria andCoursesidNotBetween(Integer value1, Integer value2) {
            addCriterion("coursesid not between", value1, value2, "coursesid");
            return (Criteria) this;
        }

        public Criteria andElectiveidIsNull() {
            addCriterion("electiveid is null");
            return (Criteria) this;
        }

        public Criteria andElectiveidIsNotNull() {
            addCriterion("electiveid is not null");
            return (Criteria) this;
        }

        public Criteria andElectiveidEqualTo(Integer value) {
            addCriterion("electiveid =", value, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidNotEqualTo(Integer value) {
            addCriterion("electiveid <>", value, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidGreaterThan(Integer value) {
            addCriterion("electiveid >", value, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidGreaterThanOrEqualTo(Integer value) {
            addCriterion("electiveid >=", value, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidLessThan(Integer value) {
            addCriterion("electiveid <", value, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidLessThanOrEqualTo(Integer value) {
            addCriterion("electiveid <=", value, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidIn(List<Integer> values) {
            addCriterion("electiveid in", values, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidNotIn(List<Integer> values) {
            addCriterion("electiveid not in", values, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidBetween(Integer value1, Integer value2) {
            addCriterion("electiveid between", value1, value2, "electiveid");
            return (Criteria) this;
        }

        public Criteria andElectiveidNotBetween(Integer value1, Integer value2) {
            addCriterion("electiveid not between", value1, value2, "electiveid");
            return (Criteria) this;
        }

        public Criteria andWeekIsNull() {
            addCriterion("week is null");
            return (Criteria) this;
        }

        public Criteria andWeekIsNotNull() {
            addCriterion("week is not null");
            return (Criteria) this;
        }

        public Criteria andWeekEqualTo(String value) {
            addCriterion("week =", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotEqualTo(String value) {
            addCriterion("week <>", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThan(String value) {
            addCriterion("week >", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekGreaterThanOrEqualTo(String value) {
            addCriterion("week >=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThan(String value) {
            addCriterion("week <", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLessThanOrEqualTo(String value) {
            addCriterion("week <=", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekLike(String value) {
            addCriterion("week like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotLike(String value) {
            addCriterion("week not like", value, "week");
            return (Criteria) this;
        }

        public Criteria andWeekIn(List<String> values) {
            addCriterion("week in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotIn(List<String> values) {
            addCriterion("week not in", values, "week");
            return (Criteria) this;
        }

        public Criteria andWeekBetween(String value1, String value2) {
            addCriterion("week between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andWeekNotBetween(String value1, String value2) {
            addCriterion("week not between", value1, value2, "week");
            return (Criteria) this;
        }

        public Criteria andDayIsNull() {
            addCriterion("day is null");
            return (Criteria) this;
        }

        public Criteria andDayIsNotNull() {
            addCriterion("day is not null");
            return (Criteria) this;
        }

        public Criteria andDayEqualTo(Integer value) {
            addCriterion("day =", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotEqualTo(Integer value) {
            addCriterion("day <>", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThan(Integer value) {
            addCriterion("day >", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("day >=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThan(Integer value) {
            addCriterion("day <", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayLessThanOrEqualTo(Integer value) {
            addCriterion("day <=", value, "day");
            return (Criteria) this;
        }

        public Criteria andDayIn(List<Integer> values) {
            addCriterion("day in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotIn(List<Integer> values) {
            addCriterion("day not in", values, "day");
            return (Criteria) this;
        }

        public Criteria andDayBetween(Integer value1, Integer value2) {
            addCriterion("day between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andDayNotBetween(Integer value1, Integer value2) {
            addCriterion("day not between", value1, value2, "day");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(String value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(String value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(String value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(String value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(String value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(String value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLike(String value) {
            addCriterion("time like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotLike(String value) {
            addCriterion("time not like", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<String> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<String> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(String value1, String value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(String value1, String value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andClassesidIsNull() {
            addCriterion("classesid is null");
            return (Criteria) this;
        }

        public Criteria andClassesidIsNotNull() {
            addCriterion("classesid is not null");
            return (Criteria) this;
        }

        public Criteria andClassesidEqualTo(Integer value) {
            addCriterion("classesid =", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidNotEqualTo(Integer value) {
            addCriterion("classesid <>", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidGreaterThan(Integer value) {
            addCriterion("classesid >", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classesid >=", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidLessThan(Integer value) {
            addCriterion("classesid <", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidLessThanOrEqualTo(Integer value) {
            addCriterion("classesid <=", value, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidIn(List<Integer> values) {
            addCriterion("classesid in", values, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidNotIn(List<Integer> values) {
            addCriterion("classesid not in", values, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidBetween(Integer value1, Integer value2) {
            addCriterion("classesid between", value1, value2, "classesid");
            return (Criteria) this;
        }

        public Criteria andClassesidNotBetween(Integer value1, Integer value2) {
            addCriterion("classesid not between", value1, value2, "classesid");
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

        public Criteria andPermitIsNull() {
            addCriterion("permit is null");
            return (Criteria) this;
        }

        public Criteria andPermitIsNotNull() {
            addCriterion("permit is not null");
            return (Criteria) this;
        }

        public Criteria andPermitEqualTo(Integer value) {
            addCriterion("permit =", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotEqualTo(Integer value) {
            addCriterion("permit <>", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitGreaterThan(Integer value) {
            addCriterion("permit >", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitGreaterThanOrEqualTo(Integer value) {
            addCriterion("permit >=", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLessThan(Integer value) {
            addCriterion("permit <", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitLessThanOrEqualTo(Integer value) {
            addCriterion("permit <=", value, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitIn(List<Integer> values) {
            addCriterion("permit in", values, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotIn(List<Integer> values) {
            addCriterion("permit not in", values, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitBetween(Integer value1, Integer value2) {
            addCriterion("permit between", value1, value2, "permit");
            return (Criteria) this;
        }

        public Criteria andPermitNotBetween(Integer value1, Integer value2) {
            addCriterion("permit not between", value1, value2, "permit");
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