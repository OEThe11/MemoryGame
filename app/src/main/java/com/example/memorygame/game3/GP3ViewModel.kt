package com.example.memorygame.game3

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.memorygame.GameCard
import com.example.memorygame.R.drawable.*


private const val TAG = "GP3ViewModel"

class GP3ViewModel : ViewModel() {

    val gameCardsLiveData3: MutableLiveData<List<GameCard>> = MutableLiveData()

    var gameCards: MutableList<GameCard> = ArrayList()
    private var indexOfSelectedPiece: Int? = null

    val images = mutableListOf(
        memoryspidercardfront,
        memorypigcardfront,
        memoryhorsecardfront,
        memoryhencardfront,
        memoryghostdogcardfront,
        memorygarbagemancardfront,
        memorydragonfront,
        memorycowcardfront,
        memoryspidercardfront,
        memorypigcardfront,
        memoryhorsecardfront,
        memoryhencardfront,
        memoryghostdogcardfront,
        memorygarbagemancardfront,
        memorydragonfront,
        memorycowcardfront
    )

    init {
        for (image in images) {
            gameCards.add(GameCard(image, imageID = image))
        }

        gameCards.shuffle()
        gameCardsLiveData3.value = gameCards
        Log.d(TAG, "ViewModel Created")
    }


    fun updatingModels(position: Int) {
        if (gameCards[position].isFacedUp) return
        gameCardsLiveData3.value = gameCards

        if (indexOfSelectedPiece == null) {
            restoreGameCards()
            indexOfSelectedPiece = position

        } else {
            checkingForMatch(indexOfSelectedPiece!!, position)
            indexOfSelectedPiece = null
        }
        gameCards[position].isFacedUp = !gameCards[position].isFacedUp
        gameCardsLiveData3.value = gameCards
    }

    private fun restoreGameCards() {
        for (gameCard in gameCards) {
            if (!gameCard.isMatched) {
                gameCard.isFacedUp = false

            }
        }
        gameCardsLiveData3.value = gameCards
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
        gameCardsLiveData3.value = gameCards
    }


}