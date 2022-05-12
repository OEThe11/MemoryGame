package com.example.memorygame.game4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.memorygame.GameCard
import com.example.memorygame.R
import com.example.memorygame.databinding.Gameplay4FragmentBinding


class GamePlay4Fragment : Fragment() {

    private lateinit var viewModel: GP4ViewModel

    private lateinit var pieces: List<ImageView>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: Gameplay4FragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.gameplay4_fragment,
            container, false
        )

        viewModel = ViewModelProvider(this).get(GP4ViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        binding.backButtonView.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(GamePlay4FragmentDirections.actionGamePlay4FragmentToLobbyFragment())
        }



        pieces = listOf(
            binding.card1back, binding.card2back, binding.card3back, binding.card4back,
            binding.card5back, binding.card6back, binding.card7back,
            binding.card8back, binding.card9back, binding.card10back, binding.card11back,
            binding.card12back, binding.card13back, binding.card14back, binding.card15back,
            binding.card16back, binding.card17back, binding.card18back, binding.card19back,
            binding.card20back
        )

        if (viewModel.gameCards.isEmpty()) {
            viewModel.gameCards = pieces.indices.map { index ->
                GameCard(viewModel.images[index], false, false, viewModel.images[index]).also {
                    GameCard(id, false, false, viewModel.images[index]).isFacedUp = true
                }
            }.toMutableList()
        }

        pieces.forEachIndexed { index, piece ->
            piece.setOnClickListener {

                viewModel.updatingModels(index)


            }
        }


        return binding.root
    }


}