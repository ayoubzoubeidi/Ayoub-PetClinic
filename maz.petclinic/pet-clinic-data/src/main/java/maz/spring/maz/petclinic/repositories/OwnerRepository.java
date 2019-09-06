package maz.spring.maz.petclinic.repositories;

import maz.spring.maz.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
