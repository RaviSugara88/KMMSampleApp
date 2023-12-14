package navigation

interface LoginEvent {
    data object ClickButtonA: LoginEvent
    data class UpdateText(val text: String): LoginEvent
}