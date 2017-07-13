package com.example.nakama.browseproduct_cleanarchitecture.presentation.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nakama.browseproduct_cleanarchitecture.BrowseProductApplication;
import com.example.nakama.browseproduct_cleanarchitecture.di.MainActivityModule;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;
import com.example.nakama.browseproduct_cleanarchitecture.R;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenter;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenterImpl;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.MainView;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.adapter.ProductAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
    implements MainView {

    @BindView(R.id.et_search) EditText etSearch;
    @BindView(R.id.recyclerview) RecyclerView recyclerView;

    @Inject
    MainPresenter mainPresenter;

    private List<ProductModel> productModelList = new ArrayList<>();
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        injectDependencies();

        ButterKnife.bind(this);

        mainPresenter.setView(this);

        productAdapter = new ProductAdapter(productModelList);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(productAdapter);

        etSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    mainPresenter.getProducts("android", "test", etSearch.getText().toString(), 12, 1);
                    return true;
                }
                return false;
            }
        });
    }

    private void injectDependencies() {
        BrowseProductApplication.getComponent()
                .plus(new MainActivityModule())
                .inject(this);
    }

    @Override
    public void showProducts(List<ProductModel> productModels) {
        productModelList.clear();
        productModelList.addAll(productModels);
        productAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.destroy();
    }
}
