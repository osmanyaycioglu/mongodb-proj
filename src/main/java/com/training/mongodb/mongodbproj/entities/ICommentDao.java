package com.training.mongodb.mongodbproj.entities;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICommentDao  extends MongoRepository<Comment,String> {
}
