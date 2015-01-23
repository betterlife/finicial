package io.betterlife.application.config;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Lawrence Liu(lawrence@betterlife.io)
 * Date: 10/31/14
 * Application config
 */
public class ApplicationConfig {

    /**
     * Ignore field when output toString.
     */
    public static List<String> ToStringIgnoreFields;

    /**
     * Application data source name
     */
    public static final String DataSourceName = "jdbc/PostgreSQLDS";

    /**
     * Application persistence unit name
     */
    public static final String PersistenceUnitName = "betterlife";
	

    /**
     * Table name prefix
     */
    public static final String TableNamePrefix = "BL_";
    public static final String DefaultRepresentField = "name";
    public static final int DefaultFieldRank = 0;

    public static String getLocale() {return "zh_CN";}

    public static boolean isDevelopmentMode() {
        return true;
    }

    public static List<String> getToStringIgnoreFields() {
        if (null == ToStringIgnoreFields) {
            ToStringIgnoreFields = new ArrayList<>();
            ToStringIgnoreFields.add("lastModify");
            ToStringIgnoreFields.add("creator");
        }
        return ToStringIgnoreFields;
    }
}
