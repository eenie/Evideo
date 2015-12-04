package com.neusoft.eenie.evideo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.MediaController;

/**
 * Created by Eenie on 2015/12/3.
 *
 *
 */
public class BaseMediaController extends MediaController  {


    private MediaControllerStateListener mediaControllerStateListener;


    public BaseMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseMediaController(Context context) {
        super(context);
    }

    public BaseMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }


    public MediaControllerStateListener getMediaControllerStateListener() {
        return mediaControllerStateListener;
    }

    public void setMediaControllerStateListener(MediaControllerStateListener mediaControllerStateListener) {
        this.mediaControllerStateListener = mediaControllerStateListener;
    }

    @Override
    public void show(int timeout) {
        super.show(timeout);
        if (mediaControllerStateListener != null) {
            mediaControllerStateListener.showWindow();
        }
    }


    @Override
    public void hide() {
        super.hide();

        if (mediaControllerStateListener != null) {
            mediaControllerStateListener.hideWindow();
        }
    }


}
