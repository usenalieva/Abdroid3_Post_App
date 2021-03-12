package com.makhabatusen.abdroid3_l3_hw.ui.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<VB extends ViewBinding> extends Fragment {

    protected VB ui;


    protected abstract VB bind();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ui = bind();
        return ui.getRoot();
    }

    protected void navigateTo(NavDirections id) {
        NavController navController = Navigation.findNavController(requireActivity(), com.makhabatusen.abdroid3_l3_hw.R.id.nav_host_fragment);
        navController.navigate(id);
    }

}

