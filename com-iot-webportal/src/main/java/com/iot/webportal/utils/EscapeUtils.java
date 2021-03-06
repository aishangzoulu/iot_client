package com.iot.webportal.utils;

import com.iot.utils.StringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by RayLew on 2014/11/27.
 */
public class EscapeUtils {
    /**
     * HtmlEncode
     *
     * @param str
     * @return
     */
    public static final String htmlEncode(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }

        return StringEscapeUtils.escapeHtml3(str);
    }

    /**
     * HtmlDecode
     *
     * @param str
     * @return
     */
    public static final String htmlDecode(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }

        return StringEscapeUtils.unescapeHtml3(str);
    }


}
