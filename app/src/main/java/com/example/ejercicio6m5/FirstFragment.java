package com.example.ejercicio6m5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ejercicio6m5.databinding.FragmentFirstBinding;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment implements Adapter.OnItemClickListener {

    private FragmentFirstBinding binding;
    private RecyclerView recyclerView;
    private Adapter adapter;
    private List<Datos> dataList;
    private int indice;
    List<Datos> data = new ArrayList<>();
    public FirstFragment(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        if (dataList!= null){ dataList.clear();}
        dataList = getData();
        recyclerView= binding.RV;
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter= new Adapter(dataList);
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);

        return binding.getRoot();

    }

    private List<Datos>getData(){
            Datos item01 = new Datos("Zhuo Cheng you","https://unsplash.com/photos/UBvtBr_FmrY/download?force=true&w=640");
            data.add(item01);
            Datos item02 = new Datos("billow926","https://unsplash.com/photos/pNoP-qVwBFQ/download?force=true&w=640");
            data.add(item02);
            Datos item03 = new Datos("Philipp Deiß","https://unsplash.com/photos/LfJx0gqqiEc/download?force=true&w=640");
            data.add(item03);
            Datos item04 = new Datos("Huper by Joshua Earle","https://unsplash.com/photos/5lgPYsE_qe0/download?ixid=M3wxMjA3fDB8MXxhbGx8Mnx8fHx8fDJ8fDE2ODg1NDQ2MTJ8&force=true");
            data.add(item04);
            Datos item05 = new Datos("Melnychuk Nataliya","https://unsplash.com/photos/rnPGCe7LsQo/download?force=true&w=640");
            data.add(item05);
            Datos item06 = new Datos("Teagan Maddux","https://unsplash.com/photos/k2DbTXQ0yrQ/download?force=true&w=640");
            data.add(item06);
            Datos item07 = new Datos("Chen Liu","https://unsplash.com/photos/kZH8X0q4Nvo/download?force=true&w=640");
            data.add(item07);
            Datos item08 = new Datos("John Fornander","https://unsplash.com/photos/iNqJx-VOceI/download?force=true&w=640");
            data.add(item08);
            Datos item09 = new Datos("Parker Coffman","https://unsplash.com/photos/mNWrQ9O6KZw/download?force=true&w=640");
            data.add(item09);
            Datos item10 = new Datos("XPS","https://unsplash.com/photos/8pb7Hq539Zw/download?force=true&w=640");
            data.add(item10);
            Datos item11 = new Datos("Daniel J.Schwarz","https://unsplash.com/photos/l8BvDmt8Ac4/download?force=true&w=640");
            data.add(item11);
            Datos item12 = new Datos("Wesley Armstrong","https://unsplash.com/photos/07yuU32aLnA/download?ixid=M3wxMjA3fDB8MXxhbGx8fHx8fHx8Mnx8MTY4ODU0NDgxMnw&force=true&w=640");
            data.add(item12);
            return data;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onItemClick(int position) {
        indice= position;
        Datos choose= dataList.get(indice);
        Bundle bundle= new Bundle();
        bundle.putString("dato",choose.getdato());
        bundle.putString("url",choose.getUrl());
        NavController navController= Navigation.findNavController(getActivity(),R.id.fragmentContainerView);
        navController.navigate(R.id.action_FirstFragment_to_SecondFragment,bundle);
    }
}