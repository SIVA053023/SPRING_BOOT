package MongoDB.integrate.demo.Repository;

import MongoDB.integrate.demo.Entries.JournalEntry;
import MongoDB.integrate.demo.Entries.UserEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface UserRepository extends MongoRepository<UserEntry, ObjectId > {
    UserEntry findByUsername (String username);

}
