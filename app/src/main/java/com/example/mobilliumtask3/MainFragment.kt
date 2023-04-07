package com.example.mobilliumtask3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mobilliumtask3.databinding.FragmentMainFragmentBinding

class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainFragmentBinding.bind(view)

        binding.gorev1Button.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToGorevBirFragment()
            findNavController().navigate(action)
        }

        binding.gorev2Button.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToGorevIkiFragment()
            findNavController().navigate(action)
        }

        binding.gorev2Button.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToGorevIkiFragment()
            findNavController().navigate(action)
        }
    }
}