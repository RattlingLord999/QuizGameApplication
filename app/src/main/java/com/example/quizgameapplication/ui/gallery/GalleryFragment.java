package com.example.quizgameapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamingapp.DBHelper;
import com.example.gamingapp.HistorStringModel;
import com.example.gamingapp.MyAdapter;
import com.example.gamingapp.R;
import com.example.gamingapp.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    DBHelper dbHelper;
    //HistorStringModel historStringModel;
    TextView right_answers;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gallery, container, false);
        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycleView);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        dbHelper=new DBHelper(rootView.getContext());
        ArrayList<HistorStringModel> historStringModels=dbHelper.GetHistory();

        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(historStringModels);
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view,@NonNull Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);

       /*
        RecyclerView recyclerView=view.findViewById(R.id.recycleView);

        Log.i(TAG, historStringModels.get(0).getYours());

        MyAdapter.java myAdapter=new MyAdapter.java(view.getContext(),historStringModels);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        */

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}