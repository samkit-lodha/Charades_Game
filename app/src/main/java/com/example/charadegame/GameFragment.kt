package com.example.charadegame

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.charadegame.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding : FragmentGameBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game,container,false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.skipTV.setOnClickListener{
            viewModel.onSkip()
            updateWordText()
            updateScoreText()
        }

        binding.gotItButton.setOnClickListener {
            viewModel.onCorrect()
            updateWordText()
            updateScoreText()
        }

        binding.exitTV.setOnClickListener {

            Toast.makeText(inflater.context,"Game is finishing",Toast.LENGTH_SHORT).show()
            val action = GameFragmentDirections.actionGameFragmentToScoreFragment()
            action.finalScore = viewModel.score
            NavHostFragment.findNavController(this).navigate(action)
        }

        updateScoreText()
        updateWordText()

        return binding.root
    }

    private fun updateScoreText(){
        binding.score.text = viewModel.score.toString()
    }

    private fun updateWordText(){
        binding.word.text = viewModel.word
    }
}