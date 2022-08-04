package creational.builder;

import com.iofit.creational.builder.Harmony;
import com.iofit.creational.builder.Melody;
import com.iofit.creational.builder.Rhythym;
import com.iofit.creational.builder.Song;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestSongBuilder {

    @Test
    public void testSongBuilder() {
        Song song = Song.SongBuilder.getInstance()
                .addHarmony(new Harmony())
                .addMelody(new Melody())
                .addRhythym(new Rhythym())
                .build();

        assertThat(song.play()).isEqualTo("wowowowowowo");
    }
}
