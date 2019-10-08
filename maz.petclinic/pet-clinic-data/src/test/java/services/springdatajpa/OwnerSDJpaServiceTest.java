package services.springdatajpa;

import maz.spring.maz.petclinic.model.Owner;
import maz.spring.maz.petclinic.repositories.OwnerRepository;
import maz.spring.maz.petclinic.repositories.PetRepository;
import maz.spring.maz.petclinic.repositories.PetTypeRepository;
import maz.spring.maz.petclinic.services.springdatajpa.OwnerSDJpaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    private final static String NAME = "Smith";
    private final static Long ID = 1L;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = Owner.builder().id(1L).lastName(NAME).build();
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner owner = service.findByLastName(NAME);
        assertEquals(NAME, owner.getLastName());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());
        ownerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);

        assertEquals(2, owners.size() );
    }

    @Test
    void findById() {
        Owner returnOwner = Owner.builder().id(1L).lastName(NAME).build();
        when(ownerRepository.findById(any())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);

    }

    @Test
    void save() {
        //given
        Owner ownerToSave = Owner.builder().id(1L).lastName(NAME).build();
        when(ownerRepository.save(any())).thenReturn(ownerToSave);

        //when
        Owner owner = service.save(ownerToSave);

        //then
        assertNotNull(owner);
        assertEquals(ownerToSave, owner);


    }

    @Test
    void delete() {
        service.delete(any());
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(any());
        verify(ownerRepository).deleteById(any());
    }
}