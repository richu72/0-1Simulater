package com.websarva.wings.android.a0_1simulator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class YesNoDialog extends DialogFragment {
    simulation sm;
    public boolean flag_save = false;
    @NonNull
    @Override
    public Dialog onCreateDialog(@NonNull Bundle savedInstanceState) {
        //ダイアログビルダーの生成
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //ダイアログのタイトルを設定
        builder.setTitle((R.string.dialog_title));
        //ダイアログのメッセージを設定
        builder.setMessage(R.string.dialog_msg);
        //YESボタン
        builder.setPositiveButton(R.string.dialog_btn_yes, new DialogButtonClickListener());
        //NOボタン
        builder.setNegativeButton(R.string.dialog_btn_no, new DialogButtonClickListener());
        //ダイアログオブジェクトを生成し、リターン
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            //タップされたアクションボタンで分岐。
            System.out.println(which);
            switch (which) {
                //Positive Buttonならば…
                case DialogInterface.BUTTON_POSITIVE:
                    flag_save = true;
                    break;
                //Negative Buttonならば…
                case DialogInterface.BUTTON_NEGATIVE:
                    flag_save = false;
                    break;
            }
        }
    }
}
