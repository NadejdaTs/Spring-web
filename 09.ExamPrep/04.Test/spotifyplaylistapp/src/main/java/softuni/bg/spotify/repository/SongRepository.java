package softuni.bg.spotify.repository;

import softuni.bg.spotify.model.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {
//    List<Song> findByUser(Optional<User> user);

//    @Query("SELECT s, u FROM Song s JOIN s.users u ON u.id = :id")
//    List<Song> findAllByUserId(@Param("id") String id);
//
//    Set<Song> findByStyle(Style style);
}
