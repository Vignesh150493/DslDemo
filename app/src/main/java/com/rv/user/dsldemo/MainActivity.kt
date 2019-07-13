package com.rv.user.dsldemo

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    inline fun <reified T>Activity.launchActivity(block : Intent.() -> Unit) {
        val intent = Intent(this, T::class.java)
        intent.block()
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val intent = Intent(this, SampleActivity::class.java)
//        intent.putExtra("first", "extra1")
//        intent.putExtra("second", "extra2")
//        intent.putExtra("third", "extra3")
//        intent.putExtra("fourth", "extra4")
//        startActivity(intent)
//

        launchActivity<SampleActivity>{
            putExtra("first", "extra1")
            putExtra("first", "extra1")
            putExtra("first", "extra1")
            putExtra("first", "extra1")
        }

//        val spannable1 = SpannableString("some formatted text")
//        spannable1.setSpan(StyleSpan(Typeface.BOLD), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        spannable1.setSpan(StyleSpan(Typeface.ITALIC), 6, 15, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
//        spannable1.setSpan(ForegroundColorSpan(Color.RED),17,21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        val spanned = spannable { bold("some") + italic(" formatted") + color(Color.RED, " text") }
        spanned_text.text = spanned


        uistate {
            stringfour = "four"
        }
    }

    fun spannable(func: () -> SpannableString) = func()

    fun bold(s: String) = span(s, StyleSpan(android.graphics.Typeface.BOLD))

    fun italic(s: String) = span(s, StyleSpan(android.graphics.Typeface.ITALIC))

    fun color(color: Int, s: String) = span(s, ForegroundColorSpan(color))

    private fun span(s : String, o : Any) : SpannableString {
        return SpannableString(s).apply {
            setSpan(o, 0, length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    operator fun SpannableString.plus(s: SpannableString) =
            SpannableString(this concat s)

    infix fun SpannableString.concat(s : SpannableString) : CharSequence {
        return TextUtils.concat(this, s)
    }
}
