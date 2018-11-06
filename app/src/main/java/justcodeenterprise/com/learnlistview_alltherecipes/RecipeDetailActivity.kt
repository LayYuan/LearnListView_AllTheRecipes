package justcodeenterprise.com.learnlistview_alltherecipes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    //companion object method to return an Intent for starting the detail activity, and sets up title and url extras in the Intent.
    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_URL = "url"

        fun newIntent(context: Context, recipe: Recipe): Intent {
            val detailIntent = Intent(context, RecipeDetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, recipe.title)
            detailIntent.putExtra(EXTRA_URL, recipe.instructionUrl)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        // 1 You retrieve the recipe data from the Intent passed from MainActivity by using the extras property.
        val title = intent.extras.getString(EXTRA_TITLE)
        val url = intent.extras.getString(EXTRA_URL)

         // 2 You set the title on the action bar of this activity to the recipe title.
        setTitle(title)

        // 3 You initialize webView to the web view defined in the XML layout.
        webView = findViewById(R.id.detail_web_view)

        // 4 You load the recipe web page by calling loadUrl() with the corresponding recipe’s URL on the web view object.
        webView.loadUrl(url)
    }
}
