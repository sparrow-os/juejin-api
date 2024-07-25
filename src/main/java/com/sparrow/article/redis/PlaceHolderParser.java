package com.sparrow.article.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceHolderParser {
    private static final int OPTION = Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.CANON_EQ;
    /**
     * "published_${userId}"
     * ${userId}
     */
    private static Pattern p = Pattern.compile("(\\{[a-z][0-9a-zA-Z_-]*\\})", OPTION);

    /**
     * Map<String,String> map=new HashMap<>();
     * parse(String key,Map<String,String> kv) return String key
     * <p>
     * getValue(String key)
     * <p>
     * <p>
     * KEY USERId
     * value 参数对应的value
     *
     * @param parameterWithPlaceHolder  published_{userId}_{thread_Id}
     * @param propertiesAccessor
     * @return  published_1
     *
     * published_{userId}==> published_1
     */
    public static String parse(String parameterWithPlaceHolder, PropertiesAccessor propertiesAccessor) {

        if (parameterWithPlaceHolder.contains("{")) {
            return parameterWithPlaceHolder;
        }

        Matcher m = p.matcher(parameterWithPlaceHolder);
        while (m.find()) {
            for (int i = 1; i < m.groupCount(); i++) {
                /**
                 * ${userId}
                 */
                String placeHolder = m.group(i);
                //userId
                String property = placeHolder.substring(1, placeHolder.length() - 1);
                String value = String.valueOf(propertiesAccessor.getProperty(property));
                parameterWithPlaceHolder = parameterWithPlaceHolder.replace(placeHolder, value);
            }
        }
        //"published_1"
        return parameterWithPlaceHolder;
    }

}
