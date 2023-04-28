package com.example.mobilliumtask3.ikincigorev

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mobilliumtask3.R
import com.example.mobilliumtask3.databinding.FragmentGorevIkiBinding
import com.example.mobilliumtask3.util.StateGuess

class GorevIkiFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentGorevIkiBinding
    private val viewModel: GorevIkiViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gorev_iki, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGorevIkiBinding.bind(view)

        Log.d("Message", viewModel.randomNumber.toString())
        observeLiveData()
        binding.guessButton.setOnClickListener {
            viewModel.isCorrectGuess()
        }

        binding.apply {
            zeroButton.setOnClickListener(this@GorevIkiFragment)
            oneButton.setOnClickListener(this@GorevIkiFragment)
            twoButton.setOnClickListener(this@GorevIkiFragment)
            threeButton.setOnClickListener(this@GorevIkiFragment)
            fourButton.setOnClickListener(this@GorevIkiFragment)
            fiveButton.setOnClickListener(this@GorevIkiFragment)
            sixButton.setOnClickListener(this@GorevIkiFragment)
            sevenButton.setOnClickListener(this@GorevIkiFragment)
            eightButton.setOnClickListener(this@GorevIkiFragment)
            nineButton.setOnClickListener(this@GorevIkiFragment)
        }

        binding.randomNumberTv.setOnClickListener {
            findNavController().navigate(R.id.action_gorevIkiFragment_to_detailFragment)
        }

        binding.clearButton.setOnClickListener {
            binding.infoTv.setText(R.string.welcome_game)
            viewModel.generateRandomNumber()
            viewModel.generateRandomCharacter()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.zeroButton -> setGuessNumber(0)
            R.id.oneButton -> setGuessNumber(1)
            R.id.twoButton -> setGuessNumber(2)
            R.id.threeButton -> setGuessNumber(3)
            R.id.fourButton -> setGuessNumber(4)
            R.id.fiveButton -> setGuessNumber(5)
            R.id.sixButton -> setGuessNumber(6)
            R.id.sevenButton -> setGuessNumber(7)
            R.id.eightButton -> setGuessNumber(8)
            R.id.nineButton -> setGuessNumber(9)
        }
    }

    private fun setGuessNumber(number: Int) {
        viewModel.selectNumber = number
        binding.infoTv.text = viewModel.selectNumber.toString()
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            binding.randomNumberTv.text = it.toString()
        }

        viewModel.selectNumberLiveData.observe(viewLifecycleOwner) {
            it?.let {
                when (it) {
                    StateGuess.WIN -> binding.infoTv.setText(R.string.you_won)
                    StateGuess.AGAIN -> binding.infoTv.setText(R.string.try_again)
                }
            }
        }
    }
}
