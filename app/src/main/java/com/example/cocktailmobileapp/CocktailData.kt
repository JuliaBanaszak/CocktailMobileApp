package com.example.cocktailmobileapp

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class Cocktail(
    val name: String,
    @DrawableRes val imageResId: Int
)

data class CocktailDetails(
    val ingredients: String,
    val preparation: String
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

    val cocktailDetails = mapOf(
        "Mojito" to CocktailDetails(
            ingredients = "rum, mięta, cukier, limonka, woda gazowana",
            preparation = "1. Zgnieść miętę w szklance. 2. Dodać cukier, rum i limonkę. 3. Wlać wodę gazowaną."
        ),
        "Aperol Spritz" to CocktailDetails(
            ingredients = "Aperol, prosecco, woda gazowana, pomarańcza, lód",
            preparation = "1. Napełnić kieliszek lodem. 2. Wlać Aperol i prosecco. 3. Dodać wodę gazowaną i plasterek pomarańczy."
        ),
        "Campari Orange" to CocktailDetails(
            ingredients = "Campari, sok pomarańczowy, lód",
            preparation = "1. Wypełnić szklankę lodem. 2. Wlać Campari i sok pomarańczowy. 3. Delikatnie wymieszać."
        ),
        "Martini" to CocktailDetails(
            ingredients = "gin, wermut, oliwka",
            preparation = "1. Wlać gin i wermut do szklanki z lodem. 2. Mieszać przez chwilę. 3. Przelać do kieliszka i dodać oliwkę."
        ),
        "Espresso Martini" to CocktailDetails(
            ingredients = "wódka, likier kawowy, espresso, syrop cukrowy",
            preparation = "1. Wstrząsnąć wszystkie składniki w shakerze z lodem. 2. Przelać do schłodzonego kieliszka. 3. Udekorować ziarnami kawy."
        ),
        "Jagerbomb" to CocktailDetails(
            ingredients = "Jägermeister, napój energetyczny",
            preparation = "1. Wlać napój energetyczny do szklanki. 2. Wrzucić kieliszek z Jägermeisterem do środka i wypić."
        ),
        "Malibu" to CocktailDetails(
            ingredients = "Malibu, sok ananasowy, lód",
            preparation = "1. Wypełnić szklankę lodem. 2. Wlać Malibu i sok ananasowy. 3. Delikatnie wymieszać."
        ),
        "Moscow Mule" to CocktailDetails(
            ingredients = "wódka, piwo imbirowe, sok z limonki, lód",
            preparation = "1. Wypełnić kubek lodem. 2. Wlać wódkę, piwo imbirowe i sok z limonki. 3. Delikatnie wymieszać."
        ),
        "Mimosa" to CocktailDetails(
            ingredients = "szampan, sok pomarańczowy",
            preparation = "1. Wlać sok pomarańczowy do kieliszka. 2. Delikatnie dolać szampana."
        ),
        "Sour Apple Vodka" to CocktailDetails(
            ingredients = "wódka jabłkowa, likier kwaśne jabłko, sok jabłkowy, lód",
            preparation = "1. Wstrząsnąć wszystkie składniki w shakerze z lodem. 2. Przelać do kieliszka."
        ),
        "Pina Colada" to CocktailDetails(
            ingredients = "rum, mleczko kokosowe, sok ananasowy, lód",
            preparation = "1. Wymieszać składniki w blenderze. 2. Przelać do szklanki. 3. Udekorować plasterkiem ananasa."
        ),
        "Old Fashioned" to CocktailDetails(
            ingredients = "whiskey, cukier, angostura, woda, skórka pomarańczy",
            preparation = "1. Rozpuścić cukier w wodzie z angosturą. 2. Dodać lód i whiskey. 3. Wymieszać i udekorować skórką pomarańczy."
        ),
        "Gin and Tonic" to CocktailDetails(
            ingredients = "gin, tonik, limonka, lód",
            preparation = "1. Wypełnić szklankę lodem. 2. Wlać gin i tonik. 3. Dodać plasterek limonki."
        ),
        "Sex on the Beach" to CocktailDetails(
            ingredients = "wódka, likier brzoskwiniowy, sok pomarańczowy, sok żurawinowy, lód",
            preparation = "1. Wypełnić szklankę lodem. 2. Wlać składniki i delikatnie wymieszać."
        ),
        "Cosmopolitan" to CocktailDetails(
            ingredients = "wódka cytrynowa, likier pomarańczowy, sok żurawinowy, sok z limonki",
            preparation = "1. Wstrząsnąć wszystkie składniki w shakerze z lodem. 2. Przelać do kieliszka."
        ),
        "Blue Kamikaze" to CocktailDetails(
            ingredients = "wódka, likier blue curacao, sok z limonki",
            preparation = "1. Wstrząsnąć składniki w shakerze. 2. Przelać do kieliszka."
        ),
        "Whiskey Sour" to CocktailDetails(
            ingredients = "whiskey, sok z cytryny, syrop cukrowy, białko jajka",
            preparation = "1. Wstrząsnąć wszystkie składniki w shakerze na sucho. 2. Dodać lód i ponownie wstrząsnąć. 3. Przelać do szklanki."
        ),
        "Daiquiri" to CocktailDetails(
            ingredients = "rum, sok z limonki, syrop cukrowy",
            preparation = "1. Wstrząsnąć składniki w shakerze z lodem. 2. Przelać do kieliszka."
        ),
        "Margarita" to CocktailDetails(
            ingredients = "tequila, likier pomarańczowy, sok z limonki",
            preparation = "1. Wymieszać tequilę, likier pomarańczowy i sok z limonki w shakerze. 2. Przelać do szklanki."
        )
    )