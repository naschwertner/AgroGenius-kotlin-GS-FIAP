package com.example.gs_agrogenius.ui.diagnostico

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.gs_agrogenius.databinding.FragmentDiagnosticoBinding
import android.widget.Button
import com.example.gs_agrogenius.R

class DiagnosticoFragment : Fragment() {

    private var _binding: FragmentDiagnosticoBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiagnosticoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = binding.button
        button.setOnClickListener{
            findNavController().navigate(R.id.action_nav_diagnostico_to_diagnosticoResultadoFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
