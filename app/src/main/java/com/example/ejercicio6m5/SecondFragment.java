package com.example.ejercicio6m5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.ejercicio6m5.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private static final String URL ="url";
    private static final String DATO ="dato";
    private String Url;
    private String Dato;

    private FragmentSecondBinding binding;

    public SecondFragment(){

    }

    public static SecondFragment newInstance(String url, String dato){
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(URL, url);
        args.putString(DATO,dato);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState     ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        if (getArguments() != null) {
            Url = getArguments().getString(URL);
            Dato = getArguments().getString(DATO);
        }
        Glide.with(getContext()).load(Url).into(binding.imageView);
        binding.textviewSecond.setText(Dato);
        return view;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}