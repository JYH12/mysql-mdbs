package com.lsl.po;

import java.util.ArrayList;
import java.util.List;

public class SlaveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SlaveExample() {
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

        public Criteria andHostIsNull() {
            addCriterion("host is null");
            return (Criteria) this;
        }

        public Criteria andHostIsNotNull() {
            addCriterion("host is not null");
            return (Criteria) this;
        }

        public Criteria andHostEqualTo(String value) {
            addCriterion("host =", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotEqualTo(String value) {
            addCriterion("host <>", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThan(String value) {
            addCriterion("host >", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostGreaterThanOrEqualTo(String value) {
            addCriterion("host >=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThan(String value) {
            addCriterion("host <", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLessThanOrEqualTo(String value) {
            addCriterion("host <=", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostLike(String value) {
            addCriterion("host like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotLike(String value) {
            addCriterion("host not like", value, "host");
            return (Criteria) this;
        }

        public Criteria andHostIn(List<String> values) {
            addCriterion("host in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotIn(List<String> values) {
            addCriterion("host not in", values, "host");
            return (Criteria) this;
        }

        public Criteria andHostBetween(String value1, String value2) {
            addCriterion("host between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andHostNotBetween(String value1, String value2) {
            addCriterion("host not between", value1, value2, "host");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordIsNull() {
            addCriterion("instance_password is null");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordIsNotNull() {
            addCriterion("instance_password is not null");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordEqualTo(String value) {
            addCriterion("instance_password =", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordNotEqualTo(String value) {
            addCriterion("instance_password <>", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordGreaterThan(String value) {
            addCriterion("instance_password >", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("instance_password >=", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordLessThan(String value) {
            addCriterion("instance_password <", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordLessThanOrEqualTo(String value) {
            addCriterion("instance_password <=", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordLike(String value) {
            addCriterion("instance_password like", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordNotLike(String value) {
            addCriterion("instance_password not like", value, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordIn(List<String> values) {
            addCriterion("instance_password in", values, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordNotIn(List<String> values) {
            addCriterion("instance_password not in", values, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordBetween(String value1, String value2) {
            addCriterion("instance_password between", value1, value2, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andInstancePasswordNotBetween(String value1, String value2) {
            addCriterion("instance_password not between", value1, value2, "instancePassword");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserIsNull() {
            addCriterion("isntancec_user is null");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserIsNotNull() {
            addCriterion("isntancec_user is not null");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserEqualTo(String value) {
            addCriterion("isntancec_user =", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserNotEqualTo(String value) {
            addCriterion("isntancec_user <>", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserGreaterThan(String value) {
            addCriterion("isntancec_user >", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserGreaterThanOrEqualTo(String value) {
            addCriterion("isntancec_user >=", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserLessThan(String value) {
            addCriterion("isntancec_user <", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserLessThanOrEqualTo(String value) {
            addCriterion("isntancec_user <=", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserLike(String value) {
            addCriterion("isntancec_user like", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserNotLike(String value) {
            addCriterion("isntancec_user not like", value, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserIn(List<String> values) {
            addCriterion("isntancec_user in", values, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserNotIn(List<String> values) {
            addCriterion("isntancec_user not in", values, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserBetween(String value1, String value2) {
            addCriterion("isntancec_user between", value1, value2, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsntancecUserNotBetween(String value1, String value2) {
            addCriterion("isntancec_user not between", value1, value2, "isntancecUser");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("isuse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("isuse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(Integer value) {
            addCriterion("isuse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(Integer value) {
            addCriterion("isuse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(Integer value) {
            addCriterion("isuse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(Integer value) {
            addCriterion("isuse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(Integer value) {
            addCriterion("isuse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(Integer value) {
            addCriterion("isuse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<Integer> values) {
            addCriterion("isuse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<Integer> values) {
            addCriterion("isuse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(Integer value1, Integer value2) {
            addCriterion("isuse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(Integer value1, Integer value2) {
            addCriterion("isuse not between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andMasteridIsNull() {
            addCriterion("masterid is null");
            return (Criteria) this;
        }

        public Criteria andMasteridIsNotNull() {
            addCriterion("masterid is not null");
            return (Criteria) this;
        }

        public Criteria andMasteridEqualTo(Integer value) {
            addCriterion("masterid =", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotEqualTo(Integer value) {
            addCriterion("masterid <>", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridGreaterThan(Integer value) {
            addCriterion("masterid >", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridGreaterThanOrEqualTo(Integer value) {
            addCriterion("masterid >=", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridLessThan(Integer value) {
            addCriterion("masterid <", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridLessThanOrEqualTo(Integer value) {
            addCriterion("masterid <=", value, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridIn(List<Integer> values) {
            addCriterion("masterid in", values, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotIn(List<Integer> values) {
            addCriterion("masterid not in", values, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridBetween(Integer value1, Integer value2) {
            addCriterion("masterid between", value1, value2, "masterid");
            return (Criteria) this;
        }

        public Criteria andMasteridNotBetween(Integer value1, Integer value2) {
            addCriterion("masterid not between", value1, value2, "masterid");
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