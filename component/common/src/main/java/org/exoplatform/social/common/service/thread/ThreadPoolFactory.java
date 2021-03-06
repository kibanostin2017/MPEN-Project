/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.common.service.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

public interface ThreadPoolFactory {

  /**
   * Creates a new cached thread pool
   * <br>
   * The cached thread pool is a term from the JDK from the method {@link java.util.concurrent.Executors#newCachedThreadPool()}.
   * Typically it will have no size limit (this is why it is handled separately
   *
   * @param threadFactory factory for creating threads
   * @return the created thread pool
   */
  ExecutorService newCachedThreadPool(ThreadFactory threadFactory);
  
  /**
   * Create a thread pool using the given thread pool profile
   * 
   * @param config parameters of the thread pool
   * @param threadFactory factory for creating threads
   * @return the created thread pool
   */
  ExecutorService newThreadPool(ThreadPoolConfig config, ThreadFactory threadFactory);
  
  /**
   * Create a scheduled thread pool using the given thread pool profile
   * @param config parameters of the thread pool
   * @param threadFactory factory for creating threads
   * @return the created thread pool
   */
  ScheduledExecutorService newScheduledThreadPool(ThreadPoolConfig config, ThreadFactory threadFactory);
}
