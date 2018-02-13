package com.example.nakama.browseproduct_cleanarchitecture;

import com.example.nakama.browseproduct_cleanarchitecture.domain.interactor.GetProductsUseCase;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.mapper.ProductModelDataMapper;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.model.ProductModel;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.presenter.MainPresenterImpl;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.MainView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Rizky on 12/02/18.
 */

public class MainPresenterTest {

    private MainPresenterImpl mainPresenter;

    @Mock
    private AceRepository aceRepository;

    @Mock
    private MainView mainView;

    private GetProductsUseCase getProductsUseCase;

    private ProductModelDataMapper productModelDataMapper;

    private TestScheduler testScheduler;

    @Before
    public void setupMainPresenter() {
        MockitoAnnotations.initMocks(this);

        testScheduler = new TestScheduler();

        getProductsUseCase = new GetProductsUseCase(aceRepository, testScheduler, testScheduler);

        productModelDataMapper = new ProductModelDataMapper();

        mainPresenter = new MainPresenterImpl(getProductsUseCase, new ProductModelDataMapper());
        mainPresenter.setView(mainView);
    }

    @Test
    public void test() {
        Product product = new Product("iphone x", "");
        List<Product> products = new ArrayList<>();
        products.add(product);

        when(aceRepository.getProducts("android", "test", "iphone x", 12, 1))
                .thenReturn(Observable.just(products));

        List<ProductModel> productModels = productModelDataMapper.transform(products);

        mainPresenter.getProducts("android", "test", "iphone x", 12, 1);

        testScheduler.triggerActions();

        verify(mainView).showProducts(productModels);
    }

}
