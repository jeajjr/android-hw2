package com.almas.hw2.almasapp2;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesDataFragment extends Fragment {
    static final String TAG = "MoviesDataFragment";

    private List<Map<String, ?>> movies;
    private int index;

    private Map<String, Integer> covers;

    public MoviesDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");

        View inputFragmentView = inflater.inflate(R.layout.fragment_movies_data, container, false);

        Log.d(TAG, "onCreate");

        covers = new HashMap<String, Integer>();
        MovieData mv = new MovieData();
        movies = mv.getMoviesList();
        index = 0;

        setUpCovers();

        Button nextButton = (Button) inputFragmentView.findViewById(R.id.buttonMoviesNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "nextButton");

                index++;
                if (index == movies.size())
                    index = 0;
                updateMovieData(true, null);
            }
        });

        Button previousButton = (Button) inputFragmentView.findViewById(R.id.buttonMoviesPrevious);
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "previousButton");

                index--;
                if (index < 0)
                    index = movies.size() - 1;

                updateMovieData(true, null);
            }
        });

        updateMovieData(false, inputFragmentView);

        // Inflate the layout for this fragment
        return inputFragmentView;
    }

    private void updateMovieData (boolean useGetView, View view) {
        TextView title;
        TextView year;
        TextView length;
        TextView stars;
        ImageView cover;
        RatingBar rating;
        TextView description;

        if (useGetView) {
            title = (TextView) getView().findViewById(R.id.textViewMovieTitle);
            year = (TextView) getView().findViewById(R.id.textViewMovieYear);
            length = (TextView) getView().findViewById(R.id.textViewMovieLenght);
            stars = (TextView) getView().findViewById(R.id.textViewMovieStars);
            cover = (ImageView) getView().findViewById(R.id.imageViewMovieCover);
            rating = (RatingBar) getView().findViewById(R.id.ratingBarMovieRating);
            description = (TextView) getView().findViewById(R.id.textViewMovieDescription);
        }
        else {
            title = (TextView) view.findViewById(R.id.textViewMovieTitle);
            year = (TextView) view.findViewById(R.id.textViewMovieYear);
            length = (TextView) view.findViewById(R.id.textViewMovieLenght);
            stars = (TextView) view.findViewById(R.id.textViewMovieStars);
            cover = (ImageView) view.findViewById(R.id.imageViewMovieCover);
            rating = (RatingBar) view.findViewById(R.id.ratingBarMovieRating);
            description = (TextView) view.findViewById(R.id.textViewMovieDescription);
        }


        title.setText(movies.get(index).get("name").toString());
        year.setText(movies.get(index).get("year").toString());
        length.setText(movies.get(index).get("length").toString());
        stars.setText(getResources().getText(R.string.movies_stars) + " " + movies.get(index).get("stars").toString());
        cover.setImageResource(covers.get(movies.get(index).get("name").toString()));
        rating.setRating( (int) Double.parseDouble(movies.get(index).get("rating").toString()) + 1 );
        Log.d(TAG, movies.get(index).get("rating").toString());
        description.setText(movies.get(index).get("description").toString());
    }

    public void setUpCovers () {
        covers.put("Avatar", R.drawable.avatar);
        covers.put("Titanic", R.drawable.titanic);
        covers.put("The Avengers", R.drawable.avengers);
        covers.put("The Dark Knight", R.drawable.dark_knight);
        covers.put("Star Wars I", R.drawable.star_wars1);
        covers.put("Star Wars IV ", R.drawable.star_wars4);
        covers.put("The Dark Knight Rises", R.drawable.dark_knight_rises);
        covers.put("Shrek 2", R.drawable.shrek2);
        covers.put("E.T. the Extra-Terrestrial", R.drawable.et);
        covers.put("The Hunger Games: Catching Fire", R.drawable.hunger_games);
        covers.put("Pirates of the Caribbean: Dead Man's Chest", R.drawable.pirates);
        covers.put("The Lion King", R.drawable.lion);
        covers.put("Toy Story 3", R.drawable.toy3);
        covers.put("Iron Man 3", R.drawable.ironman3);
        covers.put("The Hunger Games", R.drawable.hunger_games1);
        covers.put("Spider-Man", R.drawable.spiderman);
        covers.put("Jurassic Park", R.drawable.jurassicpark);
        covers.put("Transformers: Revenge of the Fallen", R.drawable.transformers);
        covers.put("Frozen", R.drawable.frozen);
        covers.put("Harry Potter and the Deathly Hallows: Part 2", R.drawable.harry2);
        covers.put("Finding Nemo", R.drawable.nemo);
        covers.put("Star Wars III", R.drawable.star_wars3);
        covers.put("The Lord of the Rings: The Return of the King", R.drawable.rings);
        covers.put("Spider-Man 2", R.drawable.spiderman2);
        covers.put("Despicable Me 2", R.drawable.despicable2);
        covers.put("Transformers: Dark of the Moon", R.drawable.transformers2);
        covers.put("The Lord of the Rings: The Two Towers", R.drawable.rings2);
        covers.put("Spider-Man 3", R.drawable.spiderman3);
        covers.put("Alice in Wonderland", R.drawable.alice);
        covers.put("Forrest Gump", R.drawable.forrest_gump);
    }
}
