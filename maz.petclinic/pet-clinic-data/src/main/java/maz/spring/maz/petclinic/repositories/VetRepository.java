package maz.spring.maz.petclinic.repositories;

import maz.spring.maz.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
