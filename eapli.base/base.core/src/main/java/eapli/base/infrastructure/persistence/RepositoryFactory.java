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
package eapli.base.infrastructure.persistence;

import eapli.base.AGVmanagement.AGV.domain.repository.AGVRepository;
import eapli.base.modelmanagement.Model.domain.repositories.ModelRepository;
import eapli.base.brandmanagement.domain.repository.BrandRepository;
import eapli.base.clientusermanagement.repositories.ClientUserRepository;
import eapli.base.clientusermanagement.repositories.SignupRequestRepository;
import eapli.base.categorymanagement.domain.repositories.CategoryRepository;
import eapli.base.ordermanagement.repositories.OrderRepository;
import eapli.base.productmanagement.Product.domain.repositories.ProductRepository;
import eapli.base.surveymanagement.domain.Repository.QuestionnaireRepository;
import eapli.base.warehousemanagement.Domain.Repositories.WarehouseRepository;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.base.customermanagement.domain.repositories.CustomerRepository;
import eapli.framework.infrastructure.authz.domain.repositories.UserRepository;

/**
 * @author Paulo Gandra Sousa
 */
public interface RepositoryFactory {

    /**
     * factory method to create a transactional context to use in the repositories
     *
     * @return
     */
    TransactionalContext newTransactionalContext();

    /**
     * @param autoTx the transactional context to enrol
     * @return
     */
    UserRepository users(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    UserRepository users();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    ClientUserRepository clientUsers(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    ClientUserRepository clientUsers();

    /**
     * @param autoTx the transactional context to enroll
     * @return
     */
    SignupRequestRepository signupRequests(TransactionalContext autoTx);

    /**
     * repository will be created in auto transaction mode
     *
     * @return
     */
    SignupRequestRepository signupRequests();

    CustomerRepository customers(TransactionalContext autoTx);

    CustomerRepository customers();

    ProductRepository products(TransactionalContext autoTx);

    ProductRepository products();

    CategoryRepository category(TransactionalContext autotx);

    CategoryRepository category();

    BrandRepository brands(TransactionalContext autoTx);

    BrandRepository brands();

    AGVRepository AGVs(TransactionalContext autoTx);

    AGVRepository AGVs();

    ModelRepository models(TransactionalContext autoTx);

    ModelRepository models();

    WarehouseRepository Warehouse(TransactionalContext autoTx);

    WarehouseRepository Warehouse();

    OrderRepository Order();

    OrderRepository Order(TransactionalContext autoTx);

    QuestionnaireRepository Questionnaire();

    QuestionnaireRepository Questionnaire(TransactionalContext autoTx);
}
