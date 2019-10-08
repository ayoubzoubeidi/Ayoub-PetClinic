package services.map;

import maz.spring.maz.petclinic.model.Owner;
import maz.spring.maz.petclinic.services.OwnerService;
import maz.spring.maz.petclinic.services.PetService;
import maz.spring.maz.petclinic.services.PetTypeService;
import maz.spring.maz.petclinic.services.map.OwnerServiceMap;
import maz.spring.maz.petclinic.services.map.PetServiceMap;
import maz.spring.maz.petclinic.services.map.PetTypeServiceMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        ownerServiceMap.save(Owner.builder().id(1L).build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerServiceMap.save(owner2);
        assertEquals(id, savedOwner.getId());

    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());
        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(0, owners.size());
    }

    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(ownerId, smith.getId());
        // Problem in findByLastName implementation  null pointer (Lambda && Streams)
    }
}