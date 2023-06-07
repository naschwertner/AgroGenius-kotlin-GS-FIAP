package com.example.gs_agrogenius.ui.previsao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gs_agrogenius.R
import com.example.gs_agrogenius.databinding.FragmentPrevisaoBinding

import android.widget.RadioButton
import android.widget.Button
import androidx.navigation.fragment.findNavController

class PrevisaoFragment : Fragment() {

    private var _binding: FragmentPrevisaoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrevisaoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val confirmarButton: Button = binding.voltarButton
        val opcao1RadioButton: RadioButton = binding.opcao1RadioButton
        val opcao2RadioButton: RadioButton = binding.opcao2RadioButton

        confirmarButton.setOnClickListener{
            if (opcao1RadioButton.isChecked) {
                findNavController().navigate(R.id.action_nav_previsao_to_previsaoResultado1Fragment)
            } else if (opcao2RadioButton.isChecked) {
                findNavController().navigate(R.id.action_nav_previsao_to_previsaoResultado2Fragment)
            } else {
                // falta tratar o caso em que nenhum RadioButton está selecionado
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}