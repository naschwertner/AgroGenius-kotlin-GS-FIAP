package com.example.gs_agrogenius

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plantacao(
    val nome: String,
    var estaSelecionado: Boolean
) : Parcelable
