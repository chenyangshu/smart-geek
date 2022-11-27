package com.smartgeek.component.demo.app.event;

import com.smartgeek.component.demo.domain.customer.event.CustomerUpdateEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerEventHandler {


  @EventListener
  public void handleCustomerUpdateEvent(CustomerUpdateEvent e){
    System.out.println("收到消息");
    System.out.println(e.getCustomer().getCustomerId());
    System.out.println(e.getCustomer().getName());
  }

  /**
   * 有事务问题
   * @param e
   */
  @EventListener
  public void handleCustomerUpdateEventForException(CustomerUpdateEvent e){
    System.out.println("异常了");
    throw new RuntimeException();
  }

}
