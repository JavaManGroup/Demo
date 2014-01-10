package com.antony.service.sina.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CSinaFriendshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public CSinaFriendshipExample() {
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

        public Criteria andFriendIdIsNull() {
            addCriterion("FRIEND_ID is null");
            return (Criteria) this;
        }

        public Criteria andFriendIdIsNotNull() {
            addCriterion("FRIEND_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFriendIdEqualTo(BigDecimal value) {
            addCriterion("FRIEND_ID =", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotEqualTo(BigDecimal value) {
            addCriterion("FRIEND_ID <>", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThan(BigDecimal value) {
            addCriterion("FRIEND_ID >", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FRIEND_ID >=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThan(BigDecimal value) {
            addCriterion("FRIEND_ID <", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FRIEND_ID <=", value, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdIn(List<BigDecimal> values) {
            addCriterion("FRIEND_ID in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotIn(List<BigDecimal> values) {
            addCriterion("FRIEND_ID not in", values, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRIEND_ID between", value1, value2, "friendId");
            return (Criteria) this;
        }

        public Criteria andFriendIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FRIEND_ID not between", value1, value2, "friendId");
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

        public Criteria andAinfoIsNull() {
            addCriterion("AINFO is null");
            return (Criteria) this;
        }

        public Criteria andAinfoIsNotNull() {
            addCriterion("AINFO is not null");
            return (Criteria) this;
        }

        public Criteria andAinfoEqualTo(String value) {
            addCriterion("AINFO =", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotEqualTo(String value) {
            addCriterion("AINFO <>", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoGreaterThan(String value) {
            addCriterion("AINFO >", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoGreaterThanOrEqualTo(String value) {
            addCriterion("AINFO >=", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoLessThan(String value) {
            addCriterion("AINFO <", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoLessThanOrEqualTo(String value) {
            addCriterion("AINFO <=", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoLike(String value) {
            addCriterion("AINFO like", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotLike(String value) {
            addCriterion("AINFO not like", value, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoIn(List<String> values) {
            addCriterion("AINFO in", values, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotIn(List<String> values) {
            addCriterion("AINFO not in", values, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoBetween(String value1, String value2) {
            addCriterion("AINFO between", value1, value2, "ainfo");
            return (Criteria) this;
        }

        public Criteria andAinfoNotBetween(String value1, String value2) {
            addCriterion("AINFO not between", value1, value2, "ainfo");
            return (Criteria) this;
        }

        public Criteria andBinfoIsNull() {
            addCriterion("BINFO is null");
            return (Criteria) this;
        }

        public Criteria andBinfoIsNotNull() {
            addCriterion("BINFO is not null");
            return (Criteria) this;
        }

        public Criteria andBinfoEqualTo(String value) {
            addCriterion("BINFO =", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoNotEqualTo(String value) {
            addCriterion("BINFO <>", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoGreaterThan(String value) {
            addCriterion("BINFO >", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoGreaterThanOrEqualTo(String value) {
            addCriterion("BINFO >=", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoLessThan(String value) {
            addCriterion("BINFO <", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoLessThanOrEqualTo(String value) {
            addCriterion("BINFO <=", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoLike(String value) {
            addCriterion("BINFO like", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoNotLike(String value) {
            addCriterion("BINFO not like", value, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoIn(List<String> values) {
            addCriterion("BINFO in", values, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoNotIn(List<String> values) {
            addCriterion("BINFO not in", values, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoBetween(String value1, String value2) {
            addCriterion("BINFO between", value1, value2, "binfo");
            return (Criteria) this;
        }

        public Criteria andBinfoNotBetween(String value1, String value2) {
            addCriterion("BINFO not between", value1, value2, "binfo");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdIsNull() {
            addCriterion("FRIEND_SINA_ID is null");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdIsNotNull() {
            addCriterion("FRIEND_SINA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdEqualTo(String value) {
            addCriterion("FRIEND_SINA_ID =", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdNotEqualTo(String value) {
            addCriterion("FRIEND_SINA_ID <>", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdGreaterThan(String value) {
            addCriterion("FRIEND_SINA_ID >", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdGreaterThanOrEqualTo(String value) {
            addCriterion("FRIEND_SINA_ID >=", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdLessThan(String value) {
            addCriterion("FRIEND_SINA_ID <", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdLessThanOrEqualTo(String value) {
            addCriterion("FRIEND_SINA_ID <=", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdLike(String value) {
            addCriterion("FRIEND_SINA_ID like", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdNotLike(String value) {
            addCriterion("FRIEND_SINA_ID not like", value, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdIn(List<String> values) {
            addCriterion("FRIEND_SINA_ID in", values, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdNotIn(List<String> values) {
            addCriterion("FRIEND_SINA_ID not in", values, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdBetween(String value1, String value2) {
            addCriterion("FRIEND_SINA_ID between", value1, value2, "friendSinaId");
            return (Criteria) this;
        }

        public Criteria andFriendSinaIdNotBetween(String value1, String value2) {
            addCriterion("FRIEND_SINA_ID not between", value1, value2, "friendSinaId");
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