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

import com.cp.common.beans.Bean;
import com.cp.domain.core.enums.Gender;
import com.cp.domain.core.enums.Race;
import java.util.Calendar;

/**
 * The Person class is a model for a human being.
 * <p/>
 * Person.java (c) 18 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see com.cp.common.beans.Bean
 * @see com.cp.domain.core.enums.Gender
 * @see com.cp.domain.core.enums.Race
 * @see java.util.Calendar
 */
public interface Person extends Bean<Long> {

  public int getAge();

  public Calendar getDateOfBirth();

  public void setDateOfBirth(Calendar dateOfBirth);

  public String getFirstName();

  public void setFirstName(String firstName);

  public String getFullName();

  public Gender getGender();

  public void setGender(Gender gender);

  public String getLastName();

  public void setLastName(String lastName);

  public String getMiddleInitial();

  public void setMiddleInitial(String middleInitial);

  public Race getRace();

  public void setRace(Race race);

  public String getSuffix();

  public void setSuffix(String suffix);

  public String getTitle();

  public void setTitle(String title);

}
