package maz.spring.maz.petclinic.repositories;

import maz.spring.maz.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
