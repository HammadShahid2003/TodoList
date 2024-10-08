package com.example.todoapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TodoDetailFragment extends Fragment {

    private TextView todoDetailText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_todo_detail, container, false);
        todoDetailText = view.findViewById(R.id.todo_detail_text);
        return view;
    }

    public void updateDetail(String todoDetail) {

            todoDetailText.setText(todoDetail);

    }
}
