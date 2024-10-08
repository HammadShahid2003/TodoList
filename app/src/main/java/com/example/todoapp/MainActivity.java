package com.example.todoapp;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements TodoListFragment.OnTodoItemClickListener {
    LinearLayout portraitLayout;
    LinearLayout landscapeLayout;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // This will automatically choose the correct layout based on orientation

        init();

        // Show the correct fragments based on the orientation
        if (portraitLayout != null) {
            showTitleFragment(); // Show only the title fragment in portrait mode
        } else if (landscapeLayout != null) {
            showBothFragments(); // Show both fragments in landscape mode
        }
    }

    private void showTitleFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        TodoListFragment listFragment = new TodoListFragment();
        transaction.replace(R.id.listfrag, listFragment);
        transaction.commit();
    }

    private void showBothFragments() {
        FragmentTransaction transaction = manager.beginTransaction();
        TodoListFragment listFragment = new TodoListFragment();
        TodoDetailFragment detailFragment = new TodoDetailFragment();

        transaction.replace(R.id.listfrag, listFragment);
        transaction.replace(R.id.detailfrag, detailFragment);
        transaction.commit();
    }

    @Override
    public void onTodoItemClicked(int position) {
        String todoDetail = "Details for Todo " + (position + 1);


        if (landscapeLayout != null) {
            TodoDetailFragment detailFragment = (TodoDetailFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.detailfrag);
            if (detailFragment != null) {
                detailFragment.updateDetail(todoDetail);
            }
        } else {
            TodoDetailFragment detailFragment = new TodoDetailFragment();
            TodoListFragment listFragment = new TodoListFragment();
            Bundle args = new Bundle();
            args.putString("todo_detail", todoDetail);
            detailFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(listFragment).show(detailFragment);



            transaction.addToBackStack(null);
            transaction.commit();
        }
    }

    private void init() {
        portraitLayout = findViewById(R.id.potrait);
        landscapeLayout = findViewById(R.id.landscape); // Add this line to initialize the landscape layout
        manager = getSupportFragmentManager();
    }
}
