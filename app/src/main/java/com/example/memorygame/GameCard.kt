package com.example.memorygame

data class GameCard(val id: Int,
                    var isFacedUp: Boolean = false,
                    var isMatched: Boolean = false,
                    var imageID: Int)
