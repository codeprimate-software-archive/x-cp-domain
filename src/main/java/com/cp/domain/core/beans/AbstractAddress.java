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
import com.cp.domain.core.enums.Country;
import com.cp.domain.core.enums.State;

/**
 * The AbstractAddress class is...
 * <p/>
 * AbstractAddress.java (c) 19 December 2010
 * @author jblum
 * @version $Revision: 1.2 $
 * @see com.cp.common.beans.AbstractBean
 * @see com.cp.common.beans.annotation.Required
 * @see com.cp.domain.core.beans.Address
 * @see com.cp.domain.core.enums.Country
 * @see com.cp.domain.core.enums.State
 */
public abstract class AbstractAddress extends AbstractBean<Long> implements Address {

  private Country country;

  private Location location;

  private State state;

  private String street;
  private String unit;
  private String city;
  private String county;
  private String zipCode;
  private String zipCodeExtension;

  public AbstractAddress() {
  }

  public AbstractAddress(final Long id) {
    super(id);
  }

  public AbstractAddress(final Location location) {
    setLocation(location);
  }

  public AbstractAddress(final String street,
                         final String unit,
                         final String city,
                         final State state,
                         final String zipCode)
  {
    setStreet(street);
    setUnit(unit);
    setCity(city);
    setState(state);
    setZipCode(zipCode);
  }

  public String getFullAddress() {
    final StringBuilder buffer = new StringBuilder(getStreet());

    buffer.append(" ");

    if (StringUtil.isNotBlank(getUnit())) {
      buffer.append(getUnit());
      buffer.append(" ");
    }

    buffer.append(getCity());
    buffer.append(", ");
    buffer.append(getState().getAbbreviation());
    buffer.append(" ");
    buffer.append(getZipCode());

    if (StringUtil.isNotBlank(getZipCodeExtension())) {
      buffer.append("-");
      buffer.append(getZipCodeExtension());
    }

    return buffer.toString();
  }

  public Location getLocation() {
    return location;
  }

  protected void setLocation(final Location location) {
    this.location = location;
  }

  public String getStreet() {
    return street;
  }

  @Required
  public void setStreet(final String street) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractAddress.this.street = street;
      }
    };
    processChange("street", this.street, street, callbackHandler);
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(final String unit) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractAddress.this.unit = unit;
      }
    };
    processChange("unit", this.unit, unit, callbackHandler);
  }

  public String getCity() {
    return city;
  }

  @Required
  public void setCity(final String city) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      @Override public void changeState() {
        AbstractAddress.this.city = city;
      }
    };
    processChange("city", this.city, city, callbackHandler);
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(final String county) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractAddress.this.county = county;
      }
    };
    processChange("county", this.county, county, callbackHandler);
  }

  public Country getCountry() {
    return country;
  }

  public void setCountry(final Country country) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractAddress.this.country = country;
      }
    };
    processChange("country", this.country, country, callbackHandler);
  }

  public State getState() {
    return state;
  }

  @Required
  public void setState(final State state) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractAddress.this.state = state;
      }
    };
    processChange("state", this.state, state, callbackHandler);
  }

  public String getZipCode() {
    return zipCode;
  }

  @Required
  public void setZipCode(final String zipCode) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractAddress.this.zipCode = zipCode;
      }
    };
    processChange("zipCode", this.zipCode, zipCode, callbackHandler);
  }

  public String getZipCodeExtension() {
    return zipCodeExtension;
  }

  public void setZipCodeExtension(final String zipCodeExtension) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      @Override public void changeState() {
        AbstractAddress.this.zipCodeExtension = zipCodeExtension;
      }
    };
    processChange("zipCodeExtension", this.zipCodeExtension, zipCodeExtension, callbackHandler);
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Address)) {
      return false;
    }

    final Address that = (Address) obj;

    if (isNew() && that.isNew()) {
      return ObjectUtil.equals(getStreet(), that.getStreet())
        && ObjectUtil.equals(getUnit(), that.getUnit())
        && ObjectUtil.equals(getCity(), that.getCity())
        && ObjectUtil.equals(getCounty(), that.getCounty())
        && ObjectUtil.equals(getState(), that.getState())
        && ObjectUtil.equals(getZipCode(), that.getZipCode())
        && ObjectUtil.equals(getZipCodeExtension(), that.getZipCodeExtension())
        && ObjectUtil.equals(getCountry(), that.getCountry());
    }

    return ObjectUtil.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    int hashValue = 17;
    if (isNew()) {
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getStreet());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getUnit());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getCity());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getCounty());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getState());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getZipCode());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getZipCodeExtension());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getCountry());
    }
    else {
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getId());
    }
    return hashValue;
  }

}
