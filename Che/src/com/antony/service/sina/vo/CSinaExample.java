package com.antony.service.sina.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CSinaExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CSinaExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(BigDecimal value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(BigDecimal value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(BigDecimal value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(BigDecimal value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<BigDecimal> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<BigDecimal> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSinaIdIsNull() {
            addCriterion("SINA_ID is null");
            return (Criteria) this;
        }

        public Criteria andSinaIdIsNotNull() {
            addCriterion("SINA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSinaIdEqualTo(String value) {
            addCriterion("SINA_ID =", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdNotEqualTo(String value) {
            addCriterion("SINA_ID <>", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdGreaterThan(String value) {
            addCriterion("SINA_ID >", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_ID >=", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdLessThan(String value) {
            addCriterion("SINA_ID <", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdLessThanOrEqualTo(String value) {
            addCriterion("SINA_ID <=", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdLike(String value) {
            addCriterion("SINA_ID like", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdNotLike(String value) {
            addCriterion("SINA_ID not like", value, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdIn(List<String> values) {
            addCriterion("SINA_ID in", values, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdNotIn(List<String> values) {
            addCriterion("SINA_ID not in", values, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdBetween(String value1, String value2) {
            addCriterion("SINA_ID between", value1, value2, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaIdNotBetween(String value1, String value2) {
            addCriterion("SINA_ID not between", value1, value2, "sinaId");
            return (Criteria) this;
        }

        public Criteria andSinaNickIsNull() {
            addCriterion("SINA_NICK is null");
            return (Criteria) this;
        }

        public Criteria andSinaNickIsNotNull() {
            addCriterion("SINA_NICK is not null");
            return (Criteria) this;
        }

        public Criteria andSinaNickEqualTo(String value) {
            addCriterion("SINA_NICK =", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickNotEqualTo(String value) {
            addCriterion("SINA_NICK <>", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickGreaterThan(String value) {
            addCriterion("SINA_NICK >", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_NICK >=", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickLessThan(String value) {
            addCriterion("SINA_NICK <", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickLessThanOrEqualTo(String value) {
            addCriterion("SINA_NICK <=", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickLike(String value) {
            addCriterion("SINA_NICK like", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickNotLike(String value) {
            addCriterion("SINA_NICK not like", value, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickIn(List<String> values) {
            addCriterion("SINA_NICK in", values, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickNotIn(List<String> values) {
            addCriterion("SINA_NICK not in", values, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickBetween(String value1, String value2) {
            addCriterion("SINA_NICK between", value1, value2, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaNickNotBetween(String value1, String value2) {
            addCriterion("SINA_NICK not between", value1, value2, "sinaNick");
            return (Criteria) this;
        }

        public Criteria andSinaSexIsNull() {
            addCriterion("SINA_SEX is null");
            return (Criteria) this;
        }

        public Criteria andSinaSexIsNotNull() {
            addCriterion("SINA_SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSinaSexEqualTo(String value) {
            addCriterion("SINA_SEX =", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexNotEqualTo(String value) {
            addCriterion("SINA_SEX <>", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexGreaterThan(String value) {
            addCriterion("SINA_SEX >", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_SEX >=", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexLessThan(String value) {
            addCriterion("SINA_SEX <", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexLessThanOrEqualTo(String value) {
            addCriterion("SINA_SEX <=", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexLike(String value) {
            addCriterion("SINA_SEX like", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexNotLike(String value) {
            addCriterion("SINA_SEX not like", value, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexIn(List<String> values) {
            addCriterion("SINA_SEX in", values, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexNotIn(List<String> values) {
            addCriterion("SINA_SEX not in", values, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexBetween(String value1, String value2) {
            addCriterion("SINA_SEX between", value1, value2, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaSexNotBetween(String value1, String value2) {
            addCriterion("SINA_SEX not between", value1, value2, "sinaSex");
            return (Criteria) this;
        }

        public Criteria andSinaAgeIsNull() {
            addCriterion("SINA_AGE is null");
            return (Criteria) this;
        }

        public Criteria andSinaAgeIsNotNull() {
            addCriterion("SINA_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andSinaAgeEqualTo(BigDecimal value) {
            addCriterion("SINA_AGE =", value, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeNotEqualTo(BigDecimal value) {
            addCriterion("SINA_AGE <>", value, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeGreaterThan(BigDecimal value) {
            addCriterion("SINA_AGE >", value, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SINA_AGE >=", value, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeLessThan(BigDecimal value) {
            addCriterion("SINA_AGE <", value, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SINA_AGE <=", value, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeIn(List<BigDecimal> values) {
            addCriterion("SINA_AGE in", values, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeNotIn(List<BigDecimal> values) {
            addCriterion("SINA_AGE not in", values, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINA_AGE between", value1, value2, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaAgeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SINA_AGE not between", value1, value2, "sinaAge");
            return (Criteria) this;
        }

        public Criteria andSinaCityIsNull() {
            addCriterion("SINA_CITY is null");
            return (Criteria) this;
        }

        public Criteria andSinaCityIsNotNull() {
            addCriterion("SINA_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andSinaCityEqualTo(String value) {
            addCriterion("SINA_CITY =", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityNotEqualTo(String value) {
            addCriterion("SINA_CITY <>", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityGreaterThan(String value) {
            addCriterion("SINA_CITY >", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_CITY >=", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityLessThan(String value) {
            addCriterion("SINA_CITY <", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityLessThanOrEqualTo(String value) {
            addCriterion("SINA_CITY <=", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityLike(String value) {
            addCriterion("SINA_CITY like", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityNotLike(String value) {
            addCriterion("SINA_CITY not like", value, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityIn(List<String> values) {
            addCriterion("SINA_CITY in", values, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityNotIn(List<String> values) {
            addCriterion("SINA_CITY not in", values, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityBetween(String value1, String value2) {
            addCriterion("SINA_CITY between", value1, value2, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaCityNotBetween(String value1, String value2) {
            addCriterion("SINA_CITY not between", value1, value2, "sinaCity");
            return (Criteria) this;
        }

        public Criteria andSinaLocalIsNull() {
            addCriterion("SINA_LOCAL is null");
            return (Criteria) this;
        }

        public Criteria andSinaLocalIsNotNull() {
            addCriterion("SINA_LOCAL is not null");
            return (Criteria) this;
        }

        public Criteria andSinaLocalEqualTo(String value) {
            addCriterion("SINA_LOCAL =", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalNotEqualTo(String value) {
            addCriterion("SINA_LOCAL <>", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalGreaterThan(String value) {
            addCriterion("SINA_LOCAL >", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_LOCAL >=", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalLessThan(String value) {
            addCriterion("SINA_LOCAL <", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalLessThanOrEqualTo(String value) {
            addCriterion("SINA_LOCAL <=", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalLike(String value) {
            addCriterion("SINA_LOCAL like", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalNotLike(String value) {
            addCriterion("SINA_LOCAL not like", value, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalIn(List<String> values) {
            addCriterion("SINA_LOCAL in", values, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalNotIn(List<String> values) {
            addCriterion("SINA_LOCAL not in", values, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalBetween(String value1, String value2) {
            addCriterion("SINA_LOCAL between", value1, value2, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaLocalNotBetween(String value1, String value2) {
            addCriterion("SINA_LOCAL not between", value1, value2, "sinaLocal");
            return (Criteria) this;
        }

        public Criteria andSinaDesIsNull() {
            addCriterion("SINA_DES is null");
            return (Criteria) this;
        }

        public Criteria andSinaDesIsNotNull() {
            addCriterion("SINA_DES is not null");
            return (Criteria) this;
        }

        public Criteria andSinaDesEqualTo(String value) {
            addCriterion("SINA_DES =", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesNotEqualTo(String value) {
            addCriterion("SINA_DES <>", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesGreaterThan(String value) {
            addCriterion("SINA_DES >", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_DES >=", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesLessThan(String value) {
            addCriterion("SINA_DES <", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesLessThanOrEqualTo(String value) {
            addCriterion("SINA_DES <=", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesLike(String value) {
            addCriterion("SINA_DES like", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesNotLike(String value) {
            addCriterion("SINA_DES not like", value, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesIn(List<String> values) {
            addCriterion("SINA_DES in", values, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesNotIn(List<String> values) {
            addCriterion("SINA_DES not in", values, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesBetween(String value1, String value2) {
            addCriterion("SINA_DES between", value1, value2, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaDesNotBetween(String value1, String value2) {
            addCriterion("SINA_DES not between", value1, value2, "sinaDes");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlIsNull() {
            addCriterion("SINA_PICURL is null");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlIsNotNull() {
            addCriterion("SINA_PICURL is not null");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlEqualTo(String value) {
            addCriterion("SINA_PICURL =", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlNotEqualTo(String value) {
            addCriterion("SINA_PICURL <>", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlGreaterThan(String value) {
            addCriterion("SINA_PICURL >", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlGreaterThanOrEqualTo(String value) {
            addCriterion("SINA_PICURL >=", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlLessThan(String value) {
            addCriterion("SINA_PICURL <", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlLessThanOrEqualTo(String value) {
            addCriterion("SINA_PICURL <=", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlLike(String value) {
            addCriterion("SINA_PICURL like", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlNotLike(String value) {
            addCriterion("SINA_PICURL not like", value, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlIn(List<String> values) {
            addCriterion("SINA_PICURL in", values, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlNotIn(List<String> values) {
            addCriterion("SINA_PICURL not in", values, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlBetween(String value1, String value2) {
            addCriterion("SINA_PICURL between", value1, value2, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andSinaPicurlNotBetween(String value1, String value2) {
            addCriterion("SINA_PICURL not between", value1, value2, "sinaPicurl");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterionForJDBCDate("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
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