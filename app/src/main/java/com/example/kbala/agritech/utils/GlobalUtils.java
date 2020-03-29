package com.example.kbala.agritech.utils;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.kbala.agritech.R;
import com.example.kbala.agritech.interfaces.DialogCallback;
import com.example.kbala.agritech.widgets.CustomDialog;
import com.hsalf.smilerating.SmileRating;

import static android.content.ContentValues.TAG;

public class GlobalUtils {
    public static String ratings = "Not Given Yet";

    public static void showDialog(Context context, final DialogCallback dialogCallback)
    {
        final CustomDialog dialog = new CustomDialog(context,R.style.CustomDialogTheme);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.layout_dialog,null);

        dialog.setContentView(v);

        TextView btn_done = dialog.findViewById(R.id.btn_done);
        SmileRating smileRating = dialog.findViewById(R.id.smile_rating);



        smileRating.setOnSmileySelectionListener(new SmileRating.OnSmileySelectionListener() {
            @Override
            public void onSmileySelected(int smiley, boolean reselected) {
                switch (smiley){
                    case SmileRating.BAD:
                        Log.i(TAG,"BAD");
                        ratings = "Bad";
                    case SmileRating.GOOD:
                        Log.i(TAG,"GOOD");
                        ratings = "Good";
                    case SmileRating.GREAT:
                        Log.i(TAG,"GREAT");
                        ratings = "Great";
                    case SmileRating.OKAY:
                        Log.i(TAG,"OKAY");
                        ratings = "Okay";
                    case SmileRating.TERRIBLE:
                        Log.i(TAG,"TERRIBLE");
                        ratings = "Terrible";
                        }
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dialogCallback != null)
                    dialogCallback.callback(ratings);
                dialog.dismiss();
            }
        });

        dialog.show();


    }
}
