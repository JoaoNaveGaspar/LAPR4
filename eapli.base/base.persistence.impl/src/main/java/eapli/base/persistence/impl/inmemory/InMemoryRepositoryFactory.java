/*
 * Copyright (c) 2013-2021 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eapli.base.persistence.impl.inmemory;

import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.base.infrastructure.bootstrapers.BaseBootstrapper;
import eapli.base.infrastructure.persistence.RepositoryFactory;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;
import eapli.base.categorymanagement.domain.repositories.CategoryRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;
import eapli.base.warehousemanagement.Domain.Repositories.WarehouseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;
import eapli.framework.infrastructure.authz.repositories.impl.InMemoryUserRepository;

/**
 * Created by nuno on 20/03/16.
 */
public class InMemoryRepositoryFactory implements RepositoryFactory {

    static {
        // only needed because of the in memory persistence
        new BaseBootstrapper().execute();
    }

    @Override
    public UserRepository users(final TransactionalContext tx) {
        return new InMemoryUserRepository();
    }

    @Override
    public UserRepository users() {
        return users(null);
    }

    @Override
    public ClientUserRepository clientUsers(final TransactionalContext tx) {

        return new InMemoryClientUserRepository();
    }

    @Override
    public OrderRepository Order(TransactionalContext autoTx) {
        return new InMemoryOrderRepository();
    }

    @Override
    public OrderRepository Order() {
        return Order(null);
    }

    @Override
    public QuestionnaireRepository Questionnaire() {
        return Questionnaire(null);
    }

    @Override
    public QuestionnaireRepository Questionnaire(TransactionalContext autoTx) {
        return new InMemoryQuestionnaireRepository();
    }

    @Override
    public ClientUserRepository clientUsers() {
        return clientUsers(null);
    }

    @Override
    public SignupRequestRepository signupRequests() {
        return signupRequests(null);
    }

    @Override
    public CustomerRepository customers(TransactionalContext autoTx) {
        return new InMemoryCustomerRepository();
    }

    @Override
    public CustomerRepository customers() {
        return customers(null);
    }

    @Override
    public ProductRepository products(TransactionalContext autoTx) {
        return new InMemoryProductRepository();
    }

    @Override
    public ProductRepository products() {
        return products(null);
    }

    @Override
    public CategoryRepository category(TransactionalContext autotx) {
        return new InMemoryCategoryRepository();
    }

    @Override
    public CategoryRepository category() {
        return category(null);
    }

    @Override
    public BrandRepository brands(TransactionalContext autoTx) {
        return new InMemoryBrandRepository();
    }

    @Override
    public BrandRepository brands() {
        return brands(null);
    }

    @Override
    public AGVRepository AGVs(TransactionalContext autoTx) {
        return new InMemoryAGVRepository();
    }

    @Override
    public AGVRepository AGVs() {
        return AGVs(null);
    }

    @Override
    public ModelRepository models(TransactionalContext autoTx) {
        return new InMemoryModelRepository();
    }

    @Override
    public ModelRepository models() {
        return models(null);
    }

    @Override
    public WarehouseRepository Warehouse(TransactionalContext autoTx) {
        return new InMemoryWarehouseRepository();
    }

    @Override
    public WarehouseRepository Warehouse() {
        return Warehouse(null);
    }

    @Override
    public SignupRequestRepository signupRequests(final TransactionalContext tx) {
        return new InMemorySignupRequestRepository();
    }

    @Override
    public TransactionalContext newTransactionalContext() {
        // in memory does not support transactions...
        return null;
    }

}
