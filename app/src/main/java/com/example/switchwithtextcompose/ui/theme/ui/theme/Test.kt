import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview




data class SwitchState(val text: String, var isChecked: Boolean)
@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun MultipleSwitchesWithText() {
//    var switchStates by mutableStateOf(
//        mutableStateListOf(
//            SwitchState("Switch 1", false),
//            SwitchState("Switch 2", false),
//            SwitchState("Switch 3", false),
//            SwitchState("Switch 4", false),
//            SwitchState("Switch 5", false)
//        )
//    )
//
//    Column {
//        switchStates.forEach { switchState ->
//            SwitchWithText(
//                switchState.text,
//                switchState.isChecked,
//                onCheckedChange = { checked ->
//                    switchState.isChecked = checked
//                }
//            )
//        }
//    }

    val switchStates by remember { mutableStateOf(listOf(false, false, false)) }

    Column {
        repeat(switchStates.size) { index ->
            SwitchWithText(
                text = "Switch ${index + 1}",
                checked = switchStates[index],
                onCheckedChange = { checked ->
                    switchStates.toMutableList()[index] = checked
                }
            )
        }
    }

}

@Composable
fun SwitchWithText(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Column {
        Text(text = text)
        Spacer(modifier = Modifier.width(10.dp))
        Switch(checked = checked, onCheckedChange = onCheckedChange)
    }
}


//@Composable
//fun SwithTextTest1() {
//
//}
//@Preview
//@Composable
//fun MultipleSwitchesWithText() {
//    Column {
//        SwitchWithText("Who 1", checked = false)
//        SwitchWithText("are 2", checked = false)
//        SwitchWithText("You 3", checked = false)
//    }
//}
//
//@Composable
//fun SwitchWithText(text: String, checked: Boolean) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Switch(checked = checked, onCheckedChange = { /* Handle switch state change */ })
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(text = text)
//    }
//}
//@Preview
//@Composable
//fun MultipleSwitchesWithText1() {
//    var switchStates = mutableListOf(
//        List(9) { false }
//    )
//
//    Column {
//        for (index in switchStates.indices) {
//            SwitchWithText(
//                text = "Switch ${index + 1}",
//                checked = switchStates[index],
//                onCheckedChange = { checked ->
//                    switchStates = switchStates.toMutableList().apply {
//                        set(index, checked)
//                    }
//                }
//            )
//        }
//    }
//}
//@Composable
//fun SwitchWithText(text: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
//    Row(verticalAlignment = Alignment.CenterVertically) {
//        Switch(
//            checked = checked,
//            onCheckedChange = onCheckedChange
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//        Text(text = text)
//    }
//}