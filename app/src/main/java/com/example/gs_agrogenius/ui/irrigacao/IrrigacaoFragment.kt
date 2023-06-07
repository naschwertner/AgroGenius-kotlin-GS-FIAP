package com.example.gs_agrogenius.ui.irrigacao

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gs_agrogenius.R
import com.example.gs_agrogenius.databinding.FragmentIrrigacaoBinding
import androidx.core.os.bundleOf
import kotlinx.parcelize.Parcelize

@Parcelize
data class Plantacao(val nomeResId: Int, var estaSelecionado: Boolean): Parcelable

@Parcelize
data class PlantacaoSelecionada(val nome: String): Parcelable

class IrrigacaoFragment : Fragment() {

    private lateinit var binding: FragmentIrrigacaoBinding

    private val plantacoes = listOf(
        Plantacao(R.string.frag_irrig_plant, false),
        Plantacao(R.string.frag_irrig_plant2, false),
        Plantacao(R.string.frag_irrig_plant3, false),
        Plantacao(R.string.frag_irrig_plant4, false)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentIrrigacaoBinding.inflate(inflater, container, false)

        val switches = listOf(
            binding.cafe,
            binding.soja,
            binding.milho,
            binding.trigo
        )

        switches.forEachIndexed { index, switch ->
            switch.text = getString(plantacoes[index].nomeResId)
            switch.isChecked = plantacoes[index].estaSelecionado
            switch.setOnCheckedChangeListener { _, isChecked ->
                plantacoes[index].estaSelecionado = isChecked
            }
        }

        binding.button2.setOnClickListener {
            val selectedPlantacoes = plantacoes.filter { it.estaSelecionado }
                .map { PlantacaoSelecionada(getString(it.nomeResId)) }
            val bundle = bundleOf("selectedPlantacoes" to selectedPlantacoes)

            findNavController().navigate(
                R.id.action_nav_irrigacao_to_resultadoIrrigacaoFragment,
                bundle
            )
        }

        return binding.root
    }
}
