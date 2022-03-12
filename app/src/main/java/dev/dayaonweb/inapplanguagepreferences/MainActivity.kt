package dev.dayaonweb.inapplanguagepreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout


private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {

    private lateinit var btnSetter: MaterialButton
    private lateinit var btnGetter: MaterialButton
    private lateinit var languageInput: TextInputLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hookViews()
        setupListeners()

        // Check current language - should be empty as it's unset
        logCurrentAppLanguage()

//        // Set a locale & log it to confirm being set
//        val languageLocaleToSet = "hi"
//        InAppLanguageHelper.setAppLanguage(languageTag = languageLocaleToSet)
//        logCurrentAppLanguage()

    }

    private fun hookViews() {
        btnSetter = findViewById(R.id.materialButtonSetter)
        btnGetter = findViewById(R.id.materialButton)
        languageInput = findViewById(R.id.ti)
    }

    private fun setupListeners() {
        btnGetter.setOnClickListener {
            Snackbar.make(
                this,
                findViewById(R.id.root),
                "Current app locale:${InAppLanguageHelper.getCurrentPreferredLanguage()}",
                Snackbar.LENGTH_LONG
            ).show()
        }
        btnSetter.setOnClickListener {
            val enteredLanguageLocale = languageInput.editText?.text?.toString() ?: ""
            if (enteredLanguageLocale.isEmpty())
                Snackbar.make(
                    this,
                    findViewById(R.id.root),
                    "Kindly enter a valid locale",
                    Snackbar.LENGTH_LONG
                ).show()
            else
                InAppLanguageHelper.setAppLanguage(languageTag = enteredLanguageLocale)
        }
    }


    private fun logCurrentAppLanguage() {
        val currentAppLanguage = InAppLanguageHelper.getCurrentPreferredLanguage()
        Log.d(TAG, "onCreate: currentAppLanguage=$currentAppLanguage")
    }
}