package edu;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class SalesRep {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "salesRep", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @BatchSize(size = 3)  // n/batchSize+1
    @Fetch(FetchMode.SUBSELECT)
    private List<Customer> customers = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public SalesRep(String name) {
        this.name = name;
    }

    public boolean addCustomer(Customer c){

        if(customers.add(c)) {
            c.setSalesRep(this);
            return true;
        }

        return false;
    }
}
