package com.voider.socialapi.util;

public class ErrorUtil {

    //DB INDEXES
    public final static String INDEX_USER_EMAIL = "user_index_email";
    public final static String INDEX_USER_USERNAME = "user_index_user_name";

    //USER VALIDATION MESSAGES
    public final static String EMPTY_USERNAME = "Please provide provide the user_name.";
    public final static String DUPLICATED_USERNAME = "user_name {0} already taken.";
    public final static String EMPTY_EMAIL = "Please provide the email.";
    public final static String DUPLICATED_EMAIL = "email {0} already taken.";
    public final static String WRONG_EMAIL = "Please provide an valid email.";
    public final static String EMPTY_PASSWORD = "Please provide the password field.";
    public final static String EMPTY_CONFIRM_PASSWORD = "Please provide the password_confirm field.";

}
