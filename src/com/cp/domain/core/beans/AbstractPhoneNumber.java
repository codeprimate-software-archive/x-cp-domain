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

/**
 * The AbstractPhoneNumber class is...
 * <p/>
 * AbstractPhoneNumber.java (c) 19 December 2010
 * @author jblum
 * @version $Revision: 1.2 $
 * @see com.cp.common.beans.AbstractBean
 * @see com.cp.common.beans.annotation.Required
 * @see com.cp.domain.core.beans.PhoneNumber
 */
public abstract class AbstractPhoneNumber extends AbstractBean<Long> implements PhoneNumber {

  private String areaCode;
  private String prefix;
  private String suffix;
  private String extension;

  public AbstractPhoneNumber() {
  }

  public AbstractPhoneNumber(final Long id) {
    super(id);
  }

  public AbstractPhoneNumber(final String areaCode, final String prefix, final String suffix) {
    setAreaCode(areaCode);
    setPrefix(prefix);
    setSuffix(suffix);
  }

  public String getAreaCode() {
    return areaCode;
  }

  @Required
  public void setAreaCode(final String areaCode) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractPhoneNumber.this.areaCode = areaCode;
      }
    };
    processChange("areaCode", this.areaCode, areaCode, callbackHandler);
  }

  public String getPrefix() {
    return prefix;
  }

  @Required
  public void setPrefix(final String prefix) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractPhoneNumber.this.prefix = prefix;
      }
    };
    processChange("prefix", this.prefix, prefix, callbackHandler);
  }

  public String getSuffix() {
    return suffix;
  }

  @Required
  public void setSuffix(final String suffix) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractPhoneNumber.this.suffix = suffix;
      }
    };
    processChange("suffix", this.suffix, suffix, callbackHandler);
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(final String extension) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractPhoneNumber.this.extension = extension;
      }
    };
    processChange("extension", this.extension, extension, callbackHandler);
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof PhoneNumber)) {
      return false;
    }

    final PhoneNumber that = (PhoneNumber) obj;

    if (isNew() && that.isNew()) {
      return ObjectUtil.equals(getAreaCode(), that.getAreaCode())
        && ObjectUtil.equals(getPrefix(), that.getPrefix())
        && ObjectUtil.equals(getSuffix(), that.getSuffix())
        && ObjectUtil.equals(getExtension(), that.getExtension());
    }

    return ObjectUtil.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    int hashValue = 17;
    if (isNew()) {
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getAreaCode());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getPrefix());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getSuffix());
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getExtension());
    }
    else {
      hashValue = 37 * hashValue + ObjectUtil.hashCode(getId());
    }
    return hashValue;
  }

}
