package com.training.mongodb.mongodbproj.entities;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IEmployeeDao extends MongoRepository<Employee,String> {

    List<Employee> findByFirstName(String firstName);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<Employee> findByWeightBetween(Integer min,Integer max);

    @Query("{firstName: ?0}")
    List<Employee> searchWithFirstName(String firstName);

    @Query(value = "{firstName: ?0}",fields = "{firstName: 1, lastName: 1}")
    List<Employee> searchWithFirstName2(String firstName);

    @Aggregation(pipeline = {
        "{'$match': {'weight': {'$gt': ?0}}}",
        "{'$sort': {'firstName': 1}}"
    })
    List<Employee> aggregateEmployeeWeight(Integer we);

}
