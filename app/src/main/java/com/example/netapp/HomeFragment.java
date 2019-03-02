package com.example.netapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.netapp.chapters_list.ChapterListActivity;
import com.example.netapp.quiz.QuizModulesActivity;


public class HomeFragment extends Fragment {

    private ViewFlipper viewFlipper;

    private CardView chaptersCard;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        int images[] = {R.drawable.slide1, R.drawable.slide2, R.drawable.slide3};
        viewFlipper = (ViewFlipper) v.findViewById(R.id.image_flipper);

        for (int image : images) {
            flipperImages(image);
        }

        chaptersCard = (CardView) v.findViewById(R.id.chapters_card);
        chaptersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startChapters(getActivity());
            }
        });

        return v;
    }

    private void flipperImages(int image) {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getActivity(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(), android.R.anim.slide_out_right);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_bar, menu);
        super.onCreateOptionsMenu(menu, inflater);

    }

    private static void startChapters(Context context) {
        Intent starter = new Intent(context, ChapterListActivity.class);
        context.startActivity(starter);
    }

    public static void startQuiz(Context context) {
        Intent starter = new Intent(context, QuizModulesActivity.class);
        //starter.putExtra();
        context.startActivity(starter);
    }
}

/*

#37474F
 */