package com.transporte_simple.web.persistence.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "capacity")
public class CapacityEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "1000kg+")
    private boolean thousandOrMore;
    @Column(name = "3000kg+")
    private boolean threeThousandOrMore;
    @Column(name = "5000kg+")
    private boolean fiveThousandOrMore;
    @Column(name = "10000kg+")
    private boolean tenThousandOrMore;
    @Column(name = "15000kg+")
    private boolean fifteenThousandOrMore;
    @Column(name = "20000kg+")
    private boolean twentyThousandOrMore;
    @Column(name = "25000kg+")
    private boolean twentyFiveThousandOrMore;

}
