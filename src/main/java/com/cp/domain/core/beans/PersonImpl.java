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

package com.cp.domain.core.beans;

import com.cp.common.beans.AbstractBean;
import com.cp.common.beans.annotation.Required;
import com.cp.common.lang.ObjectUtil;
import com.cp.common.lang.StringUtil;
import com.cp.common.util.DateUtil;
import com.cp.domain.core.enums.Gender;
import com.cp.domain.core.enums.Race;
import java.util.Calendar;

/**
 * The PersonImpl class is...
 * <p/>
 * PersonImpl.java (c) 18 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see com.cp.common.beans.AbstractBean
 * @see com.cp.common.beans.annotation.Required
 * @see com.cp.domain.core.beans.Person
 * @see com.cp.domain.core.enums.Gender
 * @see com.cp.domain.core.enums.Race
 * @see java.util.Calendar
 */
public class PersonImpl extends AbstractBean<Long> implements Person {

  private Calendar dateOfBirth;

  private Gender gender;

  private Race race;

  private String firstName;
  private String lastName;
  private String middleInitial;
  private String suffix;
  private String title;

  public PersonImpl() {
  }

  public PersonImpl(final String firstName, final String lastName, final Calendar dateOfBirth) {
    setFirstName(firstName);
    setLastName(lastName);
    setDateOfBirth(dateOfBirth);
  }

  public int getAge() {
    return DateUtil.getDiffInYears(getDateOfBirth());
  }

  public Calendar getDateOfBirth() {
    return DateUtil.copy(dateOfBirth);
  }

  @Required
  public void setDateOfBirth(final Calendar dateOfBirth) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.dateOfBirth = DateUtil.copy(dateOfBirth);
      }
    };
    processChange("dateOfBirth", getDateOfBirth(), DateUtil.copy(dateOfBirth), callbackHandler);
  }

  public String getFirstName() {
    return firstName;
  }

  @Required
  public void setFirstName(final String firstName) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.firstName = firstName;
      }
    };
    processChange("firstName", this.firstName, firstName, callbackHandler);
  }

  public String getFullName() {
    final StringBuilder buffer = new StringBuilder(getFirstName());

    buffer.append(" ");

    if (StringUtil.isNotBlank(getMiddleInitial()) ) {
      buffer.append(getMiddleInitial());
      buffer.append(" ");
    }

    buffer.append(getLastName());

    if (StringUtil.isNotBlank(getSuffix())) {
      buffer.append(" ");
      buffer.append(getSuffix());
    }

    return buffer.toString();
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(final Gender gender) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.gender = gender;
      }
    };
    processChange("gender", this.gender, gender, callbackHandler);
  }

  public String getLastName() {
    return lastName;
  }

  @Required
  public void setLastName(final String lastName) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.lastName = lastName;
      }
    };
    processChange("lastName", this.lastName, lastName, callbackHandler);
  }

  public String getMiddleInitial() {
    return middleInitial;
  }

  public void setMiddleInitial(final String middleInitial) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.middleInitial = middleInitial;
      }
    };
    processChange("middleInitial", this.middleInitial, middleInitial, callbackHandler);
  }

  public Race getRace() {
    return race;
  }

  public void setRace(final Race race) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.race = race;
      }
    };
    processChange("race", this.race, race, callbackHandler);
  }

  public String getSuffix() {
    return suffix;
  }

  public void setSuffix(final String suffix) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.suffix = suffix;
      }
    };
    processChange("suffix", this.suffix, suffix, callbackHandler);
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(final String title) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        PersonImpl.this.title = title;
      }
    };
    processChange("title", this.title, title, callbackHandler);
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Person)) {
      return false;
    }

    final Person that = (Person) obj;

    if (isNew() && that.isNew()) {
      return ObjectUtil.equals(getFirstName(), that.getFirstName())
        && ObjectUtil.equals(getLastName(), that.getLastName())
        && ObjectUtil.equals(getDateOfBirth(), that.getDateOfBirth());
    }

    return ObjectUtil.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    int hashValue = 17;
    if (isNew()) {
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getFirstName());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getLastName());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getDateOfBirth());
    }
    else {
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getId());
    }
    return hashValue;
  }

}
