package com.example.nakama.browseproduct_cleanarchitecture;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.nakama.browseproduct_cleanarchitecture.di.AppComponent;
import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;
import com.example.nakama.browseproduct_cleanarchitecture.presentation.view.activity.MainActivity;
import com.example.nakama.browseproduct_cleanarchitecture.util.RecyclerViewMatcher;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import io.reactivex.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

/**
 * Created by Rizky on 12/02/18.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Inject
    AceRepository aceRepository;

    @Singleton
    @Component(modules = { MockNetModule.class })
    public interface TestComponent extends AppComponent {

        void inject(MainActivityTest mainActivityTest);

    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(
            MainActivity.class,
            true,
            false);

    @Before
    public void setup() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        MockApplication app = (MockApplication) instrumentation.getTargetContext().getApplicationContext();

        TestComponent testComponent = (TestComponent) app.getComponent();

        testComponent.inject(this);
    }

    @Test
    public void searchProducts_showResults() {
        String productName = "iphone x";
        Product product = new Product(productName, "image url");
        List<Product> products = new ArrayList<>();
        products.add(product);
        Observable<List<Product>> productObservable = Observable.just(products);

        when(aceRepository.getProducts("android", "test", productName, 12, 1))
                .thenReturn(productObservable);

        activityRule.launchActivity(new Intent());

        onView(withId(R.id.et_search)).perform(ViewActions.typeText(productName));
        onView(withId(R.id.et_search)).perform(ViewActions.pressImeActionButton());

        onView(listMatcher().atPosition(0)).check(matches(hasDescendant(withText(productName))));
    }

    @NonNull
    private RecyclerViewMatcher listMatcher() {
        return new RecyclerViewMatcher(R.id.recyclerview);
    }

}
