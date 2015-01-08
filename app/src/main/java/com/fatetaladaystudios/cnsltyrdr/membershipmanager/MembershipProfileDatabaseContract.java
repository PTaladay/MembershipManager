package com.fatetaladaystudios.cnsltyrdr.membershipmanager;

import android.provider.BaseColumns;

/**
 * Created by Cnsltyrdr on 1/8/2015.
 */
public class MembershipProfileDatabaseContract {
    public MembershipProfileDatabaseContract(){}

    public static abstract class MembershipProfile implements BaseColumns {
        public static final String TABLE_NAME ="membershipprofiles";
        public static final String COLUMN_NAME_PROFILE_ID = "profileid";
        public static final String COLUMN_NAME_COMPANY_NAME ="companyname";
        public static final String COLUMN_NAME_PHONE_NUMBER ="phonenumber";
        public static final String COLUMN_NAME_WEBSITE_URL ="websiteurl";
        public static final String COLUMN_NAME_BARCODE_VALUE ="barcodevalue";
        public static final String COLUMN_NAME_ERROR_CORRECTION ="errorcorrection";
        public static final String COLUMN_NAME_BARCODE_TYPE = "barcodetype";
        public static final String COLUMN_NAME_BARCODE_RAW_DATA = "barcoderawdata";


    }
}
