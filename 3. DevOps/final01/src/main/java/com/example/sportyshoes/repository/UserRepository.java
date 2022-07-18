package com.example.sportyshoes.repository;

import com.example.sportyshoes.entity.*;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>, JpaSpecificationExecutor<UserEntity> {
    UserEntity findUserEntityByLogin(String name);

   // @Query("SELECT u from users u where u.login like :name")
   // List<UserEntity> findUsersWithPartOfName(@Param("name") String name, Sort sort);


    default List<UserEntity> findUsersWithPartOfName(String name, Sort sort) {
        return findAll(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

                List<Predicate> list=new ArrayList<>();

                if (name!=null){
                    return
                            criteriaBuilder.and(
                                    criteriaBuilder.like(
                                            root.get(UserEntity_.login),name));

                }
                return null;
            }
        }, sort);
    }


}