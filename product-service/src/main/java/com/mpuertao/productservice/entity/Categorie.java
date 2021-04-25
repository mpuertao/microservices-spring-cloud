package com.mpuertao.productservice.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
