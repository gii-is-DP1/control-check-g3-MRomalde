package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom,Integer>{
    List<RecoveryRoom> findAll();
    @Query("SELECT r FROM recovery_room_type r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    @Query("SELECT r FROM recovery_room_type r WHERE r.name = ?1")
    RecoveryRoomType getRecoveryRoomType(String name);
    @Query("SELECT r FROM recovery_room r WHERE r.size > ?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
