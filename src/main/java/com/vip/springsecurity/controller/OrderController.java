package com.vip.springsecurity.controller;

import com.vip.springsecurity.dto.AgentOrderDto;
import com.vip.springsecurity.entity.Orders;
import com.vip.springsecurity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Orders saveOrder(@RequestBody Orders orders){
        return orderService.saveOrder(orders);
    }

    @GetMapping("/agent/{agentId}")
    public List<Orders> getAgentOrders(@PathVariable Long agentId){
        return orderService.getAgentOrders(agentId);
    }

    @PutMapping("/assignToAgent")
        public boolean assignToAgent(@RequestBody AgentOrderDto agentOrderDto){
            return orderService.assignToAgent(agentOrderDto);
        }

    @GetMapping("/admin")
    public List<Orders> getAdminOrders(){
        return orderService.getAllOrders();
    }

    @PutMapping("/assignToAdmin")
    public void assignToAdmin(@RequestBody Orders orders){
         orderService.assignToAdmin(orders);
    }

}
