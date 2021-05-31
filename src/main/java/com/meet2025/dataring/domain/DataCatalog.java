package com.meet2025.dataring.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;

/**
 * @author Roy Cao
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DataCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public DataCatalog(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Column(unique = true)
    @NotNull
    private String name;
    private String description;


}
