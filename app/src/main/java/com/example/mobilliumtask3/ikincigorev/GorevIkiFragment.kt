package com.example.mobilliumtask3.ikincigorev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.mobilliumtask3.R
import com.example.mobilliumtask3.databinding.FragmentGorevIkiBinding
import kotlin.random.Random

class GorevIkiFragment : Fragment() {
    private lateinit var binding : FragmentGorevIkiBinding
    var gorevIkiVM = GorevIkiViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gorev_iki, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGorevIkiBinding.bind(view)
        gorevIkiVM = ViewModelProviders.of(requireActivity()).get(GorevIkiViewModel::class.java)


    }
}