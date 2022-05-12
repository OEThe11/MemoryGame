package com.example.memorygame.lobby

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.memorygame.R
import com.example.memorygame.databinding.LobbyFragmentBinding

class LobbyFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: LobbyFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.lobby_fragment,
            container, false
        )

        binding.game1Button.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LobbyFragmentDirections.actionLobbyFragmentToGamePlay1Fragment())
        }

        binding.game2Button.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LobbyFragmentDirections.actionLobbyFragmentToGamePlay2Fragment())
        }

        binding.game3Button.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LobbyFragmentDirections.actionLobbyFragmentToGamePlay3Fragment())
        }

        binding.game4Button.setOnClickListener { v: View ->
            v.findNavController()
                .navigate(LobbyFragmentDirections.actionLobbyFragmentToGamePlay4Fragment())
        }


        return binding.root
    }
}