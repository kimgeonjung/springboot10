package edu.du.sb1120_mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TeamRepository extends MongoRepository<Team, Integer> {
    //@Query("{id :?0}")
    List<Team> getTeamBy(Integer id);
}
