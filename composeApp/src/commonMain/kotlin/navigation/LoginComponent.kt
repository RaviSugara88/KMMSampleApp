package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class LoginComponent(
    componentContext: ComponentContext,
    private val onNavigateToScreenB: (String) -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: LoginEvent) {
        when(event) {
            LoginEvent.ClickButtonA -> onNavigateToScreenB(text.value)
            is LoginEvent.UpdateText -> {
                _text.value = event.text
            }
        }
    }
}