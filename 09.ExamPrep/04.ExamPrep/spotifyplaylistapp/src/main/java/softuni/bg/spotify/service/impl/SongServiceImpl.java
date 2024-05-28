package softuni.bg.spotify.service.impl;

import org.springframework.stereotype.Service;
import softuni.bg.spotify.model.entity.User;
import softuni.bg.spotify.repository.SongRepository;
import softuni.bg.spotify.repository.UserRepository;
import softuni.bg.spotify.service.SongService;
import softuni.bg.spotify.service.StyleService;

import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {
    private final UserRepository userRepository;
    private final SongRepository songRepository;
    private final StyleService styleService;
    private final SongService songService;

    public SongServiceImpl(UserRepository userRepository, SongRepository songRepository, StyleService styleService, SongService songService) {
        this.userRepository = userRepository;
        this.songRepository = songRepository;
        this.styleService = styleService;
        this.songService = songService;
    }

//    @Override
//    public SongHomeViewModel getPlaylist(String username) {
//        Optional<User> user = this.userRepository.findByUsername(username);

//        List<Song> test = this.songRepository.findAllByUserId(user.get().getId());
//        List<SongDTO> songList = this.songRepository.findByUserId(user.get().getId()).stream()
//                .map(SongDTO::createFromTask)
//                .toList();

//        return new SongHomeViewModel(songList);
//        return null;
//    }

//    @Override
//    public SongsByTypeDTO getSongs() {
//        SongsByTypeDTO songs = new SongsByTypeDTO();
//
//        songs.setJazzSongs(this.getSongsByType(this.styleService.findStyleByName(StyleName.POP)));
//        return null;
//    }

//    @Override
//    public Set<SongDTO> findSongsByStyle(Style style) {
//        return this.songRepository.findByStyle(style).stream()
//                .map(this::mapSongDTO)
//                .collect(Collectors.toSet());
//    }

//    private Set<SongDTO> getSongsByType(Style style) {
//        return this.songService.findSongsByStyle(style);
//    }
//
//    private SongDTO mapSongDTO(Song song) {
//        SongDTO songDTO = new SongDTO();
//        songDTO.setId(song.getId());
//        songDTO.setDuration(song.getDuration());
//        songDTO.setPerformer(song.getPerformer());
//        songDTO.setTitle(song.getTitle());
//        return songDTO;
//    }
}
