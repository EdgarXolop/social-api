package com.voider.socialapi.util;

public class ErrorUtil {

    //DB INDEXES
    public final static String INDEX_USER_EMAIL = "user_index_email";
    public final static String INDEX_USER_USERNAME = "user_index_user_name";

    //USER VALIDATION MESSAGES
    public final static String EMPTY_USERNAME = "Please provide the user_name.";
    public final static String DUPLICATED_USERNAME = "user_name {0} already taken.";
    public final static String EMPTY_EMAIL = "Please provide the email.";
    public final static String DUPLICATED_EMAIL = "email {0} already taken.";
    public final static String WRONG_EMAIL = "Please provide an valid email.";
    public final static String EMPTY_PASSWORD = "Please provide the password field.";
    public final static String EMPTY_CONFIRM_PASSWORD = "Please provide the password_confirm field.";

    //CONVERSATION VALIDATION MESSAGES
    public final static String NOT_NULL_CREATOR = "You can´t send the id_user_creator.";
    public final static String TRUE_ACCEPTED_STATUS = "You can´t set the accepted field.";
    public final static String INVALID_USER_INVITED = "Please provide a valid id_user.";

}
