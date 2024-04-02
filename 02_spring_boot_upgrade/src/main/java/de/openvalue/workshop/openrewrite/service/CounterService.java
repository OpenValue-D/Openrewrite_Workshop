package de.openvalue.workshop.openrewrite.service;

import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ManagedBean;

@ManagedBean
public class CounterService
{
   private final AtomicInteger counter = new AtomicInteger( 0);

   public int incrementAndGet() {
      return counter.incrementAndGet();
   }
}
