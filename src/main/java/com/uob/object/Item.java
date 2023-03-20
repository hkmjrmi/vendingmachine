package com.uob.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Item")
public class Item  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;

    private String name;

    private Double price;

    private String category;

    private String size;

    @ManyToOne
    @JoinColumn(name = "slot_id")
    private Slot slot;


}
