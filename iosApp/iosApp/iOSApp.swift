import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    
    init() {
        KoinModuleKt.initializeKoin()
    }
    
	var body: some Scene {
		WindowGroup {
            // EnableEdgeToEdge 는 플랫퐁 종속적인 API 이기 때문에, iOS 에서는 적용되지 않음
            // .ignoresSafeArea() 를 통해 EnableEdgeToEdge 와 같은 효과를 적용할 수 있음.
            ContentView().ignoresSafeArea()
		}
	}
}
