package com.example.memorygame.game1

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.memorygame.GameCard
import com.example.memorygame.R
import kotlin.math.log

private const val TAG = "GP1ViewModel"

class GP1ViewModel() : ViewModel() {

    val gameCardsLiveData: MutableLiveData<List<GameCard>> = MutableLiveData()


    var gameCards: MutableList<GameCard> = ArrayList()

    private var indexOfSelectedPiece: Int? = null


    val images = mutableListOf(
        R.drawable.memorybatcardfront,
        R.drawable.memorycatcardfront,
        R.drawable.memorycowcardfront,
        R.drawable.memorydragonfront,
        R.drawable.memorygarbagemancardfront,
        R.drawable.memoryghostdogcardfront,
        R.drawable.memorybatcardfront,
        R.drawable.memorycatcardfront,
        R.drawable.memorycowcardfront,
        R.drawable.memorydragonfront,
        R.drawable.memorygarbagemancardfront,
        R.drawable.memoryghostdogcardfront
    )


    init {
        for (image in images) {
            gameCards.add(GameCard(image, imageID = image))
        }

        gameCards.shuffle()
        gameCardsLiveData.value = gameCards
        Log.d(TAG, "ViewModel Created:")

    }


    fun updatingModels(position: Int) {
        if (gameCards[position].isFacedUp) return
        gameCardsLiveData.value = gameCards

        if (indexOfSelectedPiece == null) {
            restoreGameCards()
            indexOfSelectedPiece = position

        } else {
            checkingForMatch(indexOfSelectedPiece!!, position)
            indexOfSelectedPiece = null
        }
        gameCards[position].isFacedUp = !gameCards[position].isFacedUp
        gameCardsLiveData.value = gameCards
    }

    private fun restoreGameCards() {
        for (gameCard in gameCards) {
            if (!gameCard.isMatched) {
                gameCard.isFacedUp = false

            }
        }
        gameCardsLiveData.value = gameCards
    }

    private fun checkingForMatch(position1: Int, position2: Int) {
        if (gameCards[position1].id == gameCards[position2].id) {
            gameCards[position1].isMatched = true
            gameCards[position2].isMatched = true
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                gameCards[position1].isMatched = false
                gameCards[position2].isMatched = false
            }, 1000)
            Log.d(TAG, "checkingForMatch: the lag is called")
        }
        gameCardsLiveData.value = gameCards
    }


}


