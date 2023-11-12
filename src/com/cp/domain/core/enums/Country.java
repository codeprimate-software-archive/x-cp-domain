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
 * The Country class is...
 * <p/>
 * Country.java (c) 18 12 2010
 * @author jblum
 * @version $Revision: 1.1 $
 */
public enum Country {
  UNITED_STATES(1, "US", "United States of America");

  private final Integer id;

  private final String abbreviation;
  private final String description;

  Country(final Integer id, final String abbreviation, final String description) {
    Assert.notNull(id, "The identifier for a Country enumerated value cannot be null!");
    Assert.notBlank(abbreviation, "The Country abbreviation must be specified!");
    this.id = id;
    this.abbreviation = abbreviation;
    this.description = description;
  }

  public static Country getById(final Integer id) {
    for (final Country country : values()) {
      if (country.getId().equals(id)) {
        return country;
      }
    }

    return null;
  }

  public static Country getByAbbreviation(final String abbreviation) {
    for (final Country country : values()) {
      if (country.getAbbreviation().equals(abbreviation)) {
        return country;
      }
    }

    return null;
  }

  public String getAbbreviation() {
    return abbreviation;
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
