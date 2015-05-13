package com.epam.khodyka.extractor;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Andrii_Khodyka on 5/8/2015.
 */
public interface Extractor<E> {
    public E extract(HttpServletRequest req);
}
