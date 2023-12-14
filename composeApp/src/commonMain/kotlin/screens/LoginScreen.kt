package screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import navigation.LoginComponent
import navigation.LoginEvent
import ui_component.ButtonWithCutCornerShape
import ui_component.CustomOutlinedTextField
import ui_component.MultiColourEditText

//import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    component: LoginComponent
) {
    val text by component.text.subscribeAsState()
    var email by rememberSaveable { mutableStateOf("") }

    var password by rememberSaveable {
        mutableStateOf("")
    }
   // val screenHeight = configuration.screenHeightDp.dp
   // val context = LocalContext.current
    val focusManager = LocalFocusManager.current

   // val dataStore = StoreData(context)
    // a coroutine scope
    val scope = rememberCoroutineScope()
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false) }

    var validateEmailError by rememberSaveable { mutableStateOf("The format of the email doesn't seem right") }

    var validatePasswordError by rememberSaveable { mutableStateOf("Enter password") }
    var validateEmail by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        //(height = 10.dp)
        CustomOutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = "Email",
            showError = !validateEmail,
            errorMessage = validateEmailError,
            leadingIconImageVector = Icons.Default.Email,
            leadingIconDescription = "na",
            keyBoardOption = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {focusManager.moveFocus(FocusDirection.Down)}
            )
        )
        Spacer(Modifier.height(10.dp))
       // MarginsToTop(screenHeight = 10.dp)

        CustomOutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = "Password",
            leadingIconImageVector = Icons.Default.Lock,
            leadingIconDescription = "na",
            showError = !validatePassword,
            errorMessage = validatePasswordError,
            isPasswordField = true,
            isPasswordVisible = isPasswordVisible,
            onVisibilityChange ={isPasswordVisible=it},
            keyBoardOption = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {focusManager.clearFocus()}
            ),

            )

        Spacer(Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 28.dp)
                .clickable {
                    component.onEvent(LoginEvent.ClickButtonA)
                   /* navHostController.navigate(NavigationScreen.UserRegistrationScreen.route) {
                        *//**  launchSingleTop =true
                         * create only on instance in BackStack
                        like A-B-C-A-B = A-B-C
                         *//*
                        // launchSingleTop = true
                    }*/

                    /*
                                        Toast
                                            .makeText(context, "Jai Mata di", Toast.LENGTH_LONG)
                                            .show()
                    */
                },text = "Register", style = TextStyle(color = Color.Blue, fontSize = 14.sp),
                textDecoration = TextDecoration.Underline)
        }

        Spacer(Modifier.height(10.dp))

        ButtonWithCutCornerShape("Login") {
            //Add Event
            component.onEvent(LoginEvent.UpdateText("Jai Mata di..."))
        }

    }


}

//@Preview(name = "LoginScreen")
@Composable
private fun PreviewLoginScreen() {
   // LoginScreen()
}