package br.com.anaszymczak.receitas_personalizadas

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.anaszymczak.receitas_personalizadas.databinding.ActivityMainBinding
import java.util.Locale
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val selectedIngredients = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupIngredientButtons()
    }

    private fun setupIngredientButtons() {
        binding.buttonTomate.setOnClickListener {
            toggleIngredient("Tomate", binding.buttonTomate)
        }
        binding.buttonSal.setOnClickListener {
            toggleIngredient("Sal", binding.buttonTomate)
        }
        binding.buttonMaionese.setOnClickListener {
            toggleIngredient("Maionese", binding.buttonTomate)
        }
        binding.buttonPepino.setOnClickListener {
            toggleIngredient("Pepino", binding.buttonTomate)
        }
        binding.buttonCenoura.setOnClickListener {
            toggleIngredient("Cenoura", binding.buttonTomate)
        }
        binding.buttonFarinha.setOnClickListener {
            toggleIngredient("Farinha", binding.buttonTomate)
        }
        binding.buttonPalmito.setOnClickListener {
            toggleIngredient("Palmito", binding.buttonTomate)
        }
        binding.buttonAcucar.setOnClickListener {
            toggleIngredient("Acucar", binding.buttonTomate)
        }
        binding.buttonAlface.setOnClickListener {
            toggleIngredient("Alface", binding.buttonTomate)
        }
        binding.buttonCebola.setOnClickListener {
            toggleIngredient("Cebola", binding.buttonTomate)
        }
        // Repita para os outros botões
    }

    private fun toggleIngredient(ingredient: String, button: Button) {
        if (selectedIngredients.contains(ingredient)) {
            selectedIngredients.remove(ingredient)
            button.setBackgroundColor(Color.LTGRAY) // Deselecionar
        } else {
            if (selectedIngredients.size < 3) {
                selectedIngredients.add(ingredient)
                button.setBackgroundColor(Color.GREEN) // Selecionar
            }
        }
        binding.buttonNext.isEnabled = selectedIngredients.size == 3
    }

    fun goToRecipe(view: View) {
        val intent = Intent(this, RecipeActivity::class.java).apply {
            putStringArrayListExtra("selectedIngredients", ArrayList(selectedIngredients))
        }
        startActivity(intent)
    }
}
