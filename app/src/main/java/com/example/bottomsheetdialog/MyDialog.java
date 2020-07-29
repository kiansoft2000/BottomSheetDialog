package com.example.bottomsheetdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MyDialog extends BottomSheetDialogFragment {
    private MyDialogeventListener eventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        eventListener = (MyDialogeventListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.my_dialog, container, false);
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


        return view;
    }

    public interface MyDialogeventListener {
        void onOkButtonClicked(String data);

        void onCancelButtonClicked();
    }
}
