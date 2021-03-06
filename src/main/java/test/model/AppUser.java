package test.model;

import java.util.Date;

public class AppUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.user_name
     *
     * @mbggenerated
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.gender
     *
     * @mbggenerated
     */
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.birthday
     *
     * @mbggenerated
     */
    private Date birthday;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.account_no
     *
     * @mbggenerated
     */
    private String accountNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column app_user.phone_no
     *
     * @mbggenerated
     */
    private String phoneNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.user_id
     *
     * @return the value of app_user.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.user_id
     *
     * @param userId the value for app_user.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.user_name
     *
     * @return the value of app_user.user_name
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.user_name
     *
     * @param userName the value for app_user.user_name
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.gender
     *
     * @return the value of app_user.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.gender
     *
     * @param gender the value for app_user.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.birthday
     *
     * @return the value of app_user.birthday
     *
     * @mbggenerated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.birthday
     *
     * @param birthday the value for app_user.birthday
     *
     * @mbggenerated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.account_no
     *
     * @return the value of app_user.account_no
     *
     * @mbggenerated
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.account_no
     *
     * @param accountNo the value for app_user.account_no
     *
     * @mbggenerated
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.password
     *
     * @return the value of app_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.password
     *
     * @param password the value for app_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.email
     *
     * @return the value of app_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.email
     *
     * @param email the value for app_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column app_user.phone_no
     *
     * @return the value of app_user.phone_no
     *
     * @mbggenerated
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column app_user.phone_no
     *
     * @param phoneNo the value for app_user.phone_no
     *
     * @mbggenerated
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }
}