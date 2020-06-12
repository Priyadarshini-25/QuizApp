package com.example.quizzapp;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuizFragment extends Fragment {

    private static final String TAG ="QUIZ_FRAGMENT_LOG" ;
    private FirebaseFirestore firebaseFirestore;
    private String quizId;

    //UI Elements
    private TextView quizTitle;




    public QuizFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        quizTitle=this.getView().findViewById(R.id.quiz_title);

        //Get Quiz Id
        quizId=QuizFragmentArgs.fromBundle(getArguments()).getQuizId();

        //Get all questions from the quiz
        firebaseFirestore.collection("QuizList").document(quizId)
                .collection("Questions")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    Log.d(TAG,"Questions List : "+task.getResult().toObjects(List.class));

                }else {
                    //Error Getting Questions
                    quizTitle.setText("Error Loading Data.");
                }
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Initialize
        firebaseFirestore=firebaseFirestore.getInstance();


    }
}
