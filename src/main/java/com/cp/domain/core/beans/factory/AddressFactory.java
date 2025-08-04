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

package com.cp.domain.core.beans.factory;

import com.cp.domain.core.beans.AbstractAddress;
import com.cp.domain.core.beans.Address;
import com.cp.domain.core.beans.support.BillingAddress;
import com.cp.domain.core.beans.support.HomeAddress;
import com.cp.domain.core.beans.support.MailingAddress;
import com.cp.domain.core.beans.support.WorkAddress;
import com.cp.domain.core.enums.AddressType;
import com.cp.domain.core.enums.State;

/**
 * The AddressFactory class is...
 * <p/>
 * AddressFactory.java (c) 19 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see com.cp.domain.core.beans.AbstractAddress
 * @see com.cp.domain.core.beans.Address
 * @see com.cp.domain.core.beans.support.BillingAddress
 * @see com.cp.domain.core.beans.support.HomeAddress
 * @see com.cp.domain.core.beans.support.MailingAddress
 * @see com.cp.domain.core.beans.support.WorkAddress
 * @see com.cp.domain.core.enums.AddressType
 * @see com.cp.domain.core.enums.State
 */
public class AddressFactory {

  public static Address createAddress(final AddressType type) {
    switch (type) {
      case BILLING:
        return new BillingAddress();
      case HOME:
        return new HomeAddress();
      case MAILING:
        return new MailingAddress();
      case WORK:
        return new WorkAddress();
      default:
        return new DefaultAddress();
    }
  }

  public static Address createAddress(final AddressType type, final Long id) {
    switch (type) {
      case BILLING:
        return new BillingAddress(id);
      case HOME:
        return new HomeAddress(id);
      case MAILING:
        return new MailingAddress(id);
      case WORK:
        return new WorkAddress(id);
      default:
        return new DefaultAddress(id);
    }
  }

  public static Address createAddress(final AddressType type, final String street, final String unit, final String city, final State state, final String zipCode) {
    switch (type) {
      case BILLING:
        return new BillingAddress(street, unit, city, state, zipCode);
      case HOME:
        return new HomeAddress(street, unit, city, state, zipCode);
      case MAILING:
        return new MailingAddress(street, unit, city, state, zipCode);
      case WORK:
        return new WorkAddress(street, unit, city, state, zipCode);
      default:
        return new DefaultAddress(street, unit, city, state, zipCode);
    }
  }

  protected static final class DefaultAddress extends AbstractAddress {

    public DefaultAddress() {
    }

    public DefaultAddress(final Long id) {
      super(id);
    }

    public DefaultAddress(final String street,
                          final String unit,
                          final String city,
                          final State state,
                          final String zipCode)
    {
      super(street, unit, city, state, zipCode);
    }

    @Override
    public final AddressType getType() {
      return AddressType.UNTYPED;
    }
  }

}
