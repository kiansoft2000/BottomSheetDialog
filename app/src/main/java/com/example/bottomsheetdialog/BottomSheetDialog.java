package com.example.bottomsheetdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class BottomSheetDialog extends DialogFragment {
    private MyDialogeventListener eventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        eventListener= (MyDialogeventListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.bottom_sheet_dialog, null, false);
        builder.setView(view);
        Button okBtn = view.findViewById(R.id.btn_dialog_ok);
        Button cancelBtn = view.findViewById(R.id.btn_dialog_cancel);
        final EditText editText = view.findViewById(R.id.et_dialog_input);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.length() > 0) {
                    eventListener.onOkButtonClicked(editText.getText().toString());
                    //View view1 = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, null, false);
                    //TextView textView = view1.findViewById(R.id.tv_main);
                    //textView.setText(editText.getText().toString());
                    dismiss();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventListener.onCancelButtonClicked();
                dismiss();
            }
        });

        return builder.create();
    }

    public interface MyDialogeventListener {
        void onOkButtonClicked(String data);

        void onCancelButtonClicked();
    }
}
