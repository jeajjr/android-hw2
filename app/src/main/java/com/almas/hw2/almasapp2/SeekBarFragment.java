package com.almas.hw2.almasapp2;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeekBarFragment extends Fragment {
    static final String TAG = "SeekBarFragment";

    private ImageView image;
    private SeekBar seekBar;

    private double imageDelta = 500.0f;
    private double imageMin = 100.0f;

    public SeekBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inputFragmentView =  inflater.inflate(R.layout.fragment_seek_bar, container, false);

        image = (ImageView) inputFragmentView.findViewById(R.id.imageViewSeekBar);
        image.setClickable(true);
        image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                image.getLayoutParams().height = (int) (imageDelta /2);
                image.getLayoutParams().width = (int) (imageDelta /2);
                image.requestLayout();

                seekBar.setProgress(50);

                return true;
            }
        });
        image.getLayoutParams().height = (int) (imageMin + imageDelta/2);
        image.getLayoutParams().width = (int) (imageMin + imageDelta/2);

        image.requestLayout();

        seekBar = (SeekBar) inputFragmentView.findViewById(R.id.seekBar);
        seekBar.setProgress(50);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                double dProg = (double) progress;

                image.getLayoutParams().height = (int) (imageMin + imageDelta/(100.0f/dProg));
                image.getLayoutParams().width = (int) (imageMin + imageDelta/(100.0f/dProg));
                image.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return inputFragmentView;
    }

}
