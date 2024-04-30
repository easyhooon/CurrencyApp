import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.screen.HomeScreen

@Composable
@Preview
fun App() {
    // 여기서 Koin 을 초기화 하면 iOS Simulator 에서 Keyboard 가 올라올 때, 문제가 발생(CoroutineException)
    // 각각의 플랫폼에서 Koin 을 초기화 하는 방법으로 해결
    // initializeKoin()
    Napier.base(DebugAntilog())

    MaterialTheme {
        Navigator(HomeScreen())
    }
}