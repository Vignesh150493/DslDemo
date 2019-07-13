package com.rv.user.dsldemo

fun uistate(block : UiStateBuilder.() -> Unit) : Uistate = UiStateBuilder().apply(block).build()

class UiStateBuilder {

    var stringone = ""
    var stringtwo = ""
    var stringthree = ""
    var stringfour = ""
    var stringfive = ""
    var stringsix = ""
    var stringseven = ""
    var stringeight = ""
    var stringnine = ""
    var stringten = ""

    fun build() : Uistate = Uistate(stringone, stringtwo , stringthree, stringfour, stringfive,
            stringsix, stringseven, stringeight, stringnine, stringten)
}


//CLASS IN FOCUS
data class Uistate(val stringone : String, val stringtwo : String, val stringthree : String, val stringfour : String,
                   val stringfive : String, val stringsix : String, val stringseven : String, val stringeight : String,
                   val stringnine : String, val stringten : String)
//CLASS IN FOCUS
