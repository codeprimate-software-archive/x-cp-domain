/*
 * Copyright (c) 2009-2010. Codeprimate, LLC and authors.  All Rights Reserved.
 *
 * This software is licensed under the Codeprimate End-User License Agreement (EULA).
 * This software is proprietary and confidential in addition to an intellectual asset of the aforementioned authors.
 * By using the software, the end-user implicitly consents to and agrees to be in compliance with all terms
 * and conditions of the EULA.  Failure to comply with the EULA will result in the maximum penalties permissible by law.
 *
 * In short, this software may not be reverse engineered, reproduced, copied, modified or distributed without prior
 * authorization of the aforementioned authors, permissible and expressed only in writing.  The authors grant the
 * end-user exclusive, non-negotiable and non-transferable use of the software "as is" without expressed or implied
 * WARRANTIES, EXTENSIONS or CONDITIONS of any kind.
 *
 * For further information on the software license, the end-user is encouraged to read the EULA @ ...
 */

package com.cp.domain.core.enums;

import com.cp.common.lang.Assert;

/**
 * The TimeUnit class is...
 * <p/>
 * TimeUnit.java (c) 20 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 */
public enum TimeUnit {
  NANOSECOND(1, "ns", "nanosecond"),
  MICROSECOND(2, "us", "microsecond"),
  MILLISECOND(3, "ms", "millisecond"),
  SECOND(4, "sec", "second"),
  MINUTE(5, "min", "minute"),
  HOUR(6, "hr", "hour"),
  DAY(7, "dd", "day"),
  WEEK(8, "w", "week"),
  MONTH(9, "mon", "month"),
  YEAR(10, "yr", "year"),
  DECADE(11, "dec", "decade"),
  SCORE(12, "sc", "score"),
  MILLENIUM(13, "mill", "millenium");

  private final Integer id;

  private final String code;
  private final String description;

  TimeUnit(final Integer id, final String code, final String description) {
    Assert.notNull(id, "The identifier for a TimeUnit enumerated value cannot be null!");
    Assert.notBlank(code, "The code for a TimeUnit enumerated value must be specified!");
    this.id = id;
    this.code = code;
    this.description = description;
  }

  public static TimeUnit getById(final Integer id) {
    for (final TimeUnit unit : values()) {
      if (unit.getId().equals(id)) {
        return unit;
      }
    }

    return null;
  }

  public static TimeUnit getByCode(final String code) {
    for (final TimeUnit unit : values()) {
      if (unit.getCode().equals(code)) {
        return unit;
      }
    }

    return null;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  public Integer getId() {
    return id;
  }

  @Override
  public String toString() {
    return getDescription();
  }

}
