package screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import navigation.RegistrationComponent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui_component.ButtonWithCutCornerShape
import ui_component.CustomOutlinedTextField

import ui_component.MarginsToTop
import ui_component.appIcon


//@Preview
@Composable

fun Registation(
    text: String, component: RegistrationComponent
){


  //  val context = LocalContext.current
  //  val configuration = LocalConfiguration.current
    val focusManager = LocalFocusManager.current
    val scrollState = rememberScrollState()
 //   val screenHeight = configuration.screenHeightDp.dp
    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phoneNo by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var dob by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    var validateName by rememberSaveable { mutableStateOf(true) }
    var validateEmail by rememberSaveable { mutableStateOf(true) }
    var validatePhoneNo by rememberSaveable { mutableStateOf(true) }
    var validateAddress by rememberSaveable { mutableStateOf(true) }
    //  var validatgender by rememberSaveable { mutableStateOf(true) }
    // var validatdob by rememberSaveable { mutableStateOf(true) }
    var validatePassword by rememberSaveable { mutableStateOf(true) }
    var isPasswordVisible by rememberSaveable { mutableStateOf(false)}

    val validateNameError = "Please, input a valid name"
    val validateEmailError ="The format of the email doesn't seem right"
    val validatePhoneNoError ="The format of the phone number doesn't seem right"
    val validatePasswordError ="Must mix capital and non-capital letters, a number, special character and a minimum length of 8"

    Surface() {
        val materialBlue700= Color(0xFF1976D2)
        val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))

        Scaffold(
        ) { contentPadding ->
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .verticalScroll(scrollState),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
               /* CustomToolbar(title = "Registration") {
                    navHostController.popBackStack()
                }*/

                MarginsToTop(20.dp)
                appIcon()
             //   MarginsToTop(screenHeight = (screenHeight*2/100))
             //   HeadingText(text = stringResource(R.string.enter_your_detail))
                //  SimpleText(text = stringResource(R.string.info_otp))
                MarginsToTop(screenHeight = 16.dp)

                CustomOutlinedTextField(
                    value = name,
                    onValueChange = {name=it},
                    label = "Name",
                    showError = !validateName,
                    errorMessage = validateNameError,
                    leadingIconImageVector = Icons.Default.Person,
                    leadingIconDescription = "na",
                    keyBoardOption = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    )
                )
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
                CustomOutlinedTextField(
                    value = phoneNo,
                    onValueChange = {phoneNo=it},
                    textLength = 10,
                    label = "Phone Number",
                    showError = !validatePhoneNo,
                    errorMessage = validatePhoneNoError,
                    leadingIconImageVector = Icons.Default.Phone,
                    leadingIconDescription = "na",
                    keyBoardOption = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),
                )
                CustomOutlinedTextField(
                    value = address,
                    onValueChange = {address=it},
                    label = "Address",
                    leadingIconImageVector = Icons.Default.Home,
                    leadingIconDescription = "na",
                    keyBoardOption = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        // onNext = {focusManager.moveFocus(FocusDirection.Down)}
                    ),
                )
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

                MarginsToTop(screenHeight = 10.dp)
                ButtonWithCutCornerShape("Register"){
                   // component.goBack()
                  //  register(name,email,phoneNo,password,address)
                }

                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 28.dp)
                        .clickable {
                           // navigateToLogin(navHostController)
                            component.goBack()

                        },text = "Login", style = TextStyle(color = Color.Blue, fontSize = 14.sp),
                        textDecoration = TextDecoration.Underline)
                }




            }

        }


    }

}

