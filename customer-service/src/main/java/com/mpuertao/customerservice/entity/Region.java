package com.mpuertao.customerservice.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_regions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
