package com.example.backend.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity(name = "complaints")
public class ComplaintEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private UserEntity customer;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private UserEntity manager;

    @OneToOne
    @JoinColumn(name = "engineer_id")
    private UserEntity engineer;

    @OneToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;

    @Column(nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(nullable = false,name = "typeofproblem_id")
    private TypeOfProblemEntity typeOfProblem;

    @Column
    private String feedback;

    public ComplaintEntity(TypeOfProblemEntity typeOfProblem, String description,StatusEntity status, UserEntity customer) {
        this.typeOfProblem = typeOfProblem;
        this.description = description;
        this.status=status;
        this.customer=customer;
    }

}
