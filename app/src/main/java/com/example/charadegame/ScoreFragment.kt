package com.example.charadegame

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.charadegame.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_score,container,false)

        arguments?.let {
            binding.displayScore = ScoreFragmentArgs.fromBundle(it).finalScore
        }

        binding.shareScore.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.setType("text/plain").putExtra(Intent.EXTRA_TEXT,"I completed the Charades-game with a score of ${binding.displayScore}")
            startActivity(intent)
        }

        binding.playAgain.setOnClickListener {
            it.findNavController().navigate(R.id.action_scoreFragment_to_gameFragment)
        }

        return binding.root
    }

}