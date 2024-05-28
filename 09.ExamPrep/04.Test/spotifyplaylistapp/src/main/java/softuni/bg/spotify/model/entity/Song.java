package softuni.bg.spotify.model.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "songs")
@Getter
@Setter
public class Song extends BaseEntity{
    @Column(nullable = false, unique = true)
    private String performer;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Integer duration;

    @Column
    private LocalDate releaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_style")
    private Style style;

    @ManyToMany(mappedBy = "playlist")
    private Set<User> users;

}
