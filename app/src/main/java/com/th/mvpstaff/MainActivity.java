package com.th.mvpstaff;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.th.mvpstaff.databinding.ActivityMainBinding;
import com.th.mvpstaff.livedata.LiveDataDemoActivity;
import com.th.mvpstaff.mvc.MvcDemoActivity;
import com.th.mvpstaff.mvp.MvpDemoActivity;
import com.th.mvpstaff.mvvm.MvvmActivity;

import java.util.ArrayList;
import java.util.List;

class Item {
    public String title;
    public Class<? extends Activity> activityClass;

    public Item(String title, Class<? extends Activity> activityClass) {
        this.title = title;
        this.activityClass = activityClass;
    }
}

class SimpleVH extends RecyclerView.ViewHolder {
    public SimpleVH(@NonNull View itemView) {
        super(itemView);
    }
}

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private List<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        items.add(new Item("MVP", MvpDemoActivity.class));
        items.add(new Item("MVC", MvcDemoActivity.class));
        items.add(new Item("MVVM", MvvmActivity.class));
        items.add(new Item("LiveData", LiveDataDemoActivity.class));

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        binding.rv.setAdapter(new RecyclerView.Adapter<SimpleVH>() {
            @NonNull
            @Override
            public SimpleVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                // so what's the layout param?
                View textView = new TextView(parent.getContext());
                textView.setPadding(20, 20, 20, 20);
                return new SimpleVH(textView);
            }

            @Override
            public void onBindViewHolder(@NonNull SimpleVH holder, int position) {
                Item item = items.get(position);
                ((TextView)holder.itemView).setText(item.title);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), item.activityClass);
                        startActivity(intent);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return items.size();
            }
        });
    }
}