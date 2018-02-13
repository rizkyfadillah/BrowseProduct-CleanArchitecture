package com.example.nakama.browseproduct_cleanarchitecture.domain.interactor;

import com.example.nakama.browseproduct_cleanarchitecture.domain.model.Product;
import com.example.nakama.browseproduct_cleanarchitecture.domain.repository.AceRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Nakama on 12/07/2017.
 */

public class GetProductsUseCase extends UseCase<List<Product>, GetProductsUseCase.Params> {

    private AceRepository aceRepository;

    public GetProductsUseCase(AceRepository aceRepository, Scheduler subscribeScheduler, Scheduler observeScheduler) {
        super(subscribeScheduler, observeScheduler);
        this.aceRepository = aceRepository;
    }

    @Override
    Observable<List<Product>> buildUseCaseObservable(Params params) {
        return aceRepository.getProducts(params.device, params.source, params.q, params.rows, params.start);
    }

    public static final class Params {
        private final String device;
        private final String source;
        private final String q;
        private final int rows;
        private final int start;

        public Params(String device, String source, String q, int rows, int start) {
            this.device = device;
            this.source = source;
            this.q = q;
            this.rows = rows;
            this.start = start;
        }
    }

}
