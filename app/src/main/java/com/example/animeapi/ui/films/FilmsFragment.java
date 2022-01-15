package com.example.animeapi.ui.films;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.animeapi.App;
import com.example.animeapi.R;
import com.example.animeapi.data.models.Film;
import com.example.animeapi.data.romote.OnFilmReadyCallBack;
import com.example.animeapi.databinding.FragmentFilmsBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmsFragment extends Fragment {

    FragmentFilmsBinding binding;
    private FilmsAdapter adapter;
    public FilmsFragment(){

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater,container,false);
        adapter = new FilmsAdapter();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recycler.setAdapter(adapter);
        getData();
        sendDataId();


        App.apiService.getFilms(new OnFilmReadyCallBack() {
            @Override
            public void success(List<Film> films) {
                adapter.setFilms(films);
            }

            @Override
            public void onServerError() {
                Log.e("TAG","onServerError");
            }

            @Override
            public void failure(String msg) {
                Log.e("TAG","failure:"+msg);
            }
        });
    }

    private void getData() {
        App.apiService.getFilms(new OnFilmReadyCallBack() {
            @Override
            public void success(List<Film> list) {
                adapter.setFilms(list);
            }

            @Override
            public void onServerError() {

            }

            @Override
            public void failure(String msg) {

            }
        });
    }

    private void sendDataId() {
        adapter.setOnItemClick(position ->
                Navigation.findNavController(requireView()).navigate(
                        FilmsFragmentDirections.actionFilmsFragmentToFilmDetailFragment(position).setPosition(position)));
    }
}