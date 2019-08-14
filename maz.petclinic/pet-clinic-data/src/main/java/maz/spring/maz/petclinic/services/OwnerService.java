package maz.spring.maz.petclinic.services;

import maz.spring.maz.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
