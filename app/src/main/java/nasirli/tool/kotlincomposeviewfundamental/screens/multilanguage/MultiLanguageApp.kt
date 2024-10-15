package nasirli.tool.kotlincomposeviewfundamental.screens.multilanguage

import android.annotation.SuppressLint
import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.core.os.LocaleListCompat
import nasirli.tool.kotlincomposeviewfundamental.R


@Composable
@Preview(showBackground = true)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun MultiLanguageApp() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = stringResource(id = R.string.greeting),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LazyColumn(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        item {
            Text(
                text = stringResource(id = R.string.title),
                modifier = modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        items(10) {
            Text(
                text = name, modifier = modifier,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        item {
            HorizontalDivider(Modifier.fillMaxWidth())
            LanguageSwitcher()
        }
    }
}

@Composable
fun LanguageSwitcher() {
    val context = LocalContext.current
    val languageCode = getSavedLanguage(context) ?: ""
    Column {
        Button(onClick = {
            setLanguage(context, "az")
        }) {
            Text(text = "Switch to Azerbaijan")
        }
        Button(onClick = {
            setLanguage(context, "en")
        }) {
            Text(text = "Switch to English")
        }
        Button(onClick = {
            setLanguage(context, "ru")
        }) {
            Text(text = "Switch to Rus")
        }
    }
}

private fun setLanguage(context: Context, languageCode: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        context.getSystemService(LocaleManager::class.java)
            .applicationLocales = LocaleList.forLanguageTags(languageCode)
    } else {
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
    }
    saveLanguage(context, languageCode)
}

private fun getSavedLanguage(context: Context): String? {
    val sharedPreferences = context.getSharedPreferences("MyPrivatePrefs", Context.MODE_PRIVATE)
    return sharedPreferences.getString("language", null)
}

private fun saveLanguage(context: Context, languageCode: String) {
    val sharedPreferences = context.getSharedPreferences("MyPrivatePrefs", Context.MODE_PRIVATE)
    sharedPreferences.edit().putString("language", languageCode).apply()
}