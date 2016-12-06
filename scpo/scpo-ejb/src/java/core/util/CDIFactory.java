/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.util;


/**
 *
 * @author erick.araujo
 */
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CDIFactory {

  @Produces
  public Logger producer(InjectionPoint ip){
    return LoggerFactory.getLogger(
      ip.getMember().getDeclaringClass().getName());
  }
}