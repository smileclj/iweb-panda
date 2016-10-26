package com.panda.iweb.entity;

import java.util.ArrayList;
import java.util.List;

public class FillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public FillExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
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

        public Criteria andId1IsNull() {
            addCriterion("id1 is null");
            return (Criteria) this;
        }

        public Criteria andId1IsNotNull() {
            addCriterion("id1 is not null");
            return (Criteria) this;
        }

        public Criteria andId1EqualTo(Integer value) {
            addCriterion("id1 =", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotEqualTo(Integer value) {
            addCriterion("id1 <>", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1GreaterThan(Integer value) {
            addCriterion("id1 >", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1GreaterThanOrEqualTo(Integer value) {
            addCriterion("id1 >=", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1LessThan(Integer value) {
            addCriterion("id1 <", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1LessThanOrEqualTo(Integer value) {
            addCriterion("id1 <=", value, "id1");
            return (Criteria) this;
        }

        public Criteria andId1In(List<Integer> values) {
            addCriterion("id1 in", values, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotIn(List<Integer> values) {
            addCriterion("id1 not in", values, "id1");
            return (Criteria) this;
        }

        public Criteria andId1Between(Integer value1, Integer value2) {
            addCriterion("id1 between", value1, value2, "id1");
            return (Criteria) this;
        }

        public Criteria andId1NotBetween(Integer value1, Integer value2) {
            addCriterion("id1 not between", value1, value2, "id1");
            return (Criteria) this;
        }

        public Criteria andId2IsNull() {
            addCriterion("id2 is null");
            return (Criteria) this;
        }

        public Criteria andId2IsNotNull() {
            addCriterion("id2 is not null");
            return (Criteria) this;
        }

        public Criteria andId2EqualTo(Integer value) {
            addCriterion("id2 =", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotEqualTo(Integer value) {
            addCriterion("id2 <>", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2GreaterThan(Integer value) {
            addCriterion("id2 >", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2GreaterThanOrEqualTo(Integer value) {
            addCriterion("id2 >=", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2LessThan(Integer value) {
            addCriterion("id2 <", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2LessThanOrEqualTo(Integer value) {
            addCriterion("id2 <=", value, "id2");
            return (Criteria) this;
        }

        public Criteria andId2In(List<Integer> values) {
            addCriterion("id2 in", values, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotIn(List<Integer> values) {
            addCriterion("id2 not in", values, "id2");
            return (Criteria) this;
        }

        public Criteria andId2Between(Integer value1, Integer value2) {
            addCriterion("id2 between", value1, value2, "id2");
            return (Criteria) this;
        }

        public Criteria andId2NotBetween(Integer value1, Integer value2) {
            addCriterion("id2 not between", value1, value2, "id2");
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