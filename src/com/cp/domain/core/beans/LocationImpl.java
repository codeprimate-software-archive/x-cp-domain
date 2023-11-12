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

import com.cp.common.lang.ObjectUtil;
import java.awt.Point;

/**
 * The LocationImpl class is...
 * <p/>
 * LocationImpl.java (c) 19 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see java.awt.Point
 */
public class LocationImpl implements Location {

  private final double latitude;
  private final double longitude;

  public LocationImpl(final double latitude, final double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Point getPoint() {
    return new Point(getLatitude().intValue(), getLongitude().intValue());
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Location)) {
      return false;
    }

    final Location that = (Location) obj;

    return ObjectUtil.equals(getLatitude(), that.getLatitude())
      && ObjectUtil.equals(getLongitude(), that.getLongitude());
  }

  @Override
  public int hashCode() {
    int hashValue = 17;
    hashValue = 37 * hashValue + ObjectUtil.hashCode(getLatitude());
    hashValue = 37 * hashValue + ObjectUtil.hashCode(getLongitude());
    return hashValue;
  }

  @Override
  public String toString() {
    final StringBuilder buffer = new StringBuilder(String.valueOf(getLatitude()));
    buffer.append(", ");
    buffer.append(String.valueOf(getLongitude()));
    return buffer.toString();
  }

}
