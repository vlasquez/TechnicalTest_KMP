import SwiftUI
import shared

@main
struct iOSApp: App {
	init() {
		DIModule.koin
	}
	var body: some Scene {
		WindowGroup {
			ComposeView()
		}
	}
}

struct ComposeView: UIViewControllerRepresentable {
	func makeUIViewController(context: Context) -> some UIViewController {
		// File name "Main" + "Kt" -> "Function Name"
		return MainViewControllerKt.MainViewController()
	}

	func updateUIViewController(_ uiViewController: UIViewControllerType, context: Context) {}
}
