package maz.spring.maz.petclinic.repositories;

import maz.spring.maz.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
