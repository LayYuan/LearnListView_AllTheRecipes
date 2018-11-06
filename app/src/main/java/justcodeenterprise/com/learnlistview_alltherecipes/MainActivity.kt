package justcodeenterprise.com.learnlistview_alltherecipes

//1. How to construct and populate a ListView
//2. How to customize the layout
//3. How to style and beautify a ListView
//4. How to optimize a ListView’s performance


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    //1.1
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1.2
        listView = findViewById<ListView>(R.id.recipe_list_view)
        // 1.2.1 This loads a list of Recipe objects from a JSON asset in the app.
        val recipeList = Recipe.getRecipesFromFile("recipes.json", this)
        // 1.2.2 This creates an array of strings that’ll contain the text to be displayed in the ListView.
        val listItems = arrayOfNulls<String>(recipeList.size)
        //1.3
        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.title

        }
        // 1.4 This creates and sets a simple adapter for the ListView. The ArrayAdapter takes in the current context,
        // a layout file specifying what each row in the list should look like, and the data that will populate the list as arguments.
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter
    }
}
