package com.example.mobilliumtask3.birincigorev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mobilliumtask3.R
import com.example.mobilliumtask3.databinding.FragmentGorevBirBinding

class GorevBirFragment : Fragment() {

    private lateinit var binding : FragmentGorevBirBinding
    var count = 0
    val viewModel: GorevBirViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gorev_bir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGorevBirBinding.bind(view)

        binding.switcher.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                observeLiveData()
                binding.increaseCounterButton.setOnClickListener {
                    viewModel.getCounter()
                }
            } else {
                binding.countTv.text = "Count : ${count.toString()}"
                binding.increaseCounterButton.setOnClickListener {
                    count++
                    binding.countTv.text = count.toString()
                }
            }
        }
    }

    private fun observeLiveData() {
        viewModel.countLiveData.observe(viewLifecycleOwner) {
            binding.countTv.text = "View model count : ${it.toString()}"
        }
    }
}