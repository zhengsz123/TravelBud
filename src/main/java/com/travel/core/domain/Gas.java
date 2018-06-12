package com.travel.core.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "gas")
public class Gas implements Serializable {


    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "gas_id_seq")
    @SequenceGenerator(name = "gas_id_seq",sequenceName = "gas_id_seq",allocationSize = 1)
    private long id;

    @Column(name = "gas_type")
    private String gasType;

    @OneToMany (fetch = FetchType.LAZY, mappedBy = "gas",cascade = CascadeType.ALL)
    private List<Station> stations;





    public long getId() {
        return id;
    }




    public void setId(long id) {
        this.id = id;
    }




}