package justcodeenterprise.com.learnlistview_alltherecipes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

/**
 * Created by LayYuan on 2018-11-06.
 */

//defined a primary constructor for RecipeAdapter.
class RecipeAdapter(private val context: Context,
                    private val dataSource: ArrayList<Recipe>) : BaseAdapter() {

    //added the properties that will be associated with the adapter
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    //1 lets ListView know how many items to display, or in other words, it returns the size of your data source.
    override fun getCount(): Int {
        return dataSource.size
    }

    //2 returns an item to be placed in a given position from the data source, specifically, Recipe objects obtained from dataSource.
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3 defines a unique ID for each row in the list. For simplicity, you just use the position of the item as its ID.
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4 creates a view to be used as a row in the list. Here you define what information shows and where it sits within the ListView.
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Here link to xml file to adapter
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_recipe, parent, false)

        //This obtains references to each of the elements (or subviews) of the row view, specifically the title, subtitle,
        // detail and thumbnail.
        // Get title element
        val titleTextView = rowView.findViewById(R.id.recipe_list_title) as TextView

        // Get subtitle element
        val subtitleTextView = rowView.findViewById(R.id.recipe_list_subtitle) as TextView

        // Get detail element
        val detailTextView = rowView.findViewById(R.id.recipe_list_detail) as TextView

        // Get thumbnail element
        val thumbnailImageView = rowView.findViewById(R.id.recipe_list_thumbnail) as ImageView


        // 1. Getting the corresponding recipe for the current row.
        val recipe = getItem(position) as Recipe

        // 2 Updating the row view’s text views so they are displaying the recipe.
        titleTextView.text = recipe.title
        subtitleTextView.text = recipe.description
        detailTextView.text = recipe.label

        // 3 asynchronous image loading — it helps you download the thumbnail images on a separate thread instead of the main thread.
        Picasso.with(context).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView)

        return rowView
    }
}