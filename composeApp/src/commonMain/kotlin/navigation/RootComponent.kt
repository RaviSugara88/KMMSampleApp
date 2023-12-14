package navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent (
    componentContext: ComponentContext
) : ComponentContext by componentContext{

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer =Configuration.serializer(),
        initialConfiguration = Configuration.Login,
        handleBackButton = true,
        childFactory = ::createChild

    )
    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config){
            Configuration.Login -> Child.Login(
                LoginComponent(componentContext = context,
                    onNavigateToScreenB = { text ->
                        navigation.pushNew(Configuration.Registration(text))
                    })
            )
            is Configuration.Registration -> Child.Registration(
                RegistrationComponent(
                    text = config.text,
                    componentContext = context,
                    onGoBack = {
                        navigation.pop()
                    }
                )
            )
        }

    }

    sealed class Child {
        data class Login(val component: LoginComponent):Child()
        data class Registration(val component: RegistrationComponent) : Child()
    }

   // @Suppress("PLUGIN_IS_NOT_ENABLED")
    @Serializable
    sealed class Configuration {
        @Serializable
        data object Login : Configuration()

        @Serializable
        data class Registration(val text: String) : Configuration()
    }
}

