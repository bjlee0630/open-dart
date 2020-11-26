package com.shinhaninvetment.opendart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.shinhaninvetment.opendart.repository.dto.Title;

public interface TitleRepository extends MongoRepository<Title, String>{

}
