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

package com.cp.domain.core.beans.support;

import com.cp.domain.core.beans.AbstractPhoneNumber;
import com.cp.domain.core.enums.PhoneNumberType;

/**
 * The HomePhoneNumber class is...
 * <p/>
 * HomePhoneNumber.java (c) 20 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see com.cp.domain.core.beans.AbstractPhoneNumber
 * @see com.cp.domain.core.enums.PhoneNumberType
 */
public class HomePhoneNumber extends AbstractPhoneNumber {

  public HomePhoneNumber() {
  }

  public HomePhoneNumber(final Long id) {
    super(id);
  }

  public HomePhoneNumber(final String areaCode, final String prefix, final String suffix) {
    super(areaCode, prefix, suffix);
  }

  @Override
  public final PhoneNumberType getType() {
    return PhoneNumberType.HOME;
  }

}
