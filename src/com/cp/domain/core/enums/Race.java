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
 * The Race class is models the ethnicity of a person.
 * <p/>
 * Race.java (c) 18 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 */
public enum Race {
  AFRICAN_AMERICAN(1, "AFR", "African American"),
  ALASKAN_NATIVE(2, "ALN", "Alaskan Native"),
  AMERICAN_INDIAN(3, "AIN", "American Indian"),
  ASIAN(4, "AS", "Asian"),
  AUSTRALIAN(5, "AUS", "Australian"),
  CAUCASION(6, "CAU", "Caucasion"),
  EUROPEAN(6, "EURO", "Europena");

  private final Integer id;

  private final String code;
  private final String description;

  Race(final Integer id, final String code, final String description) {
    Assert.notNull(id, "The identifier for a Race enumerated value cannot be null!");
    Assert.notBlank(code, "The code for a Race enumerated value must be specified!");
    this.id = id;
    this.code = code;
    this.description = description;
  }

  public static Race getById(final Integer id) {
    for (final Race race : values()) {
      if (race.getId().equals(id)) {
        return race;
      }
    }

    return null;
  }

  public static Race getByCode(final String code) {
    for (final Race race : values()) {
      if (race.getCode().equals(code)) {
        return race;
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
