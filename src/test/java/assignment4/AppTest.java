package assignment4;

import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.mockito.Mockito.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest({App.class, Game.class, Player.class})
public class AppTest 
{
    @Rule
    public final TextFromStandardInputStream inputStream = emptyStandardInputStream();

    @Test
    public void TestMain() throws Throwable {
        Game mockGame = PowerMockito.mock(Game.class);

        mockGame.scoreBoard = new ScoreBoard();

        mockGame.board = mock(Board.class);
        doNothing().when(mockGame.board).clear();

        PowerMockito.whenNew(Game.class).withNoArguments().thenReturn(mockGame);
        doNothing().when(mockGame).play();

        inputStream.provideLines("MockPlayerName", "n");
        App.main(new String[] {""});
    }

    @Test
    public void TestApp() {
        App app = new App();
        assertTrue(!app.equals(null));
    }
}
