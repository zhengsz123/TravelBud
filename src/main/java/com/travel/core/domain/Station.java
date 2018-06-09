package com.travel.core.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "station")
public class Station {


    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "station_id_seq")
    private long id;

    @Column(name = "gas_price")
    private String gasPrice;
    @Column(name = "gas_location")
    private  String gasLocation;
    @Column (name = "gas_brand")
    private String gasBrand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "gas_id")
    private Gas gas;


    public long getId() {
        return id;
    }

    public String getGasPrice() {
        return gasPrice;
    }

    public String getGasLocation() {
        return gasLocation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    public void setGasLocation(String gasLocation) {
        this.gasLocation = gasLocation;
    }
}
