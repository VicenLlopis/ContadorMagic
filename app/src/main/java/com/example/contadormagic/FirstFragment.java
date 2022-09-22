package com.example.contadormagic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.contadormagic.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    int lp1= 0;
    int lp2= 0;
    int pp1= 0;
    int pp2= 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        reset();
        if(savedInstanceState!=null){
            lp1= savedInstanceState.getInt("lp1");
            lp2= savedInstanceState.getInt("lp2");
            pp1= savedInstanceState.getInt("pp1");
            pp2= savedInstanceState.getInt("pp2");

        }
        updateCounters();

        return binding.getRoot();

    }

    private void updateCounters() {
        binding.TXTLP1.setText(lp1+"/"+pp1);

        binding.TXTLP2.setText(lp2+"/"+pp2);
    }

    private void reset() {
         lp1= 20;
         lp2= 20;
         pp1= 0;
         pp2= 0;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnAP1.setOnClickListener(btn -> {
            lp1++;
            lp2--;
                }
        );
        binding.btnAP2.setOnClickListener(bnt ->{
            lp2++;
            lp1--;
        });

        binding.btnLlP1.setOnClickListener(btn -> {
                lp1--;
                }
        );

        binding.BtnPlP1.setOnClickListener(btn ->{
            pp1--;
        });

        binding.btnLpP1.setOnClickListener(btn ->{
            lp1++;
        });

        binding.btnPpP1.setOnClickListener(btn ->{
            pp1++;
        });

        binding.btnLpP2.setOnClickListener(btn ->{
            lp2++;
        });

        binding.btnLlP2.setOnClickListener(btn ->{
            lp2--;
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}