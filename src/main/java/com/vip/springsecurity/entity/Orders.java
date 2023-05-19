package com.vip.springsecurity.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    @Column
    private String customerName;
    @Column
    private int customerContact;
    @Column
    private String customerAddress;
    @Column
    private Long assignedAgentId;
    @Column
    private String status;
}
