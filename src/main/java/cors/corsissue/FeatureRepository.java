package cors.corsissue;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "features", path = "features")
public interface FeatureRepository extends CrudRepository<Feature, Long> {

}
