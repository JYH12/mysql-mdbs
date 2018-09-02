package com.lsl.po;

import java.util.ArrayList;
import java.util.List;

public class InstanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InstanceExample() {
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

        public Criteria andInstanceidIsNull() {
            addCriterion("instanceid is null");
            return (Criteria) this;
        }

        public Criteria andInstanceidIsNotNull() {
            addCriterion("instanceid is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceidEqualTo(Integer value) {
            addCriterion("instanceid =", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotEqualTo(Integer value) {
            addCriterion("instanceid <>", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidGreaterThan(Integer value) {
            addCriterion("instanceid >", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("instanceid >=", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLessThan(Integer value) {
            addCriterion("instanceid <", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidLessThanOrEqualTo(Integer value) {
            addCriterion("instanceid <=", value, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidIn(List<Integer> values) {
            addCriterion("instanceid in", values, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotIn(List<Integer> values) {
            addCriterion("instanceid not in", values, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidBetween(Integer value1, Integer value2) {
            addCriterion("instanceid between", value1, value2, "instanceid");
            return (Criteria) this;
        }

        public Criteria andInstanceidNotBetween(Integer value1, Integer value2) {
            addCriterion("instanceid not between", value1, value2, "instanceid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
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

        public Criteria andPortIsNull() {
            addCriterion("port is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("port is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(String value) {
            addCriterion("port =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(String value) {
            addCriterion("port <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(String value) {
            addCriterion("port >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(String value) {
            addCriterion("port >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(String value) {
            addCriterion("port <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(String value) {
            addCriterion("port <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLike(String value) {
            addCriterion("port like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotLike(String value) {
            addCriterion("port not like", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<String> values) {
            addCriterion("port in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<String> values) {
            addCriterion("port not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(String value1, String value2) {
            addCriterion("port between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(String value1, String value2) {
            addCriterion("port not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andReplUserIsNull() {
            addCriterion("repl_user is null");
            return (Criteria) this;
        }

        public Criteria andReplUserIsNotNull() {
            addCriterion("repl_user is not null");
            return (Criteria) this;
        }

        public Criteria andReplUserEqualTo(String value) {
            addCriterion("repl_user =", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserNotEqualTo(String value) {
            addCriterion("repl_user <>", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserGreaterThan(String value) {
            addCriterion("repl_user >", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserGreaterThanOrEqualTo(String value) {
            addCriterion("repl_user >=", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserLessThan(String value) {
            addCriterion("repl_user <", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserLessThanOrEqualTo(String value) {
            addCriterion("repl_user <=", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserLike(String value) {
            addCriterion("repl_user like", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserNotLike(String value) {
            addCriterion("repl_user not like", value, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserIn(List<String> values) {
            addCriterion("repl_user in", values, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserNotIn(List<String> values) {
            addCriterion("repl_user not in", values, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserBetween(String value1, String value2) {
            addCriterion("repl_user between", value1, value2, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplUserNotBetween(String value1, String value2) {
            addCriterion("repl_user not between", value1, value2, "replUser");
            return (Criteria) this;
        }

        public Criteria andReplPasswordIsNull() {
            addCriterion("repl_password is null");
            return (Criteria) this;
        }

        public Criteria andReplPasswordIsNotNull() {
            addCriterion("repl_password is not null");
            return (Criteria) this;
        }

        public Criteria andReplPasswordEqualTo(String value) {
            addCriterion("repl_password =", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordNotEqualTo(String value) {
            addCriterion("repl_password <>", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordGreaterThan(String value) {
            addCriterion("repl_password >", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("repl_password >=", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordLessThan(String value) {
            addCriterion("repl_password <", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordLessThanOrEqualTo(String value) {
            addCriterion("repl_password <=", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordLike(String value) {
            addCriterion("repl_password like", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordNotLike(String value) {
            addCriterion("repl_password not like", value, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordIn(List<String> values) {
            addCriterion("repl_password in", values, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordNotIn(List<String> values) {
            addCriterion("repl_password not in", values, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordBetween(String value1, String value2) {
            addCriterion("repl_password between", value1, value2, "replPassword");
            return (Criteria) this;
        }

        public Criteria andReplPasswordNotBetween(String value1, String value2) {
            addCriterion("repl_password not between", value1, value2, "replPassword");
            return (Criteria) this;
        }

        public Criteria andInstanceNameIsNull() {
            addCriterion("instance_name is null");
            return (Criteria) this;
        }

        public Criteria andInstanceNameIsNotNull() {
            addCriterion("instance_name is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceNameEqualTo(String value) {
            addCriterion("instance_name =", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotEqualTo(String value) {
            addCriterion("instance_name <>", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameGreaterThan(String value) {
            addCriterion("instance_name >", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameGreaterThanOrEqualTo(String value) {
            addCriterion("instance_name >=", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameLessThan(String value) {
            addCriterion("instance_name <", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameLessThanOrEqualTo(String value) {
            addCriterion("instance_name <=", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameLike(String value) {
            addCriterion("instance_name like", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotLike(String value) {
            addCriterion("instance_name not like", value, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameIn(List<String> values) {
            addCriterion("instance_name in", values, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotIn(List<String> values) {
            addCriterion("instance_name not in", values, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameBetween(String value1, String value2) {
            addCriterion("instance_name between", value1, value2, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceNameNotBetween(String value1, String value2) {
            addCriterion("instance_name not between", value1, value2, "instanceName");
            return (Criteria) this;
        }

        public Criteria andInstanceUserIsNull() {
            addCriterion("instance_user is null");
            return (Criteria) this;
        }

        public Criteria andInstanceUserIsNotNull() {
            addCriterion("instance_user is not null");
            return (Criteria) this;
        }

        public Criteria andInstanceUserEqualTo(String value) {
            addCriterion("instance_user =", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserNotEqualTo(String value) {
            addCriterion("instance_user <>", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserGreaterThan(String value) {
            addCriterion("instance_user >", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserGreaterThanOrEqualTo(String value) {
            addCriterion("instance_user >=", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserLessThan(String value) {
            addCriterion("instance_user <", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserLessThanOrEqualTo(String value) {
            addCriterion("instance_user <=", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserLike(String value) {
            addCriterion("instance_user like", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserNotLike(String value) {
            addCriterion("instance_user not like", value, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserIn(List<String> values) {
            addCriterion("instance_user in", values, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserNotIn(List<String> values) {
            addCriterion("instance_user not in", values, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserBetween(String value1, String value2) {
            addCriterion("instance_user between", value1, value2, "instanceUser");
            return (Criteria) this;
        }

        public Criteria andInstanceUserNotBetween(String value1, String value2) {
            addCriterion("instance_user not between", value1, value2, "instanceUser");
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