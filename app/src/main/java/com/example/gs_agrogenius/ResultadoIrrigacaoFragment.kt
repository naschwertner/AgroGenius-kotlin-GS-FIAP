package com.example.gs_agrogenius

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.gs_agrogenius.databinding.FragmentResultadoIrrigacaoBinding
import com.example.gs_agrogenius.ui.irrigacao.PlantacaoSelecionada

class ResultadoIrrigacaoFragment : Fragment() {

    private lateinit var binding: FragmentResultadoIrrigacaoBinding
    private lateinit var plantacoes: List<PlantacaoSelecionada>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultadoIrrigacaoBinding.inflate(inflater, container, false)

        // Resgatar dados da navegação
        arguments?.let {
            plantacoes = it.getParcelableArrayList<PlantacaoSelecionada>("selectedPlantacoes") ?: listOf()
            atualizarPlantacoesSelecionadas()
        }

        return binding.root
    }

    private fun atualizarPlantacoesSelecionadas() {
        binding.listaplantacoes.text = ""
        for (plantacao in plantacoes) {
            binding.listaplantacoes.text = "${binding.listaplantacoes.text}> ${plantacao.nome}\n"
        }
    }
}
