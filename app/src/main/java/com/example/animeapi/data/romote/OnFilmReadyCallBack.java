package com.example.animeapi.data.romote;

import com.example.animeapi.data.models.Film;

import java.util.List;

public interface OnFilmReadyCallBack {
    void success (List<Film> films);
    void onServerError();
    void failure(String msg);

}
