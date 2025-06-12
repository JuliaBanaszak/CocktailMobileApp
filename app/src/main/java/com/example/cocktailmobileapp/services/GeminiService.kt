package com.example.cocktailmobileapp.services

import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GeminiService {
    private val generativeModel = GenerativeModel(
        modelName = "gemini-pro",
        apiKey = "YOUR_API_KEY"
    )

    suspend fun generateCocktailRecipe(ingredients: String): String {
        return withContext(Dispatchers.IO) {
            try {
                val prompt = """
                    You are an expert mixologist. Create a cocktail recipe using these ingredients: $ingredients.
                    Provide the response in this exact JSON format:
                    {
                        "name": "Cocktail Name",
                        "ingredients": ["ingredient1", "ingredient2"],
                        "instructions": "Step 1. Do this...",
                        "glassware": "Type of glass",
                        "garnish": "Garnish suggestion"
                    }
                    If the ingredients can't make a proper cocktail, suggest what's missing.
                """.trimIndent()

                generativeModel.generateContent(prompt).text
                    ?: "Sorry, couldn't generate a recipe. Try different ingredients."
            } catch (e: Exception) {
                "Error: ${e.message}"
            }
        }
    }
}