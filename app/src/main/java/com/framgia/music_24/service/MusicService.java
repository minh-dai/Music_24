package com.framgia.music_24.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.framgia.music_24.screens.play.MusicPlayer;

import static android.support.v4.util.Preconditions.checkNotNull;

public class MusicService extends Service implements OnMusicListener {

    private final IBinder mBinder = new LocalBinder();
    private MusicPlayer mMusicPlayer;

    public MusicService() {
    }

    public void registerService(MusicPlayer musicPlayer) {
        mMusicPlayer = checkNotNull(musicPlayer);
    }

    public OnMusicListener getListener() {
        return this;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public void setDataSource(String url) {
        mMusicPlayer.setDataSource(url);
    }

    @Override
    public void play() {
        mMusicPlayer.play();
    }

    @Override
    public void next() {
        mMusicPlayer.next();
    }

    @Override
    public void previous() {
        mMusicPlayer.previous();
    }

    @Override
    public void seekTo(int position) {

    }

    public class LocalBinder extends Binder {
        public MusicService getService() {
            return MusicService.this;
        }
    }

    @Override
    public int getCurrentPosition() {
        return mMusicPlayer.getCurrentPosition();
    }

    @Override
    public int getDuration() {
        return mMusicPlayer.getDuration();
    }

    @Override
    public void setLoopOne() {

    }

    @Override
    public void setLoopAll() {

    }

    @Override
    public void setLoopOff() {

    }

    @Override
    public void setShuffle(boolean isShuffle) {

    }
}