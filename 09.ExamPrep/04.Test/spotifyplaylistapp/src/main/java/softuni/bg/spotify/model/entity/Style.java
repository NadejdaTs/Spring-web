package softuni.bg.spotify.model.entity;

import softuni.bg.spotify.model.entity.enums.StyleName;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "styles")
@Getter
@Setter
public class Style extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private StyleName name;

    @Column
    private String description;

    @OneToMany(mappedBy = "style", fetch = FetchType.LAZY)
    private Set<Song> songs;
}
