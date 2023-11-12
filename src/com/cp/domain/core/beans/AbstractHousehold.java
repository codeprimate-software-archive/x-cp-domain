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
import com.cp.common.lang.ObjectUtil;
import com.cp.common.util.CollectionUtil;
import com.cp.common.util.Filter;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * The AbstractHousehold class is...
 * <p/>
 * AbstractHousehold.java (c) 19 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see com.cp.common.beans.AbstractBean
 * @see com.cp.domain.core.beans.Household
 * @see com.cp.domain.core.beans.Person
 */
public abstract class AbstractHousehold<M extends Person> extends AbstractBean<Long> implements Household<M> {

  private Address address;

  private PhoneNumber phoneNumber;

  private final Set<M> members = new TreeSet<M>();

  public Address getAddress() {
    return address;
  }

  public void setAddress(final Address address) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractHousehold.this.address = address;
      }
    };
    processChange("address", this.address, address, callbackHandler);
  }

  public M getHeadOfHousehold() {
    M headOfHousehold = null;

    for (final M member : this) {
      if (ObjectUtil.isNull(headOfHousehold)) {
        headOfHousehold = member;
      }
      else {
        if (member.getDateOfBirth().before(headOfHousehold.getDateOfBirth())) {
          headOfHousehold = member;
        }
      }
    }

    return headOfHousehold;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(final PhoneNumber phoneNumber) {
    final StateChangeCallbackHandler callbackHandler = new StateChangeCallbackHandler() {
      public void changeState() {
        AbstractHousehold.this.phoneNumber = phoneNumber;
      }
    };
    processChange("phoneNumber", this.phoneNumber, phoneNumber, callbackHandler);
  }

  public boolean add(final M member) {
    return members.add(member);
  }

  public boolean addAll(final Collection<M> members) {
    return this.members.addAll(members);
  }

  public M get(final Filter<M> filter) {
    return CollectionUtil.findBy(members, filter);
  }

  public Collection<M> find(final Filter<M> filter) {
    return CollectionUtil.findAllBy(members, filter);
  }

  public Iterator<M> iterator() {
    return Collections.unmodifiableSet(members).iterator();
  }

  public boolean remove(final M member) {
    return members.remove(member);
  }

  public boolean removeAll(final Collection<M> members) {
    return this.members.removeAll(members);
  }

  public int size() {
    return members.size();
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }

    if (!(obj instanceof Household)) {
      return false;
    }

    final Household that = (Household) obj;

    return ObjectUtil.equals(getId(), that.getId());
  }

  @Override
  public int hashCode() {
    int hashValue = 17;
    hashValue = 37 * hashValue + ObjectUtil.hashCode(getId());
    return hashValue;
  }

}
