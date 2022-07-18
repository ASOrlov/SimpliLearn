package com.example.sportyshoes.repository;

import com.example.sportyshoes.entity.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long>, JpaSpecificationExecutor<PurchaseEntity> {


    //Initially i did JPQL Querry, but next time i think that i need Criteria API
    //@Query("SELECT p from purchases p where p.date between :from and :to and p.product.category=:category")
    //List<PurchaseEntity> getPurchaseReportByDateIntervalAndCategory(@Param("from") LocalDateTime from,@Param("to") LocalDateTime to,@Param("category") CategoryEntity category);


    default List<PurchaseEntity> getPurchaseReportByDateIntervalAndCategory(LocalDateTime from, LocalDateTime to, CategoryEntity category) {
        return findAll(new Specification<PurchaseEntity>() {
            @Override
            public Predicate toPredicate(Root<PurchaseEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list=new ArrayList<>();

                if (from!=null){
                    list.add(
                            criteriaBuilder.and(
                                    criteriaBuilder.greaterThan(
                                            root.get(PurchaseEntity_.date),from)));
                }
                if (to!=null) {
                    list.add(
                            criteriaBuilder.and(
                                    criteriaBuilder.lessThan(
                                            root.get(PurchaseEntity_.date),to)));
                }

                if (category!=null) {
                    list.add(
                            criteriaBuilder.and(
                                    criteriaBuilder.equal(
                                            root.get( PurchaseEntity_.product).get(ProductEntity_.category),category))
                    );
                }

                Predicate[] p=new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(p));
            }
        });
    }


}
