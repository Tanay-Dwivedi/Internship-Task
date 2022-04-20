package com.play.physicswallahtask;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyPreview {

    RequestQueue requestQueue;
    private static  VolleyPreview volleyInstance;

    VolleyPreview(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized VolleyPreview getInstance(Context context) {

        if (volleyInstance == null) {
            volleyInstance = new VolleyPreview(context);
        }
        return volleyInstance;
    }

    RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
