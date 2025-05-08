package com.example.cocktailmobileapp

import androidx.annotation.DrawableRes

data class Cocktail(
    val name: String,
    @DrawableRes val imageResId: Int
)

val cocktailList = listOf(
    Cocktail("Mojito", R.drawable.mojito),
    Cocktail("Aperol Spritz", R.drawable.aperol_spritz),
    Cocktail("Campari Orange", R.drawable.campari_orange),
    Cocktail("Martini", R.drawable.martini),
    Cocktail("Espresso Martini", R.drawable.espresso_martini),
    Cocktail("Malibu", R.drawable.malibu),
    Cocktail("Moscow Mule", R.drawable.moscow_mule),
    Cocktail("Mimosa", R.drawable.mimosa),
    Cocktail("Sour Apple Vodka", R.drawable.sour_apple_vodka),
    Cocktail("Old Fashioned", R.drawable.old_fashioned),
    Cocktail("Pina Colada", R.drawable.pina_colada),
    Cocktail("Gin and Tonic", R.drawable.gin_and_tonic),
    Cocktail("Sex on the Beach", R.drawable.sex_on_the_beach),
    Cocktail("Cosmopolitan", R.drawable.cosmopolitan),
    Cocktail("Blue Kamikaze", R.drawable.blue_kamikaze),
    Cocktail("Whiskey Sour", R.drawable.whiskey_sour),
    Cocktail("Daiquiri", R.drawable.daiquiri),
    Cocktail("Margarita", R.drawable.margarita)
)
