package test.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PFileIndexExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public PFileIndexExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
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

        public Criteria andPFileIndexIdIsNull() {
            addCriterion("p_file_index_id is null");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdIsNotNull() {
            addCriterion("p_file_index_id is not null");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdEqualTo(Long value) {
            addCriterion("p_file_index_id =", value, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdNotEqualTo(Long value) {
            addCriterion("p_file_index_id <>", value, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdGreaterThan(Long value) {
            addCriterion("p_file_index_id >", value, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdGreaterThanOrEqualTo(Long value) {
            addCriterion("p_file_index_id >=", value, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdLessThan(Long value) {
            addCriterion("p_file_index_id <", value, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdLessThanOrEqualTo(Long value) {
            addCriterion("p_file_index_id <=", value, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdIn(List<Long> values) {
            addCriterion("p_file_index_id in", values, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdNotIn(List<Long> values) {
            addCriterion("p_file_index_id not in", values, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdBetween(Long value1, Long value2) {
            addCriterion("p_file_index_id between", value1, value2, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPFileIndexIdNotBetween(Long value1, Long value2) {
            addCriterion("p_file_index_id not between", value1, value2, "pFileIndexId");
            return (Criteria) this;
        }

        public Criteria andPNameIsNull() {
            addCriterion("p_name is null");
            return (Criteria) this;
        }

        public Criteria andPNameIsNotNull() {
            addCriterion("p_name is not null");
            return (Criteria) this;
        }

        public Criteria andPNameEqualTo(String value) {
            addCriterion("p_name =", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotEqualTo(String value) {
            addCriterion("p_name <>", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThan(String value) {
            addCriterion("p_name >", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameGreaterThanOrEqualTo(String value) {
            addCriterion("p_name >=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThan(String value) {
            addCriterion("p_name <", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLessThanOrEqualTo(String value) {
            addCriterion("p_name <=", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameLike(String value) {
            addCriterion("p_name like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotLike(String value) {
            addCriterion("p_name not like", value, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameIn(List<String> values) {
            addCriterion("p_name in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotIn(List<String> values) {
            addCriterion("p_name not in", values, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameBetween(String value1, String value2) {
            addCriterion("p_name between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPNameNotBetween(String value1, String value2) {
            addCriterion("p_name not between", value1, value2, "pName");
            return (Criteria) this;
        }

        public Criteria andPPathIsNull() {
            addCriterion("p_path is null");
            return (Criteria) this;
        }

        public Criteria andPPathIsNotNull() {
            addCriterion("p_path is not null");
            return (Criteria) this;
        }

        public Criteria andPPathEqualTo(String value) {
            addCriterion("p_path =", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathNotEqualTo(String value) {
            addCriterion("p_path <>", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathGreaterThan(String value) {
            addCriterion("p_path >", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathGreaterThanOrEqualTo(String value) {
            addCriterion("p_path >=", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathLessThan(String value) {
            addCriterion("p_path <", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathLessThanOrEqualTo(String value) {
            addCriterion("p_path <=", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathLike(String value) {
            addCriterion("p_path like", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathNotLike(String value) {
            addCriterion("p_path not like", value, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathIn(List<String> values) {
            addCriterion("p_path in", values, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathNotIn(List<String> values) {
            addCriterion("p_path not in", values, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathBetween(String value1, String value2) {
            addCriterion("p_path between", value1, value2, "pPath");
            return (Criteria) this;
        }

        public Criteria andPPathNotBetween(String value1, String value2) {
            addCriterion("p_path not between", value1, value2, "pPath");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(Long value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(Long value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(Long value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(Long value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(Long value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(Long value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<Long> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<Long> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(Long value1, Long value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(Long value1, Long value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileMd5IsNull() {
            addCriterion("file_md5 is null");
            return (Criteria) this;
        }

        public Criteria andFileMd5IsNotNull() {
            addCriterion("file_md5 is not null");
            return (Criteria) this;
        }

        public Criteria andFileMd5EqualTo(String value) {
            addCriterion("file_md5 =", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotEqualTo(String value) {
            addCriterion("file_md5 <>", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5GreaterThan(String value) {
            addCriterion("file_md5 >", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5GreaterThanOrEqualTo(String value) {
            addCriterion("file_md5 >=", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5LessThan(String value) {
            addCriterion("file_md5 <", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5LessThanOrEqualTo(String value) {
            addCriterion("file_md5 <=", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5Like(String value) {
            addCriterion("file_md5 like", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotLike(String value) {
            addCriterion("file_md5 not like", value, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5In(List<String> values) {
            addCriterion("file_md5 in", values, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotIn(List<String> values) {
            addCriterion("file_md5 not in", values, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5Between(String value1, String value2) {
            addCriterion("file_md5 between", value1, value2, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andFileMd5NotBetween(String value1, String value2) {
            addCriterion("file_md5 not between", value1, value2, "fileMd5");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table p_file_index
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table p_file_index
     *
     * @mbggenerated
     */
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