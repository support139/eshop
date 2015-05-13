package com.epam.khodyka.util;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Andrii_Khodyka on 5/13/2015.
 */
public class JspUtils {

    private static final Logger LOG = Logger.getLogger(JspUtils.class);

    public static String contains(List list, Integer id) {
        if (list != null && list.contains(id)) {
            LOG.info("Contains. Return checked");
            return "checked";
        }
        LOG.info("Return empty string");
        return "";
    }
}
