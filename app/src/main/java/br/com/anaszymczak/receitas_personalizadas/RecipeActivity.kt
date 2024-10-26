package br.com.anaszymczak.receitas_personalizadas

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.anaszymczak.receitas_personalizadas.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedIngredients = intent.getStringArrayListExtra("selectedIngredients")
        displayRecipe(selectedIngredients ?: arrayListOf())
    }

    private fun displayRecipe(ingredients: ArrayList<String>) {
        binding.ingredientsList.text = ingredients.joinToString(", ")
        binding.recipeSteps.text = "Passo a passo da receita..." // Personalize conforme necessário

        binding.buttonShare.setOnClickListener { shareRecipe() }
    }

    private fun shareRecipe() {
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Minha receita: ${binding.ingredientsList.text}")
        }
        startActivity(Intent.createChooser(shareIntent, getString(R.string.share_recipe)))
    }
}