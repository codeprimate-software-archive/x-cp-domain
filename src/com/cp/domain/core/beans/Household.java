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
import com.cp.common.util.Filter;
import java.util.Collection;

/**
 * The Household class is a model for a grouping of people residing in the same location and considered lawfully as a
 * family unit.
 * <p/>
 * Household.java (c) 18 December 2010
 * @author jblum
 * @version $Revision: 1.1 $
 * @see com.cp.common.beans.Bean
 * @see com.cp.domain.core.beans.Addressable
 * @see com.cp.domain.core.beans.Callable
 * @see com.cp.domain.core.beans.Person
 * @see java.lang.Iterable
 */
public interface Household<M extends Person> extends Addressable, Bean<Long>, Callable, Iterable<M> {

  public M getHeadOfHousehold();

  public boolean add(M member);

  public boolean addAll(Collection<M> members);

  public M get(Filter<M> filter);

  public Collection<M> find(Filter<M> filter);

  public boolean remove(M member);

  public boolean removeAll(Collection<M> members);

  public int size();

}
