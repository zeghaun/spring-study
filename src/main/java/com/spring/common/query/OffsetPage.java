/* =============================================================
 * Created: [2015/3/3 10:22] by wuzj(971643)
 * =============================================================
 *
 * Copyright 2014-2015 NetDragon Websoft Inc. All Rights Reserved
 *
 * =============================================================
 */
package com.spring.common.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class OffsetPage extends PageRequest {

    /**
     * Member Description
     */

    private static final long serialVersionUID = 1170816091598217048L;
    static Logger logger = LoggerFactory.getLogger(OffsetPage.class);
    public int offset = -1;
    public Sort sort = null;

    public OffsetPage(int page, int size, Sort sort) {
        super(page, size, sort);
    }

    public static OffsetPage createPage(int offset, int limit) {
        OffsetPage page = new OffsetPage(1, limit, null);
        page.setOffset(offset);
        return page;
    }

    @Override
    public int getOffset() {
        if (this.offset == -1) {
            return super.getOffset();
        }
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
