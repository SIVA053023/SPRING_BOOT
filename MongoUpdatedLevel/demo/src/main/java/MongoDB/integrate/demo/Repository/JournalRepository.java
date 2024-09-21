package MongoDB.integrate.demo.Repository;

import MongoDB.integrate.demo.Entries.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
@Document(collection = "journalentries")
public interface JournalRepository extends MongoRepository<JournalEntry, ObjectId > {

}
