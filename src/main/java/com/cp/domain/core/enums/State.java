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
 * The State enumerated type represents values of 50 states in the United State of America.
 * <p/>
 * State.java (c) 18 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 */
public enum State {
  ALABAMA(1, "AL", "Alabama"),
  ALASKA(2, "AK", "Alaska"),
  ARIZONA(3, "AZ", "Arizona"),
  ARKANSAS(4, "AR", "Arkansas"),
  CALIFORNIA(5, "CA", "California"),
  COLORADO(6, "CO", "Colarado"),
  CONNECTICUT(7, "CT", "Conneticut"),
  DELAWARE(8, "DE", "Delaware"),
  DISTRICT_OF_COLUMBIA(9, "DC", "Washington D.C."),
  FLORIDA(10, "FL", "Florida"),
  GEORGIA(11, "GA", "Georgia"),
  HAWAII(12, "HI", "Hawaii"),
  IDAHO(13, "ID", "Idaho"),
  ILLINOIS(14, "IL", "Illinois"),
  INDIANA(15, "IN", "Indiana"),
  IOWA(16, "IA", "Iowa"),
  KANSAS(17, "KS", "Kansas"),
  KENTUCKY(18, "KY", "Kentucky"),
  LOUISIANA(19, "LA", "Louisiana"),
  MAINE(20, "ME", "Maine"),
  MARYLAND(21, "MD", "Maryland"),
  MASSACHUSETTS(22, "MA", "Massachusetts"),
  MICHIGAN(23, "MI", "Michigan"),
  MINNESOTA(24, "MN", "Minnesota"),
  MISSISSIPPI(25, "MS", "Mississippi"),
  MISSOURI(26, "MO", "Missouri"),
  MONTANA(27, "MT", "Montana"),
  NEBRASKA(28, "NE", "Nebraska"),
  NEVADA(29, "NV", "Nevada"),
  NEW_HAMPSHIRE(30, "NH", "New Hampshire"),
  NEW_JERSEY(31, "NJ", "New Jersey"),
  NEW_MEXICO(32, "NM", "New Mexico"),
  NEW_YORK(33, "NY", "New York"),
  NORTH_CAROLINA(34, "NC", "North Carolina"),
  NORTH_DAKOTA(35, "ND", "North Dakota"),
  OHIO(36, "OH", "Ohio"),
  OKLAHOMA(37, "OK", "Oklahoma"),
  OREGON(38, "OR", "Oregon"),
  PENNSYLVANIA(39, "PA", "Pennsylvania"),
  RHODE_ISLAND(40, "RI", "Rhode Island"),
  SOUTH_CAROLINA(41, "SC", "South Carolina"),
  SOUTH_DAKOTA(42, "SD", "South Dakota"),
  TENNESSEE(43, "TN", "Tennessee"),
  TEXAS(44, "TX", "Texas"),
  UTAH(45, "UT", "Utah"),
  VERMONT(46, "VT", "Vermont"),
  VIRGINA(47, "VA", "Virgina"),
  WASHINGTON(48, "WA", "Washington"),
  WEST_VIRGINA(49, "WV", "West Virgina"),
  WISCONSIN(50, "WI", "Wisconsin"),
  WYOMING(51, "WY", "Wyoming");

  private final Integer id;

  private final String abbreviation;
  private final String description;

  State(final Integer id, final String abbreviation, final String description) {
    Assert.notNull(id, "The identifier for a State enumerated value cannot be null!");
    Assert.notBlank(abbreviation, "The State abbreviation must be specified!");
    this.id = id;
    this.abbreviation = abbreviation;
    this.description = description;
  }

  public static State getByAbbreviation(final String abbreviation) {
    for (final State state : values()) {
      if (state.getAbbreviation().equals(abbreviation)) {
        return state;
      }
    }

    return null;
  }

  public static State getById(final Integer id) {
    for (final State state : values()) {
      if (state.getId().equals(id)) {
        return state;
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
