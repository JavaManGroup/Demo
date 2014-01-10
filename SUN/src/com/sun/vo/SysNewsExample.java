package com.sun.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysNewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected int limitStart = -1;

    protected int limitEnd = -1;

    public SysNewsExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andNewstypeidIsNull() {
            addCriterion("NEWSTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andNewstypeidIsNotNull() {
            addCriterion("NEWSTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andNewstypeidEqualTo(Integer value) {
            addCriterion("NEWSTYPEID =", value, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidNotEqualTo(Integer value) {
            addCriterion("NEWSTYPEID <>", value, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidGreaterThan(Integer value) {
            addCriterion("NEWSTYPEID >", value, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEWSTYPEID >=", value, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidLessThan(Integer value) {
            addCriterion("NEWSTYPEID <", value, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidLessThanOrEqualTo(Integer value) {
            addCriterion("NEWSTYPEID <=", value, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidIn(List<Integer> values) {
            addCriterion("NEWSTYPEID in", values, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidNotIn(List<Integer> values) {
            addCriterion("NEWSTYPEID not in", values, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidBetween(Integer value1, Integer value2) {
            addCriterion("NEWSTYPEID between", value1, value2, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andNewstypeidNotBetween(Integer value1, Integer value2) {
            addCriterion("NEWSTYPEID not between", value1, value2, "newstypeid");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("IMAGE is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("IMAGE is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("IMAGE =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("IMAGE <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("IMAGE >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("IMAGE >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("IMAGE <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("IMAGE <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("IMAGE like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("IMAGE not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("IMAGE in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("IMAGE not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("IMAGE between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("IMAGE not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andPosttimeIsNull() {
            addCriterion("POSTTIME is null");
            return (Criteria) this;
        }

        public Criteria andPosttimeIsNotNull() {
            addCriterion("POSTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andPosttimeEqualTo(Date value) {
            addCriterion("POSTTIME =", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeNotEqualTo(Date value) {
            addCriterion("POSTTIME <>", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeGreaterThan(Date value) {
            addCriterion("POSTTIME >", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("POSTTIME >=", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeLessThan(Date value) {
            addCriterion("POSTTIME <", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeLessThanOrEqualTo(Date value) {
            addCriterion("POSTTIME <=", value, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeIn(List<Date> values) {
            addCriterion("POSTTIME in", values, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeNotIn(List<Date> values) {
            addCriterion("POSTTIME not in", values, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeBetween(Date value1, Date value2) {
            addCriterion("POSTTIME between", value1, value2, "posttime");
            return (Criteria) this;
        }

        public Criteria andPosttimeNotBetween(Date value1, Date value2) {
            addCriterion("POSTTIME not between", value1, value2, "posttime");
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
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNull() {
            addCriterion("VIEWCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andViewcountIsNotNull() {
            addCriterion("VIEWCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andViewcountEqualTo(Integer value) {
            addCriterion("VIEWCOUNT =", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotEqualTo(Integer value) {
            addCriterion("VIEWCOUNT <>", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThan(Integer value) {
            addCriterion("VIEWCOUNT >", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIEWCOUNT >=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThan(Integer value) {
            addCriterion("VIEWCOUNT <", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountLessThanOrEqualTo(Integer value) {
            addCriterion("VIEWCOUNT <=", value, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountIn(List<Integer> values) {
            addCriterion("VIEWCOUNT in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotIn(List<Integer> values) {
            addCriterion("VIEWCOUNT not in", values, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountBetween(Integer value1, Integer value2) {
            addCriterion("VIEWCOUNT between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andViewcountNotBetween(Integer value1, Integer value2) {
            addCriterion("VIEWCOUNT not between", value1, value2, "viewcount");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUpdateipIsNull() {
            addCriterion("UPDATEIP is null");
            return (Criteria) this;
        }

        public Criteria andUpdateipIsNotNull() {
            addCriterion("UPDATEIP is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateipEqualTo(String value) {
            addCriterion("UPDATEIP =", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipNotEqualTo(String value) {
            addCriterion("UPDATEIP <>", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipGreaterThan(String value) {
            addCriterion("UPDATEIP >", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATEIP >=", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipLessThan(String value) {
            addCriterion("UPDATEIP <", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipLessThanOrEqualTo(String value) {
            addCriterion("UPDATEIP <=", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipLike(String value) {
            addCriterion("UPDATEIP like", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipNotLike(String value) {
            addCriterion("UPDATEIP not like", value, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipIn(List<String> values) {
            addCriterion("UPDATEIP in", values, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipNotIn(List<String> values) {
            addCriterion("UPDATEIP not in", values, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipBetween(String value1, String value2) {
            addCriterion("UPDATEIP between", value1, value2, "updateip");
            return (Criteria) this;
        }

        public Criteria andUpdateipNotBetween(String value1, String value2) {
            addCriterion("UPDATEIP not between", value1, value2, "updateip");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridIsNull() {
            addCriterion("PROCESSINGUSERID is null");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridIsNotNull() {
            addCriterion("PROCESSINGUSERID is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridEqualTo(Integer value) {
            addCriterion("PROCESSINGUSERID =", value, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridNotEqualTo(Integer value) {
            addCriterion("PROCESSINGUSERID <>", value, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridGreaterThan(Integer value) {
            addCriterion("PROCESSINGUSERID >", value, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("PROCESSINGUSERID >=", value, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridLessThan(Integer value) {
            addCriterion("PROCESSINGUSERID <", value, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridLessThanOrEqualTo(Integer value) {
            addCriterion("PROCESSINGUSERID <=", value, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridIn(List<Integer> values) {
            addCriterion("PROCESSINGUSERID in", values, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridNotIn(List<Integer> values) {
            addCriterion("PROCESSINGUSERID not in", values, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridBetween(Integer value1, Integer value2) {
            addCriterion("PROCESSINGUSERID between", value1, value2, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andProcessinguseridNotBetween(Integer value1, Integer value2) {
            addCriterion("PROCESSINGUSERID not between", value1, value2, "processinguserid");
            return (Criteria) this;
        }

        public Criteria andTopIsNull() {
            addCriterion("TOP is null");
            return (Criteria) this;
        }

        public Criteria andTopIsNotNull() {
            addCriterion("TOP is not null");
            return (Criteria) this;
        }

        public Criteria andTopEqualTo(Integer value) {
            addCriterion("TOP =", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotEqualTo(Integer value) {
            addCriterion("TOP <>", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThan(Integer value) {
            addCriterion("TOP >", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopGreaterThanOrEqualTo(Integer value) {
            addCriterion("TOP >=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThan(Integer value) {
            addCriterion("TOP <", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopLessThanOrEqualTo(Integer value) {
            addCriterion("TOP <=", value, "top");
            return (Criteria) this;
        }

        public Criteria andTopIn(List<Integer> values) {
            addCriterion("TOP in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotIn(List<Integer> values) {
            addCriterion("TOP not in", values, "top");
            return (Criteria) this;
        }

        public Criteria andTopBetween(Integer value1, Integer value2) {
            addCriterion("TOP between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andTopNotBetween(Integer value1, Integer value2) {
            addCriterion("TOP not between", value1, value2, "top");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("STATE not between", value1, value2, "state");
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