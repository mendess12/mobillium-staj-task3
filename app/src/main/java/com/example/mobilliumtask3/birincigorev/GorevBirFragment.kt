package com.example.mobilliumtask3.birincigorev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.mobilliumtask3.R
import com.example.mobilliumtask3.databinding.FragmentGorevBirBinding

class GorevBirFragment : Fragment() {
    private lateinit var binding : FragmentGorevBirBinding
    var count = 0
    var viewModelCount = 0
    var gorevBirVM = GorevBirViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gorev_bir, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGorevBirBinding.bind(view)
        gorevBirVM = ViewModelProviders.of(requireActivity()).get(GorevBirViewModel::class.java)

        binding.switcher.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked){
                observeLiveData()
                binding.increaseCounterButton.setOnClickListener {
                    gorevBirVM.getCounter()
                    viewModelCount = gorevBirVM.count
                    observeLiveData()
                }
            }else{
                binding.countTv.text = "Count : ${count.toString()}"
                binding.increaseCounterButton.setOnClickListener {
                    count++
                    binding.countTv.text = count.toString()
                }
            }
        }
    }

    fun observeLiveData (){
        gorevBirVM.countLiveData.observe(viewLifecycleOwner){
            binding.countTv.text = "View model count : ${it.toString()}"
        }
    }
}