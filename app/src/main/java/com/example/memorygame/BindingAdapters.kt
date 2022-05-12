package com.example.memorygame

import android.widget.ImageView
import androidx.databinding.BindingAdapter


@BindingAdapter("cardImage")
fun setCardImage(view: ImageView, gameCard: GameCard) {
    if (gameCard.isFacedUp) {
        view.setImageResource(gameCard.imageID)
    } else {
        view.setImageResource(R.drawable.allcardbacks)
    }
}