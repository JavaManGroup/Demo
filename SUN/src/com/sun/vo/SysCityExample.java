package com.sun.vo;

import java.util.ArrayList;
import java.util.List;

public class SysCityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public SysCityExample() {
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

    public void setLimitStart(int limitStart) {
        this.limitStart=limitStart;
    }

    public int getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(int limitEnd) {
        this.limitEnd=limitEnd;
    }

    public int getLimitEnd() {
        return limitEnd;
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

        public Criteria andCityidIsNull() {
            addCriterion("cityId is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("cityId is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Integer value) {
            addCriterion("cityId =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Integer value) {
            addCriterion("cityId <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Integer value) {
            addCriterion("cityId >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cityId >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Integer value) {
            addCriterion("cityId <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Integer value) {
            addCriterion("cityId <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Integer> values) {
            addCriterion("cityId in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Integer> values) {
            addCriterion("cityId not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Integer value1, Integer value2) {
            addCriterion("cityId between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Integer value1, Integer value2) {
            addCriterion("cityId not between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNull() {
            addCriterion("cityName is null");
            return (Criteria) this;
        }

        public Criteria andCitynameIsNotNull() {
            addCriterion("cityName is not null");
            return (Criteria) this;
        }

        public Criteria andCitynameEqualTo(String value) {
            addCriterion("cityName =", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotEqualTo(String value) {
            addCriterion("cityName <>", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThan(String value) {
            addCriterion("cityName >", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameGreaterThanOrEqualTo(String value) {
            addCriterion("cityName >=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThan(String value) {
            addCriterion("cityName <", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLessThanOrEqualTo(String value) {
            addCriterion("cityName <=", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameLike(String value) {
            addCriterion("cityName like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotLike(String value) {
            addCriterion("cityName not like", value, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameIn(List<String> values) {
            addCriterion("cityName in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotIn(List<String> values) {
            addCriterion("cityName not in", values, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameBetween(String value1, String value2) {
            addCriterion("cityName between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andCitynameNotBetween(String value1, String value2) {
            addCriterion("cityName not between", value1, value2, "cityname");
            return (Criteria) this;
        }

        public Criteria andProidIsNull() {
            addCriterion("proId is null");
            return (Criteria) this;
        }

        public Criteria andProidIsNotNull() {
            addCriterion("proId is not null");
            return (Criteria) this;
        }

        public Criteria andProidEqualTo(Integer value) {
            addCriterion("proId =", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotEqualTo(Integer value) {
            addCriterion("proId <>", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThan(Integer value) {
            addCriterion("proId >", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidGreaterThanOrEqualTo(Integer value) {
            addCriterion("proId >=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThan(Integer value) {
            addCriterion("proId <", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidLessThanOrEqualTo(Integer value) {
            addCriterion("proId <=", value, "proid");
            return (Criteria) this;
        }

        public Criteria andProidIn(List<Integer> values) {
            addCriterion("proId in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotIn(List<Integer> values) {
            addCriterion("proId not in", values, "proid");
            return (Criteria) this;
        }

        public Criteria andProidBetween(Integer value1, Integer value2) {
            addCriterion("proId between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andProidNotBetween(Integer value1, Integer value2) {
            addCriterion("proId not between", value1, value2, "proid");
            return (Criteria) this;
        }

        public Criteria andKeysIsNull() {
            addCriterion("keys is null");
            return (Criteria) this;
        }

        public Criteria andKeysIsNotNull() {
            addCriterion("keys is not null");
            return (Criteria) this;
        }

        public Criteria andKeysEqualTo(String value) {
            addCriterion("keys =", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysNotEqualTo(String value) {
            addCriterion("keys <>", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysGreaterThan(String value) {
            addCriterion("keys >", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysGreaterThanOrEqualTo(String value) {
            addCriterion("keys >=", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysLessThan(String value) {
            addCriterion("keys <", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysLessThanOrEqualTo(String value) {
            addCriterion("keys <=", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysLike(String value) {
            addCriterion("keys like", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysNotLike(String value) {
            addCriterion("keys not like", value, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysIn(List<String> values) {
            addCriterion("keys in", values, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysNotIn(List<String> values) {
            addCriterion("keys not in", values, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysBetween(String value1, String value2) {
            addCriterion("keys between", value1, value2, "keys");
            return (Criteria) this;
        }

        public Criteria andKeysNotBetween(String value1, String value2) {
            addCriterion("keys not between", value1, value2, "keys");
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